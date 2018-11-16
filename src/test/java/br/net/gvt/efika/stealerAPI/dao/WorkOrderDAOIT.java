/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.FindCustomerOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.GetWorkDetailsOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class WorkOrderDAOIT {
    
    public WorkOrderDAOIT() {
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
     * Test of getWorkOrder method, of class WorkOrderDAO.
     */
    @Test
    public void testGetWorkOrder() throws Exception {
        System.out.println("getWorkOrder");
        String workOrderId = "8-512RQ3DQ";
        WorkOrderDAO instance = new WorkOrderDAO();
        WorkOrder result = instance.getWorkOrder(workOrderId);
        System.out.println(new JacksonMapper(WorkOrder.class).serialize(result));
    }

    /**
     * Test of getWorkDetails method, of class WorkOrderDAO.
     */
    @Test
    public void testGetWorkDetails() {
        System.out.println("getWorkDetails");
        String workOrderId = "";
        WorkOrderDAO instance = new WorkOrderDAO();
        GetWorkDetailsOut expResult = null;
        GetWorkDetailsOut result = instance.getWorkDetails(workOrderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class WorkOrderDAO.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        String workOrderId = "8-2Q6NY8OG";
        WorkOrderDAO instance = new WorkOrderDAO();
        FindCustomerOut result = instance.getCustomer(workOrderId);
        System.out.println(new JacksonMapper(FindCustomerOut.class).serialize(result));
    }
    
}
