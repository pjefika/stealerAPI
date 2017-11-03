
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioRede;
import br.net.gvt.efika.customer.InventarioServico;
import br.net.gvt.efika.enums.TecnologiaLinha;
import br.net.gvt.efika.enums.TecnologiaTv;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;
import dao.exception.CircuitoNaoEncontradoException;
import dao.exception.ClienteSemBandaException;
import dao.exception.InstanciaInvalidaException;
import exception.ossturbonet.oss.gvt.com.OSSTurbonetException;
import model.asserts.facade.AssertFacadeFulltestCRM;
import model.domain.InventarioRedeAdapter;
import model.service.tratativa.TratativaAssociatedDesignators;

/**
 *
 * @author G0041775
 */
public class ClienteITDAO extends AbstractOssDAO implements ConsultaEfikaCustomer {

    private InventoryAccountResponse result;

    private EfikaCustomer c;

    private GetInfoOut info;

    public ClienteITDAO() {
        ws = FactoryITService.createOss();
    }

    /**
     * Consulta aos Serviços de IT - Cadastro - Designador - Serviços
     *
     * @param designador
     * @return
     * @throws Exception
     */
    @Override
    public EfikaCustomer consultar(String designador) throws Exception {
        c = new EfikaCustomer(designador);
        getAssociatedDesignators(c);
        //bloco de try adicionado para que retorne cliente apenas com servicos ou apenas rede ao invés de extourar exception
        try {
            c.setRede(consultarInventarioRede(c.getDesignador()));
            c.setAsserts(new AssertFacadeFulltestCRM(info).assertThese());
        } catch (OSSTurbonetException e) {
            e.printStackTrace();
            String erro = e.getFaultString();
            System.out.println("erro:" + erro);
            if (erro.contains("Nao consta no TBS DSLAM cadastrado para este designador")
                    || erro.contains("NAO ENCONTROU ASSINALAMENTO PARA O CIRCUITO")
                    || erro.contains("CIRCUITO NAO ENCONTRADO PARA O DESIGNADOR")) {
                throw new CircuitoNaoEncontradoException();
            } else {
                throw new InstanciaInvalidaException();
            }
        }
        try {
            c.setServicos(consultarInventarioServico(c.getDesignador()));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        cadastrar(c);
        return c;
    }

    @Override
    public InventarioServico consultarInventarioServico(String instancia) throws Exception {

        InventarioServico serv = new InventarioServico();

        this.getAccountItems(instancia.trim());
        this.getBanda(serv);
        this.getLinha(serv);
        this.getTv(serv);

        return serv;
    }

    protected String getDesignador(String s) throws Exception {
        return ws.getDesignatorByAccessDesignator(s);
    }

    public void getAssociatedDesignators(EfikaCustomer c) throws InstanciaInvalidaException, ClienteSemBandaException {
        port = FactoryITService.createInvServ().getInventoryImplPort();

        InventoryDesignatorsResponse id = port.getAssociatedDesignators(c.getDesignador(), null);

        if (id.getDesignator().isEmpty()) {
            throw new InstanciaInvalidaException();
        }

        new TratativaAssociatedDesignators(id, c, null).getC();

        if (c.getDesignador().equalsIgnoreCase(c.getInstancia())) {
            throw new ClienteSemBandaException();
        }
    }

    public GetInfoOut getInfo(String designador) throws Exception {
        if (info == null) {
//            String designator = this.getDesignador(designador);
            info = ws.getInfo(c.getDesignador(), c.getDesignadorAcesso(), "wise", "wise", c.getDesignador(), "wise", "0", "0");
        }
        return info;
    }

    public String getAccessDesignator(String designador) throws Exception {
        return ws.getAccessDesignator(designador);
    }

    private void getAccountItems(String designator) {
//        if (this.result == null) {
        this.result = port.getAccountItems(null, null, designator, null, true);
//        }
    }

    private void getBanda(InventarioServico i) {
        result.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    item.getItems().stream().filter((itn) -> ((itn.getStatusName().equalsIgnoreCase("ACTIVE")
                            || itn.getStatusName().equalsIgnoreCase("PENDING"))) && itn.getDesignator().getValue().equalsIgnoreCase(c.getDesignador())).forEachOrdered((itn) -> {

                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            System.out.println(itn.getStatusName() + "->" + itn.getModifiedDate().getValue());
                            System.out.println(param.getName() + "->" + param.getValue());
                            if (param.getName().equalsIgnoreCase("Downstream")) {
                                i.setVelDown(new Long(param.getValue()));
                            }
                            if (param.getName().equalsIgnoreCase("Upstream")) {
                                i.setVelUp(new Long(param.getValue()));
                            }
//                            if (i.getVelDown() != null && i.getVelUp() != null) {
//                                break;
//                            }
                        }
                    });
                });
            });
        });
        System.out.println("getBanda");
    }

    private void getLinha(InventarioServico i) {
        result.getAccounts().forEach((Account acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    item.getItems().stream().filter((itn) -> (itn.getStatusName().equalsIgnoreCase("ACTIVE") || itn.getStatusName().equalsIgnoreCase("PENDING"))).forEachOrdered((itn) -> {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equalsIgnoreCase("TecnologiaVoz")) {
                                if (param.getValue().toUpperCase().contains("SIP")) {
                                    i.setTipoLinha(TecnologiaLinha.SIP);
                                }
                                if (param.getValue().toUpperCase().contains("TDM")) {
                                    i.setTipoLinha(TecnologiaLinha.TDM);
                                }
                                if (param.getValue().toUpperCase().contains("V5")) {
                                    i.setTipoLinha(TecnologiaLinha.IMS_V5);
                                }
                                if (param.getValue().toUpperCase().contains("IMS/H248")) {
                                    i.setTipoLinha(TecnologiaLinha.IMS_H248);
                                }
                                if (i.getTipoLinha() != null) {
                                    break;
                                }
                            }
                        }
                    });
                });
            });
        });

        if (i.getTipoLinha() == null) {
            i.setTipoLinha(TecnologiaLinha.SIP);
        }

    }

    private void getTv(InventarioServico i) {
        result.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((Item item) -> {
                    item.getItems().stream().filter((itn) -> (itn.getStatusName().equalsIgnoreCase("ACTIVE") || itn.getStatusName().equalsIgnoreCase("PENDING"))).forEachOrdered((itn) -> {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equalsIgnoreCase("TecnologiaTV")) {
                                if (param.getValue() != null) {
                                    if (param.getValue().toUpperCase().contains("BRID")) {
                                        i.setTipoTv(TecnologiaTv.HIBRIDA);
                                        return;
                                    }
                                    if (param.getValue().toUpperCase().contains("DTH")) {
                                        i.setTipoTv(TecnologiaTv.DTH);
                                        return;
                                    }
                                    if (param.getValue().toUpperCase().contains("IPTV")) {
                                        i.setTipoTv(TecnologiaTv.IPTV);
                                        return;
                                    }
                                }
                            }
                        }
                    });
                });
            });
        });

    }

    @Override
    public InventarioRede consultarInventarioRede(String param1) throws Exception {
        return InventarioRedeAdapter.adapter(getInfo(param1));
    }

}
