/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public void getBanda() {
        this.getAccountItems();
        for (com.gvt.ws.eai.oss.inventory.api.Account acc : result.getAccounts()) {
            for (com.gvt.ws.eai.oss.inventory.api.Address adr : acc.getAddress()) {
                for (com.gvt.ws.eai.oss.inventory.api.Item item : adr.getItems()) {
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
                }
            }
        }
    }

    public void getLinha() {
        this.getAccountItems();
        for (com.gvt.ws.eai.oss.inventory.api.Account acc : result.getAccounts()) {
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
        }
        if (linha == null) {
            linha = "SIP";
        }
//        if (linha.getTipo() == null) {
//            linha.setTipo("SIP ACESSO");
//        }

    }

    public void getTv() {
        this.getAccountItems();
        for (com.gvt.ws.eai.oss.inventory.api.Account acc : result.getAccounts()) {
            for (com.gvt.ws.eai.oss.inventory.api.Address adr : acc.getAddress()) {
                for (com.gvt.ws.eai.oss.inventory.api.Item item : adr.getItems()) {
                    for (com.gvt.ws.eai.oss.inventory.api.Item itn : item.getItems()) {
                        for (com.gvt.ws.eai.oss.inventory.api.Param param : itn.getParam()) {
                            if (param.getName().equals("TecnologiaTV")) {
                                tv = param.getValue();
                            }
                        }
                    }
                }
            }
        }
        if (tv == null) {
            tv = "";
        }
    }

    public InventarioServico consultar() throws Exception {

        InventarioServico serv = new InventarioServico();

        this.getBanda();
        this.getLinha();
        this.getTv();

        serv.setIsHib(tv.contains("brid"));
        serv.setIsSip(linha.contains("SIP"));
        serv.setVelDown(new Long(velDown));
        serv.setVelUp(new Long(velUp));

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
