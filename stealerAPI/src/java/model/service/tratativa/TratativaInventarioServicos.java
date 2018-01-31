/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioServico;
import br.net.gvt.efika.enums.OrigemPlanta;
import br.net.gvt.efika.enums.TecnologiaLinha;
import br.net.gvt.efika.enums.TecnologiaTv;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.Address;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;
import com.gvt.ws.eai.oss.inventory.api.Param;

/**
 *
 * @author G0042204
 */
public class TratativaInventarioServicos extends TratativaEfikaCustomer {

    private transient String address;

    public TratativaInventarioServicos(InventoryAccountResponse account, EfikaCustomer c) {
        super(c);
        this.account = account;
    }

    @Override
    public void tratar() throws Exception {
        getC().setServicos(this.consultarInventarioServico());
        getNetworkSpecifics();
    }

    protected InventarioServico consultarInventarioServico() throws Exception {

        InventarioServico serv = new InventarioServico();
        this.setAddress();

        this.getBanda(serv);
        this.getLinha(serv);
        this.getTv(serv);

        return serv;
    }

    private void setAddress() {
        for (Account account1 : account.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                for (Item item : addres.getItems()) {
                    if (getC().getDesignadorAcesso().equalsIgnoreCase(item.getDesignator().getValue())
                            || getC().getInstancia().equalsIgnoreCase(item.getDesignator().getValue())) {
                        address = addres.getExternalId();
                    }
                }
            }
        }
    }

    private void getNetworkSpecifics() {
        for (Account account1 : account.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (addres.getExternalId().equalsIgnoreCase(address)) {
                    for (Item item : addres.getItems()) {
                        if ((item.getStatusName().equalsIgnoreCase("ACTIVE") || item.getStatusName().equalsIgnoreCase("PENDING"))
                                && (item.getSpecIdName().equalsIgnoreCase("Wired Access") || item.getSpecIdName().equalsIgnoreCase("Fiber Access"))) {
                            for (Param param : item.getParam()) {
                                if (param.getName().equalsIgnoreCase("NetworkOwner")) {
                                    System.out.println("NetworkOwner" + param.getName());
                                    OrigemPlanta planta = param.getValue().equalsIgnoreCase("VIVO1") ? OrigemPlanta.VIVO1 : OrigemPlanta.VIVO2;
                                    getC().getRede().setPlanta(planta);
                                }
                                if (param.getName().equalsIgnoreCase("NetworkOwnerId")) {
                                    getC().setInstancia(param.getValue());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void getBanda(InventarioServico i) {
        for (Account account1 : account.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (addres.getExternalId().equalsIgnoreCase(address)) {
                    for (Item item : addres.getItems()) {
                        for (Item item1 : item.getItems()) {
                            if ((item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING"))
                                    && item1.getDesignator().getValue().equalsIgnoreCase(getC().getDesignador())) {
                                for (com.gvt.ws.eai.oss.inventory.api.Param param : item1.getParam()) {
//                            System.out.println(itn.getStatusName() + "->" + itn.getModifiedDate().getValue());
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
                            }
                        }

                    }
                }
            }
        }

    }

    private void getLinha(InventarioServico i) {

        for (Account account1 : account.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (addres.getExternalId().equalsIgnoreCase(address)) {
                    for (Item item : addres.getItems()) {
                        for (Item item1 : item.getItems()) {
//                        if (item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING")) {
                            System.out.println("item1->" + item1.getDesignator().getValue() + "status->" + item1.getStatusName());
                            if (item1.getDesignator().getValue().equalsIgnoreCase(getC().getInstancia())) {
                                for (com.gvt.ws.eai.oss.inventory.api.Param param : item1.getParam()) {
                                    System.out.println("param->" + param.getName() + "_val->" + param.getValue() + "_modDate->" + param.getModifiedDate().getValue().normalize());
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
                            }

//                        }
                        }

                    }
                }
            }
        }

        if (i.getTipoLinha() == null) {
            i.setTipoLinha(TecnologiaLinha.SIP);
        }
    }

    private void getTv(InventarioServico i) {

        for (Account account1 : account.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (addres.getExternalId().equalsIgnoreCase(address)) {
                    for (Item item : addres.getItems()) {
                        for (Item item1 : item.getItems()) {
//                        System.out.println("paramTV->" + item1.getDesignator().getValue() + "status->" + item1.getStatusName());
                            if (item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING")) {

                                for (com.gvt.ws.eai.oss.inventory.api.Param param : item1.getParam()) {
//                                System.out.println("paramTV->" + param.getName());
                                    if (param.getName().equalsIgnoreCase("TecnologiaTV")) {
                                        if (getC().getDesignadorTv() == null) {
                                            try {
                                                EfikaCustomer cust = TratativasGetDesignadores.tratativaInventoryResponse(account, getC());
                                                getC().setDesignadorTv(cust.getDesignadorTv());
                                            } catch (Exception ex) {
                                            }
                                        }
                                        if (item1.getDesignator().getValue().equalsIgnoreCase(getC().getDesignadorTv())) {

                                            if (param.getValue() != null) {
                                                System.out.println("paramTV->" + param.getValue());
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
                                }

                            }
                        }

                    }
                }
            }
        }

    }

}
