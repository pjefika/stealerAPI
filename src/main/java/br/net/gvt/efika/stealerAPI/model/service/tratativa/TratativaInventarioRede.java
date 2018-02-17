/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.model.domain.InventarioRedeAdapter;

/**
 *
 * @author G0042204
 */
public class TratativaInventarioRede extends TratativaEfikaCustomer {

    private final GetInfoOut info;

    public TratativaInventarioRede(GetInfoOut info, EfikaCustomer c) {
        super(c);
        this.info = info;
    }

    @Override
    public void tratar() {
        getC().setRede(InventarioRedeAdapter.adapter(info));
    }

}
