/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;

/**
 *
 * @author G0041775
 */
public class ProdutosDAO {

    private br.com.gvt.oss.inventory.service.impl.InventoryService service = new br.com.gvt.oss.inventory.service.impl.InventoryService();
    private br.com.gvt.oss.inventory.service.impl.InventoryImpl port = service.getInventoryImplPort();
    private com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse result;
    private String designator, velDown, velUp, linha, tv;

    public ProdutosDAO(String designator) {
        this.designator = designator;
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
        if(linha == null){
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
                                tv =  param.getValue();
                            }
                        }
                    }
                }
            }
        }
        if(tv == null){
            tv = "";
        }
    }

    public Cliente getProdCliente(Cliente c) {

        this.getBanda();
        this.getLinha();
        this.getTv();
        
        c.setVelDown(new Long(velDown));
        c.setVelUp(new Long(velUp));
        c.setIsSip(linha.contains("SIP"));
        c.setIsHib(tv.contains("brid"));

        return c;
    }

}
