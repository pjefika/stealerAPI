/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.util.util.json.JacksonMapper;
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
            String workOrderId = "8-3MA0LO5H";
            WorkOrderDAOInterface instance = new WorkOrderDAO();
            WorkOrder result = instance.getWorkOrder(workOrderId);
            System.out.println(new JacksonMapper(WorkOrder.class).serialize(result));
            assertTrue(!result.getStatus().isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetWorkDetails() {

        try {
            System.out.println("getWorkDetails");
            String workOrderId = "50348353";
            WorkOrderDAOInterface instance = new WorkOrderDAO();
            GetWorkDetailsOut result = instance.getWorkDetails(workOrderId);
            System.out.println(new JacksonMapper(GetWorkDetailsOut.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
        // TODO review the generated test code and remove the default call to fail.
    }

}
