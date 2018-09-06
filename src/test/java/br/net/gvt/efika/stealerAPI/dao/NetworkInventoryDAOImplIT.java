/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
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
public class NetworkInventoryDAOImplIT {
    
    public NetworkInventoryDAOImplIT() {
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
     * Test of consultar method, of class NetworkInventoryDAOImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String instancia = "115027780597904";
        NetworkInventoryDAOImpl instance = new NetworkInventoryDAOImpl();
//        EfikaCustomer expResult = null;
        EfikaCustomer result = instance.consultar(instancia);
        
        System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
