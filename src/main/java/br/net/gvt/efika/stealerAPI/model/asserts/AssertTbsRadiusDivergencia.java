/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;

/**
 *
 * @author G00422046
 */
public class AssertTbsRadiusDivergencia extends AssertAbstract {

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
