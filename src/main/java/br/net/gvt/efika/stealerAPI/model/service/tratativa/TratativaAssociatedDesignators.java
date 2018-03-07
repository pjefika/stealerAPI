/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.exception.ClienteSemBandaException;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;

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

//        new TratativaAssociatedDesignators(r, getC(), a).getC();
        EfikaCustomer cust;
        if (r.getDesignator().size() > 2) {
            cust = TratativasGetDesignadores.tratativaDesignatorResponse(r, getC());
            getC().setDesignador(cust.getDesignador());
            getC().setInstancia(cust.getInstancia());
            getC().setDesignadorAcesso(cust.getDesignadorAcesso());
            getC().setDesignadorTv(cust.getDesignadorTv());
        } else {
            cust = TratativasGetDesignadores.tratativaInventoryResponse(a, getC());
            getC().setDesignador(cust.getDesignador());
            getC().setInstancia(cust.getInstancia());
            getC().setDesignadorAcesso(cust.getDesignadorAcesso());
            getC().setDesignadorTv(cust.getDesignadorTv());
        }

        if (getC().getDesignador() == null || getC().getDesignador().equalsIgnoreCase(getC().getInstancia())
                || getC().getDesignador().isEmpty()) {
            throw new ClienteSemBandaException();
        }
    }

}
