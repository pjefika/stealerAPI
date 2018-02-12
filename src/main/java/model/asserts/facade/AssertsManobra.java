/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.exception.OrdemInvalidaException;
import model.asserts.AssertAutenticacaoAposOrdem;
import model.asserts.AssertChamadaBilling;
import model.asserts.AssertOrdemReparo;

/**
 *
 * @author G0042204
 */
public class AssertsManobra extends AbstractAssertFacade {

    private final EfikaCustomer cust;

    private GetInfoOut info;

    private final String workOrderId;

    private WorkOrder wo;

    public AssertsManobra(EfikaCustomer cust, String workOrderId) {
        this.cust = cust;
        this.workOrderId = workOrderId;
    }

    @Override
    public void afirmar() throws Exception {

        if (workOrderId == null) {
            throw new OrdemInvalidaException();
        }
        try {
            wo = getWork().getWorkOrder(workOrderId);
        } catch (Exception e) {
            throw new OrdemInvalidaException();
        }
        info = getOss().getInfo(cust.getDesignador());
        adicionarAssert(new AssertOrdemReparo(wo).claim());
        adicionarAssert(new AssertAutenticacaoAposOrdem(getOss().isClienteAutenticado(info), wo).claim());
//        adicionarAssert(new AssertChamadaBilling(wo, cust.getInstancia()).claim());
    }

}