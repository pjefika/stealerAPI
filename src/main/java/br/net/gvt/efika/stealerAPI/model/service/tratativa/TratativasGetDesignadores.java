/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.exception.ImpossivelIdentificarDesignadoresException;
import com.gvt.www.ws.eai.oss.inventory.api.Account;
import com.gvt.www.ws.eai.oss.inventory.api.Address;
import com.gvt.www.ws.eai.oss.inventory.api.Designator;
import com.gvt.www.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.www.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.www.ws.eai.oss.inventory.api.Item;

/**
 *
 * @author G0041775
 */
public class TratativasGetDesignadores {

    public TratativasGetDesignadores() {
    }

    public static EfikaCustomer tratativaDesignatorResponse(InventoryDesignatorsResponse desigResp, EfikaCustomer cust) {
        EfikaCustomer customer = cust;
        for (Designator designator : desigResp.getDesignator()) {
            System.out.println("type->" + designator.getDesignatorType() + "_val->" + designator.getValue());

            // Designador de Acesso
            if ((designator.getDesignatorType().equals(1) && designator.getValue().contains("-069"))
                    && (designator.getStatusName().equalsIgnoreCase("ACTIVE")
                    || designator.getStatusName().equalsIgnoreCase("PENDING"))) {
                customer.setDesignadorAcesso(designator.getValue());
            }

            // Instancia
            if (designator.getDesignatorType().equals(2)
                    && (designator.getStatusName().equalsIgnoreCase("ACTIVE")
                    || designator.getStatusName().equalsIgnoreCase("PENDING"))) {
//                    System.out.println("instancia->"+designator.getValue());
                if (customer.getInstancia() == null) {
                    customer.setInstancia(designator.getValue());
                }

            }
            // Designador de TV
            if (designator.getDesignatorType().equals(4)
                    && (designator.getStatusName().equalsIgnoreCase("ACTIVE")
                    || designator.getStatusName().equalsIgnoreCase("PENDING"))) {
                customer.setDesignadorTv(designator.getValue());
            }

            // Designador de Banda
            if (designator.getDesignatorType().equals(3)
                    && (designator.getStatusName().equalsIgnoreCase("ACTIVE")
                    || designator.getStatusName().equalsIgnoreCase("PENDING"))) {
                customer.setDesignador(designator.getValue());
            }

        }
        return customer;
    }

    public static EfikaCustomer tratativaInventoryResponse(InventoryAccountResponse invResp, EfikaCustomer cust) throws Exception {
        EfikaCustomer customer = cust;

        if (invResp.getAccounts().length > 0) {
            if (invResp.getAccounts().length > 1) {
                throw new ImpossivelIdentificarDesignadoresException();
            }
        }
        /**
         * Find the right address first
         */
        String address = null;
        for (Account account1 : invResp.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (!addres.getExternalId().contains("OLD")) {
                    for (Item item : addres.getItems()) {
                        if (item.getStatusName().equalsIgnoreCase("ACTIVE") || item.getStatusName().equalsIgnoreCase("PENDING")) {
                            if (customer.getDesignadorAcesso() != null && customer.getDesignadorAcesso().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            } else if (customer.getDesignador() != null && customer.getDesignador().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            } else if (customer.getInstancia() != null && customer.getInstancia().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            } else if (item.getItems() != null) {
                                for (Item item1 : item.getItems()) {
                                    if (customer.getDesignadorAcesso() != null && customer.getDesignadorAcesso().equalsIgnoreCase(item1.getDesignator().getValue())) {
                                        address = addres.getExternalId();
                                    } else if (customer.getDesignador() != null && customer.getDesignador().equalsIgnoreCase(item1.getDesignator().getValue())) {
                                        address = addres.getExternalId();
                                    } else if (customer.getInstancia() != null && customer.getInstancia().equalsIgnoreCase(item1.getDesignator().getValue())) {
                                        address = addres.getExternalId();
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (address == null) {
                for (Address addres : account1.getAddress()) {
                    for (Item item : addres.getItems()) {
                        if (item.getStatusName().equalsIgnoreCase("INACTIVATING")) {
                            if (customer.getDesignadorAcesso() != null && customer.getDesignadorAcesso().equalsIgnoreCase(item.getDesignator().getValue())
                                    || customer.getInstancia().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            } else if (customer.getDesignador() != null && customer.getDesignador().equalsIgnoreCase(item.getDesignator().getValue())
                                    || customer.getInstancia().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            } else if (customer.getInstancia() != null && customer.getInstancia().equalsIgnoreCase(item.getDesignator().getValue())) {
                                address = addres.getExternalId();
                            }
                        }
                    }
                }

            }

        }

        for (Account account1 : invResp.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                if (addres.getExternalId().equalsIgnoreCase(address)) {
                    for (Item item : addres.getItems()) {
                        if ((item.getStatusName().equalsIgnoreCase("ACTIVE") || item.getStatusName().equalsIgnoreCase("PENDING"))
                                && item.getSpecId() == 6 && customer.getDesignadorAcesso() == null) {
                            customer.setDesignadorAcesso(item.getDesignator().getValue());
                        }
                        for (Item item1 : item.getItems()) {
                            if (item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING")) {
//                                System.out.println("letype->" + item1.getDesignator().getDesignatorType().getValue() + "_des->" + item1.getDesignator().getValue());
                                if (null != item1.getDesignator().getDesignatorType()) {
                                    switch (item1.getDesignator().getDesignatorType()) {
                                        case 2:
                                            if (customer.getInstancia() == null) {
                                                customer.setInstancia(item1.getDesignator().getValue());
                                            } else if (customer.getInstancia().equalsIgnoreCase(item1.getDesignator().getValue())
                                                    && customer.getDesignadorAcesso() == null) {
                                                customer.setDesignadorAcesso(item.getDesignator().getValue());
                                            }
                                            break;
                                        case 3:
                                            if (customer.getDesignador() == null) {
                                                customer.setDesignador(item1.getDesignator().getValue());
                                            }
                                            break;
                                        case 4:
                                            if (customer.getDesignadorTv() == null) {
                                                customer.setDesignadorTv(item1.getDesignator().getValue());
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return customer;
    }
}
