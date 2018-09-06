/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import java.rmi.RemoteException;

/**
 *
 * @author G0042204
 */
public interface WorkOrderDAOInterface {

    public WorkOrder getWorkOrder(String workOrderId) throws RemoteException;

    public GetWorkDetailsOut getWorkDetails(String workOrderId);

}
