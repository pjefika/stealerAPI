/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.ws.eai.oss.inventory.api.Designator;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import dao.exception.ClienteSemBandaException;
import dao.exception.InstanciaInvalidaException;
import dao.oss.OSSGenericDAO;

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
        if (r.getDesignator().size()>2) {
            for (Designator designator : r.getDesignator()) {

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

                // Designador de Banda
                if (designator.getDesignatorType().getValue().equals(3)) {
                    getC().setDesignador(designator.getValue());
                }
            }
        } else {
            a.getAccounts().forEach((t) -> {
                t.getAddress().forEach((t1) -> {
                    t1.getItems().forEach((t2) -> {
                        if (t2.getStatusName().equalsIgnoreCase("ACTIVE") && t2.getSpecId() == 6) {
                            getC().setDesignadorAcesso(t2.getDesignator().getValue());
                        }
                        t2.getItems().forEach((t3) -> {
//                            if (t3.getStatusName().equalsIgnoreCase("ACTIVE")) {
                                if (t3.getSpecId() == 3) {
                                    if (getC().getInstancia() == null) {
                                        getC().setInstancia(t3.getDesignator().getValue());
                                    }
                                }
                                if (t3.getSpecId() == 4) {
                                    getC().setDesignador(t3.getDesignator().getValue());
                                }
//                            }
                        });
                    });
                });
            });
        }
        
        if (getC().getDesignador().equalsIgnoreCase(getC().getInstancia()) || getC().getDesignador().isEmpty()) {
            throw new ClienteSemBandaException();
        }
    }
    
}
