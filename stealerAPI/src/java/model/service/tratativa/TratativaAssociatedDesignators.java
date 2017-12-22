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
import com.gvt.ws.eai.oss.inventory.api.InventoryResponse;
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
