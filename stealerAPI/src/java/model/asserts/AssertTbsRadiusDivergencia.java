/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts;

import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.asserts.EfikaAssertable;
import br.net.gvt.efika.customer.CustomerAssert;
import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;
import model.asserts.facade.AssertAbstract;

/**
 *
 * @author G00422046
 */
public class AssertTbsRadiusDivergencia extends AssertAbstract implements EfikaAssertable {

    private final OSSTurbonetInconsistenciaTBSRadiusOut oss;

    public AssertTbsRadiusDivergencia(OSSTurbonetInconsistenciaTBSRadiusOut oss) {
        super(AssertsEnum.DIVERGENCIA_TBS_RADIUS);
        this.oss = oss;
    }

    @Override
    public CustomerAssert claim() {

        try {
            if (oss.getEhInconsistente()) {
                return new CustomerAssert(as, Boolean.TRUE);
            } else {
                return new CustomerAssert(as, Boolean.FALSE);
            }
        } catch (NullPointerException e) {
            return new CustomerAssert(as, Boolean.FALSE);
        }
    }
}
