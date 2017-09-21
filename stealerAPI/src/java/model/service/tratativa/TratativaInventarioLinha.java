/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.tratativa;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioLinha;
import br.net.gvt.efika.customer.InventarioServico;
import com.gvt.ws.eai.oss.inventory.api.Account;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.Item;

/**
 *
 * @author G0042204
 */
public class TratativaInventarioLinha extends TratativaEfikaCustomer {

    private final InventarioLinha inv;

    public TratativaInventarioLinha(InventarioLinha inv, EfikaCustomer c) {
        super(c);
        this.inv = inv;
    }

    @Override
    public void tratar() throws Exception {
        getC().setLinha(inv);
    }

}
