/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.exception.ImpossivelIdentificarDesignadoresException;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.Address;
import com.gvt.ws.eai.oss.inventory.api.Designator;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;

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
            System.out.println("type->" + designator.getDesignatorType().getValue() + "_val->" + designator.getValue());

            // Designador de Acesso
            if (designator.getDesignatorType().getValue().equals(1)) {
                customer.setDesignadorAcesso(designator.getValue());
            }

            // Instancia
            if (designator.getDesignatorType().getValue().equals(2)) {
//                    System.out.println("instancia->"+designator.getValue());
                if (customer.getInstancia() == null) {
                    customer.setInstancia(designator.getValue());
                }

            }
            // Designador de TV
            if (designator.getDesignatorType().getValue().equals(4)) {
                customer.setDesignadorTv(designator.getValue());
            }

            // Designador de Banda
            if (designator.getDesignatorType().getValue().equals(3)) {
                customer.setDesignador(designator.getValue());
            }

        }
        return customer;
    }

    public static EfikaCustomer tratativaInventoryResponse(InventoryAccountResponse invResp, EfikaCustomer cust) throws Exception {
        EfikaCustomer customer = cust;
        if (invResp.getAccounts().size() > 0) {
            if (invResp.getAccounts().size() > 1) {
                throw new ImpossivelIdentificarDesignadoresException();
            }
        }
        for (Account account1 : invResp.getAccounts()) {
            for (Address addres : account1.getAddress()) {
                for (Item item : addres.getItems()) {
                    if ((item.getStatusName().equalsIgnoreCase("ACTIVE") || item.getStatusName().equalsIgnoreCase("PENDING"))
                            && item.getSpecId() == 6) {
                        customer.setDesignadorAcesso(item.getDesignator().getValue());
                    }
                    for (Item item1 : item.getItems()) {
                        if (item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING")) {
//                                System.out.println("letype->" + item1.getDesignator().getDesignatorType().getValue() + "_des->" + item1.getDesignator().getValue());
                            if (null != item1.getDesignator().getDesignatorType().getValue()) {
                                switch (item1.getDesignator().getDesignatorType().getValue()) {
                                    case 2:
                                        customer.setInstancia(item1.getDesignator().getValue());
                                        break;
                                    case 3:
                                        customer.setDesignador(item1.getDesignator().getValue());
                                        break;
                                    case 4:
                                        customer.setDesignadorTv(item1.getDesignator().getValue());
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
        return customer;
    }
}
