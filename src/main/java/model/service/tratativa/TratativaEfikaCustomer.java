/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;

/**
 *
 * @author G0042204
 */
public abstract class TratativaEfikaCustomer implements Tratativa, Runnable {

    private EfikaCustomer c;
    
    protected InventoryAccountResponse account;

    public TratativaEfikaCustomer(EfikaCustomer c) {
        this.c = c;
    }

    public EfikaCustomer getC() {
        return c;
    }

    public void setC(EfikaCustomer c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            this.tratar();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
