/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts;

import bean.ossturbonet.oss.gvt.com.InfoRadius;
import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.asserts.EfikaAssertable;
import br.net.gvt.efika.customer.CustomerAssert;
import br.net.gvt.efika.customer.InventarioRede;

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

        try {
            if (rede != null) {
                return new CustomerAssert(as, Boolean.TRUE);
            } else {
                return new CustomerAssert(as, Boolean.FALSE);
            }
        } catch (NullPointerException e) {
            return new CustomerAssert(as, Boolean.FALSE);
        }
    }
}
