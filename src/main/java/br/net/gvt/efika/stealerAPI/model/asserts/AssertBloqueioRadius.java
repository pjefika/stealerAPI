/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import bean.ossturbonet.oss.gvt.com.InfoRadius;
import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
import br.net.gvt.efika.efika_customer.model.customer.asserts.EfikaAssertable;

/**
 *
 * @author G00422046
 */
public class AssertBloqueioRadius extends AssertAbstract implements EfikaAssertable {

    private final InfoRadius radius;

    public AssertBloqueioRadius(InfoRadius radius) {
        super(AssertsEnum.HAS_BLOQUEIO_RADIUS);
        this.radius = radius;
    }

    @Override
    public CustomerAssert claim() {

        try {
            if (radius.getStatus().equalsIgnoreCase("BLOQUEADO")) {
                return new CustomerAssert(as, Boolean.TRUE);
            } else {
                return new CustomerAssert(as, Boolean.FALSE);
            }
        } catch (NullPointerException e) {
            return new CustomerAssert(as, Boolean.FALSE);
        }
    }
}
