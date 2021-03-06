/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioLinha;

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
