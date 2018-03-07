/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
import br.net.gvt.efika.efika_customer.model.customer.asserts.EfikaAssertable;
import br.net.gvt.efika.stealerAPI.model.service.ChamadaBillingService;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;

/**
 *
 * @author G0042204
 */
public class AssertChamadaBilling implements EfikaAssertable {

    private final WorkOrder order;

    private final String instancia;

    private ChamadaBillingService serv;

    public AssertChamadaBilling(WorkOrder order, String instancia) {
        this.order = order;
        this.instancia = instancia;
    }

    @Override
    public CustomerAssert claim() {
        try {
            serv = FactoryService.createChamadaBillingService();
            return new CustomerAssert(AssertsEnum.ORIGINOU_CHAMADA_POS_ABERTURA_ORDEM, serv.possuiChamada(instancia, order.getDateOfSale()));
        } catch (Exception e) {
            return new CustomerAssert(AssertsEnum.ORIGINOU_CHAMADA_POS_ABERTURA_ORDEM, Boolean.FALSE);
        }

    }
}
