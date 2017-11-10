/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.Address;
import com.gvt.ws.eai.oss.inventory.api.Designator;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;
import dao.exception.ClienteSemBandaException;
import dao.exception.ImpossivelIdentificarDesignadoresException;
import dao.exception.InstanciaInvalidaException;

/**
 *
 * @author G0042204
 */
public class TratativaAssociatedDesignators extends TratativaEfikaCustomer {

    private final InventoryDesignatorsResponse r;

    private final InventoryAccountResponse a;

    public TratativaAssociatedDesignators(InventoryDesignatorsResponse r, EfikaCustomer c, InventoryAccountResponse a) {
        super(c);
        this.r = r;
        this.a = a;
    }

    @Override
    public void tratar() throws Exception {

        if (r.getDesignator().isEmpty() && a.getAccounts().isEmpty()) {
            throw new InstanciaInvalidaException();
        }

        new TratativaAssociatedDesignators(r, getC(), a).getC();
        if (r.getDesignator().size() > 2) {
            for (Designator designator : r.getDesignator()) {
//                System.out.println("type->" + designator.getDesignatorType().getValue() + "_val->" + designator.getValue());

                // Designador de Acesso
                if (designator.getDesignatorType().getValue().equals(1)) {
                    getC().setDesignadorAcesso(designator.getValue());
                }

                // Instancia
                if (designator.getDesignatorType().getValue().equals(2)) {
//                    System.out.println("instancia->"+designator.getValue());
                    if (getC().getInstancia() == null) {
                        getC().setInstancia(designator.getValue());
                    }

                }
                // Designador de TV
                if (designator.getDesignatorType().getValue().equals(4)) {
                    getC().setDesignadorTv(designator.getValue());
                }

                // Designador de Banda
                if (designator.getDesignatorType().getValue().equals(3)) {
                    getC().setDesignador(designator.getValue());
                }

            }
        } else {
            if (a.getAccounts().size() > 0) {
                if (a.getAccounts().get(0).getAddress().size() > 1 || a.getAccounts().size() > 1) {
                    throw new ImpossivelIdentificarDesignadoresException();
                }
            }
            for (Account account1 : a.getAccounts()) {
                for (Address addres : account1.getAddress()) {
                    for (Item item : addres.getItems()) {
                        if ((item.getStatusName().equalsIgnoreCase("ACTIVE") || item.getStatusName().equalsIgnoreCase("PENDING"))
                                && item.getSpecId() == 6) {
                            getC().setDesignadorAcesso(item.getDesignator().getValue());
                        }
                        for (Item item1 : item.getItems()) {
                            if (item1.getStatusName().equalsIgnoreCase("ACTIVE") || item1.getStatusName().equalsIgnoreCase("PENDING")) {
//                                System.out.println("type->" + item1.getDesignator().getDesignatorType().getValue() + "_des->" + item1.getDesignator().getValue());
                                if (null != item1.getDesignator().getDesignatorType().getValue()) {
                                    switch (item1.getDesignator().getDesignatorType().getValue()) {
                                        case 2:
                                            getC().setInstancia(item1.getDesignator().getValue());
                                            break;
                                        case 3:
                                            getC().setDesignador(item1.getDesignator().getValue());
                                            break;
                                        case 4:
                                            getC().setDesignadorTv(item1.getDesignator().getValue());
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

        if (getC()
                .getDesignador().equalsIgnoreCase(getC().getInstancia()) || getC().getDesignador().isEmpty()) {
            throw new ClienteSemBandaException();
        }
    }
}
