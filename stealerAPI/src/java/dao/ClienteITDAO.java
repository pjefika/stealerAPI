
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.InventarioRede;
import br.net.gvt.efika.customer.InventarioServico;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
import dao.exception.FalhaInputException;
import exception.ossturbonet.oss.gvt.com.OSSTurbonetException;
import model.FactoryService;
import model.domain.EfikaCustomerDTO;
import model.domain.InventarioRedeAdapter;
import util.TratativaDesignadores;

/**
 *
 * @author G0041775
 */
public class ClienteITDAO extends AbstractOssDAO implements EfikaCustomerInterface {

    private InventoryAccountResponse result;

    public ClienteITDAO() {
        ws = new OSSTurbonetProxy();
    }

    /**
     * Consulta aos Serviços de IT - Cadastro - Designador - Serviços
     *
     * @param designador
     * @return
     * @throws Exception
     */
    @Override
    public EfikaCustomerDTO consultarCliente(String designador) throws Exception {
        EfikaCustomerDTO c = new EfikaCustomerDTO(designador);
        getAssociatedDesignators(c);
        //bloco de try adicionado para que retorne cliente apenas com servicos ou apenas rede ao invés de extourar exception
        try {
            c.setRede(consultarInventarioRede(c.getDesignador()));
        } catch (OSSTurbonetException e) {
            throw new FalhaInputException();
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

    public void getAssociatedDesignators(EfikaCustomerDTO c) throws FalhaInputException {
        port = FactoryService.create().getInventoryImplPort();

        InventoryDesignatorsResponse id = port.getAssociatedDesignators(c.getDesignador(), null);

        if (id == null) {
            throw new FalhaInputException();
        }

        new TratativaDesignadores(id, c).getC();
    }

    public GetInfoOut getInfo(String designador) throws Exception {
        String designator = this.getDesignador(designador);
        String accessDesignator = this.getAccessDesignator(designator);
        return ws.getInfo(designator, accessDesignator, "wise", "wise", designator, "wise", "0", "0");
    }

    public String getAccessDesignator(String designador) throws Exception {
        return ws.getAccessDesignator(designador);
    }

    private void getAccountItems(String designator) {
        if (this.result == null) {
            this.result = port.getAccountItems(null, null, designator, null, true);
        }
    }

    private void getBanda(InventarioServico i) {
        result.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    item.getItems().stream().filter((itn) -> (itn.getStatusName().equalsIgnoreCase("ACTIVE") || itn.getStatusName().equalsIgnoreCase("PENDING"))).forEachOrdered((itn) -> {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equalsIgnoreCase("Downstream")) {
                                i.setVelDown(new Long(param.getValue()));
                            }
                            if (param.getName().equalsIgnoreCase("Upstream")) {
                                i.setVelUp(new Long(param.getValue()));
                            }
                            if (i.getVelDown() != null && i.getVelUp() != null) {
                                break;
                            }
                        }
                    });
                });
            });
        });
    }

    private void getLinha(InventarioServico i) {
        result.getAccounts().forEach((Account acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    item.getItems().stream().filter((itn) -> (itn.getStatusName().equalsIgnoreCase("ACTIVE") || itn.getStatusName().equalsIgnoreCase("PENDING"))).forEachOrdered((itn) -> {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equalsIgnoreCase("TecnologiaVoz")) {
                                if (param.getValue().toUpperCase().contains("SIP")) {
                                    i.setIsSip(Boolean.TRUE);
                                }
                                if (param.getValue().toUpperCase().contains("TDM")) {
                                    i.setIsSip(Boolean.FALSE);
                                }
                            }
                        }
                    });
                });
            });
        });

        if (i.getIsSip() == null || i.getIsSip()) {
            i.setIsSip(Boolean.TRUE);
        } else {
            i.setIsSip(Boolean.FALSE);
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
                                        i.setIsHib(true);
                                        return;
                                    }
                                    if (param.getValue().toUpperCase().contains("DTH")) {
                                        i.setIsHib(false);
                                        return;
                                    }
                                }
                            }
                        }
                    });
                });
            });
        });

        if (i.getIsHib() == null) {
            i.setIsHib(Boolean.FALSE);
        }

    }

    @Override
    public InventarioRede consultarInventarioRede(String param1) throws Exception {
        return InventarioRedeAdapter.adapter(getInfo(param1));
    }

}
