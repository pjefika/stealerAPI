/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioServico;
import br.net.gvt.efika.enums.TecnologiaLinha;
import br.net.gvt.efika.enums.TecnologiaTv;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;

/**
 *
 * @author G0042204
 */
public class TratativaInventarioServicos extends TratativaEfikaCustomer {

    private final InventoryAccountResponse account;

    public TratativaInventarioServicos(InventoryAccountResponse account, EfikaCustomer c) {
        super(c);
        this.account = account;
    }

    @Override
    public void tratar() throws Exception {
        getC().setServicos(this.consultarInventarioServico());
    }

    protected InventarioServico consultarInventarioServico() throws Exception {

        InventarioServico serv = new InventarioServico();

        this.getBanda(serv);
        this.getLinha(serv);
        this.getTv(serv);

        return serv;
    }

    private void getBanda(InventarioServico i) {
        account.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    item.getItems().stream().filter((itn) -> ((itn.getStatusName().equalsIgnoreCase("ACTIVE")
                            || itn.getStatusName().equalsIgnoreCase("PENDING"))) && itn.getDesignator().getValue().equalsIgnoreCase(getC().getDesignador())).forEachOrdered((itn) -> {

                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
//                            System.out.println(itn.getStatusName() + "->" + itn.getModifiedDate().getValue());
//                            System.out.println(param.getName() + "->" + param.getValue());
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
//        System.out.println("getBanda");
    }

    private void getLinha(InventarioServico i) {
        account.getAccounts().forEach((Account acc) -> {
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
        account.getAccounts().forEach((acc) -> {
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

}
