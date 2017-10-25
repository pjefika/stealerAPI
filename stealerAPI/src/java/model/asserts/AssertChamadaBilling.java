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
import model.service.ChamadaBillingService;
import model.service.FactoryService;

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
