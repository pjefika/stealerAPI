/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
import br.net.gvt.efika.efika_customer.model.customer.asserts.EfikaAssertable;

/**
 *
 * @author G00422046
 */
public class AssertInventarioRede extends AssertAbstract implements EfikaAssertable {

    private final InventarioRede rede;

    public AssertInventarioRede(InventarioRede rede) {
        super(AssertsEnum.CIRCUITO_ATIVO);
        this.rede = rede;
    }

    @Override
    public CustomerAssert claim() {
        if (rede == null) {
            return new CustomerAssert(as, Boolean.FALSE);
        } else {
            if (rede.getIpDslam() == null || rede.getModeloDslam() == null) {
                return new CustomerAssert(as, Boolean.FALSE);
            }
            return new CustomerAssert(as, Boolean.TRUE);
        }
    }
}
