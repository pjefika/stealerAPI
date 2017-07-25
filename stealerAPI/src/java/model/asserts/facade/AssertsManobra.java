/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import model.asserts.AssertAutenticacaoAposOrdem;
import model.asserts.AssertOrdemReparo;

/**
 *
 * @author G0042204
 */
public class AssertsManobra extends AbstractAssertFacade {

    private final String workOrderId;

    private final GetInfoOut info;

    private WorkOrder wo;

    public AssertsManobra(String workOrderId, GetInfoOut info) {
        this.workOrderId = workOrderId;
        this.info = info;

    }

    @Override
    public void afirmar() {

        try {
            wo = getWork().getWorkOrder(workOrderId);
            adicionarAssert(new AssertOrdemReparo(wo).claim());
            adicionarAssert(new AssertAutenticacaoAposOrdem(getOss().isClienteAutenticado(info), wo).claim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
