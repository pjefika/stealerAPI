/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.gvt.ws.eai.oss.inventory.api.Designator;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import model.domain.EfikaCustomerDTO;


/**
 *
 * @author G0042204
 */
public class TratativaDesignadores {

    private InventoryDesignatorsResponse r;

    private EfikaCustomerDTO c;

    public TratativaDesignadores(InventoryDesignatorsResponse r, EfikaCustomerDTO c) {
        this.r = r;
        this.c = c;
    }

    public EfikaCustomerDTO getC() {
        this.tratativa();
        return c;
    }

    protected void tratativa() {
        for (Designator designator : r.getDesignator()) {
            
            // Designador de Acesso
            if (designator.getDesignatorType().getValue().equals(1)) {
                c.setDesignadorAcesso(designator.getValue());
            }
            
            // Instancia
            if (designator.getDesignatorType().getValue().equals(2)) {
                c.setInstancia(designator.getValue());
            }

            // Designador de Banda
            if (designator.getDesignatorType().getValue().equals(3)) {
                c.setDesignador(designator.getValue());
            }
        }

    }

}
