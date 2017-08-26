/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.ws.eai.oss.inventory.api.Designator;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import dao.exception.ClienteSemBandaException;
import dao.exception.InstanciaInvalidaException;

/**
 *
 * @author G0042204
 */
public class TratativaAssociatedDesignators extends TratativaEfikaCustomer {

    private final InventoryDesignatorsResponse r;

    public TratativaAssociatedDesignators(InventoryDesignatorsResponse r, EfikaCustomer c) {
        super(c);
        this.r = r;
    }

    @Override
    public void tratar() throws Exception {

        if (r.getDesignator().isEmpty()) {
            throw new InstanciaInvalidaException();
        }

        new TratativaAssociatedDesignators(r, getC()).getC();

        for (Designator designator : r.getDesignator()) {

            // Designador de Acesso
            if (designator.getDesignatorType().getValue().equals(1)) {
                getC().setDesignadorAcesso(designator.getValue());
            }

            // Instancia
            if (designator.getDesignatorType().getValue().equals(2)) {
                if (getC().getInstancia() == null) {
                    getC().setInstancia(designator.getValue());
                }

            }

            // Designador de Banda
            if (designator.getDesignatorType().getValue().equals(3)) {
                getC().setDesignador(designator.getValue());
            }
        }

        if (getC().getDesignador().equalsIgnoreCase(getC().getInstancia())) {
            throw new ClienteSemBandaException();
        }
    }

}
