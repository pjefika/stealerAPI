/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.asserts.EfikaAssertable;
import br.net.gvt.efika.customer.CustomerAssert;
import com.gvt.www.ws.eai.oss.OSSTurbonetClienteAutenticado.OSSTurbonetClienteAutenticadoOut;

/**
 *
 * @author G0042204
 */
public class AssertAutenticacaoAposOrdem implements EfikaAssertable {

    private final OSSTurbonetClienteAutenticadoOut auth;

    private final WorkOrder order;

    public AssertAutenticacaoAposOrdem(OSSTurbonetClienteAutenticadoOut auth, WorkOrder order) {
        this.auth = auth;
        this.order = order;
    }

    @Override
    public CustomerAssert claim() {
        if (auth.getDataHoraAutenticacao().after(order.getDateOfSale())) {
            return new CustomerAssert(AssertsEnum.AUTH_ABERTURA_ORDEM, Boolean.TRUE);
        } else {
            return new CustomerAssert(AssertsEnum.AUTH_ABERTURA_ORDEM, Boolean.FALSE);

        }
    }

}
