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

/**
 *
 * @author G0042204
 */
public class AssertOrdemReparo implements EfikaAssertable {

    private final WorkOrder order;

    public AssertOrdemReparo(WorkOrder order) {
        this.order = order;
    }

    @Override
    public CustomerAssert claim() {
        try {
            return new CustomerAssert(AssertsEnum.IS_REPARO, order.getWorkOrderComprisedOf()[0].getWorkOrderItemInvolvesWorkSpec().getSpecificationAcronym().toUpperCase().contains("TT"));
        } catch (Exception e) {
            return new CustomerAssert(AssertsEnum.IS_REPARO, Boolean.FALSE);

        }

    }
}
