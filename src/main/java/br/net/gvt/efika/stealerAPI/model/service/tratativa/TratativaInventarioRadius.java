/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.model.domain.InventarioRadiusAdapter;

/**
 *
 * @author G0042204
 */
public class TratativaInventarioRadius extends TratativaEfikaCustomer {

    private final GetInfoOut info;

    public TratativaInventarioRadius(GetInfoOut info, EfikaCustomer c) {
        super(c);
        this.info = info;
    }

    @Override
    public void tratar() {
        getC().setRadius(InventarioRadiusAdapter.adapter(info));
    }

}
