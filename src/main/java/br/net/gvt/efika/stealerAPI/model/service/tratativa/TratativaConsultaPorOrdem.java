/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.tratativa;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.model.service.FactoryService;

/**
 *
 * @author G0042204
 */
public class TratativaConsultaPorOrdem extends TratativaEfikaCustomer {

    private final String order;

    public TratativaConsultaPorOrdem(String order, EfikaCustomer c) {
        super(c);
        this.order = order;
    }

    @Override
    public void tratar() throws Exception {
        WorkOrder wo = FactoryDAO.createWorkOrderDAO().getWorkOrder(order);
        for (int i = 0; i < wo.getWorkOrderComprisedOf(0).getInvolvesProduct().length; i++) {
            if (wo.getWorkOrderComprisedOf(0).getInvolvesProduct()[i].getProductSpecification().getName().equalsIgnoreCase("Linha Telefônica")) {
                EfikaCustomer e = FactoryService.create().consultar(wo.getWorkOrderComprisedOf(0).getInvolvesProduct()[i].getServiceId());
                setC(e);
                return;
            }
        }

    }

}
