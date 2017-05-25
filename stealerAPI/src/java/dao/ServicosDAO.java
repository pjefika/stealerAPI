/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.Item;
import model.InventarioServico;

/**
 *
 * @author G0041775
 */
public class ServicosDAO implements InterfaceDAO<InventarioServico> {

    private br.com.gvt.oss.inventory.service.impl.InventoryService service;
    private br.com.gvt.oss.inventory.service.impl.InventoryImpl port;
    private com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse result;
    private String designator, velDown, velUp, linha, tv;

    public ServicosDAO() {
    }

    public ServicosDAO(String designator, br.com.gvt.oss.inventory.service.impl.InventoryService srv, br.com.gvt.oss.inventory.service.impl.InventoryImpl prt) {
        this.designator = designator;
        this.service = srv;
        this.port = prt;
    }

    public void getAccountItems() {
        if (this.result == null) {
            this.result = port.getAccountItems(null, null, designator, null, false);
        }
    }

    private void getBanda(InventarioServico i) {
        this.getAccountItems();
        result.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((item) -> {
                    for (com.gvt.ws.eai.oss.inventory.api.Item itn : item.getItems()) {
                        if (itn.getStatusName().equals("ACTIVE") || itn.getStatusName().equals("PENDING")) {
                            for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                                if (param.getName().equals("Downstream")) {
                                    velDown = param.getValue();
                                }
                                if (param.getName().equals("Upstream")) {
                                    velUp = param.getValue();
                                }
                            }
                        }
                    }
                });
            });
        });

        i.setVelDown(new Long(velDown));
        i.setVelUp(new Long(velUp));
    }

    private void getLinha(InventarioServico i) {
        this.getAccountItems();
        result.getAccounts().forEach((Account acc) -> {
            for (com.gvt.ws.eai.oss.inventory.api.Address adr : acc.getAddress()) {
                for (com.gvt.ws.eai.oss.inventory.api.Item item : adr.getItems()) {
                    for (com.gvt.ws.eai.oss.inventory.api.Item itn : item.getItems()) {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equals("TecnologiaVoz")) {
                                linha = param.getValue();
                            }
                        }
                    }
                }
            }
        });
        if (linha == null) {
            linha = "SIP";
        }

        i.setIsSip(linha.contains("SIP"));
    }

    private void getTv(InventarioServico i) {
        this.getAccountItems();
        result.getAccounts().forEach((acc) -> {
            acc.getAddress().forEach((adr) -> {
                adr.getItems().forEach((Item item) -> {
                    item.getItems().forEach((Item itn) -> {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equalsIgnoreCase("TecnologiaTV")) {
                                if (param.getValue() != null) {
                                    if (param.getValue().contains("brid")) {
                                        i.setIsHib(true);
                                    }
                                }
                            }
                        }
                    });
                });
            });
        });

        if (i.getIsHib() == null) {
            i.setIsHib(Boolean.TRUE);
        }

    }

    public InventarioServico consultar() throws Exception {

        InventarioServico serv = new InventarioServico();

        this.getBanda(serv);
        this.getLinha(serv);
        this.getTv(serv);

        return serv;
    }

    @Override
    public InventarioServico consultar(String param1) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cadastrar(InventarioServico obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
