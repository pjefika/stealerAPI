/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
import br.net.gvt.efika.efika_customer.model.customer.asserts.EfikaAssertable;

/**
 *
 * @author G00422046
 */
public class AssertCiruitoAtivo implements EfikaAssertable {

    private final GetInfoOut info;

    public AssertCiruitoAtivo(GetInfoOut info) {
        this.info = info;
    }

    @Override
    public CustomerAssert claim() {
        try {
            if (!info.getInfoTBS().getStatus().equalsIgnoreCase("ATIVO")) {
                return new CustomerAssert(AssertsEnum.CIRCUITO_ATIVO, Boolean.FALSE);
            } else {
                return new CustomerAssert(AssertsEnum.CIRCUITO_ATIVO, Boolean.TRUE);
            }
        } catch (NullPointerException e) {
            return new CustomerAssert(AssertsEnum.CIRCUITO_ATIVO, Boolean.FALSE);
        }
    }
}
