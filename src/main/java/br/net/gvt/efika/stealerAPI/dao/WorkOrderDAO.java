/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.WorkOrderReporting.WorkOrderReportingProxy;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.FindCustomerIn;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.FindCustomerOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.FindWorkOrderIn;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsIn;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import java.rmi.RemoteException;

/**
 *
 * @author G0042204
 */
public class WorkOrderDAO implements WorkOrderDAOInterface {

    private WorkOrderReportingProxy ws;

    @Override
    public WorkOrder getWorkOrder(String workOrderId) throws RemoteException {
        ws = new WorkOrderReportingProxy();
        return ws.findWorkOrder(new FindWorkOrderIn(workOrderId, "", "", ""))[0];
    }

    @Override
    public GetWorkDetailsOut getWorkDetails(String workOrderId) {
        try {
            ws = new WorkOrderReportingProxy();
            return ws.getWorkDetails(new GetWorkDetailsIn(workOrderId));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FindCustomerOut getCustomer(String workOrderId) {
        try {
            ws = new WorkOrderReportingProxy();
            return ws.findCustomer(new FindCustomerIn(workOrderId));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

}
