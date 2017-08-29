/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0041775
 */
public class InventarioLinhaDAOPnAdminImplIT {
    
    public InventarioLinhaDAOPnAdminImplIT() {
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
     * Test of consultar method, of class InventarioLinhaDAOPnAdminImpl.
     */
    @Test
    public void testConsultar() {
        System.out.println("consultar");
        String instancia = "4133335556";
        InventarioLinhaDAOPnAdminImpl instance = new InventarioLinhaDAOPnAdminImpl();
        InventarioLinha expResult = null;
        InventarioLinha result = instance.consultar(instancia);
        System.out.println(GsonUtil.serialize(result));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
