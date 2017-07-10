/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;

/**
 *
 * @author G0042204
 */
public interface WorkOrderDAOInterface {

    public WorkOrder getWorkOrder(String workOrderId);

    public GetWorkDetailsOut getWorkDetails(String workOrderId);

}
