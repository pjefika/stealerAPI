/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class WorkOrderDAOInterfaceIT {

    public WorkOrderDAOInterfaceIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWorkOrder method, of class WorkOrderDAOInterface.
     */
    @Test
    public void testGetWorkOrder() {

        try {
            System.out.println("getWorkOrder");
            String workOrderId = "8-2Q6NY8OG";
            WorkOrderDAOInterface instance = new WorkOrderDAO();
            WorkOrder result = instance.getWorkOrder(workOrderId);
            System.out.println("");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetWorkDetails() {

        try {
            System.out.println("getWorkDetails");
            String workOrderId = "43079135";
            WorkOrderDAOInterface instance = new WorkOrderDAO();
            GetWorkDetailsOut result = instance.getWorkDetails(workOrderId);
            System.out.println("");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

}
