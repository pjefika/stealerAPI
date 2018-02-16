/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.environment;

import br.net.gvt.efika.stealerAPI.model.environment.EfikaEnvironment;
import br.net.gvt.efika.stealerAPI.model.environment.EnvironmentSingleton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EnvironmentSingletonIT {
    
    public EnvironmentSingletonIT() {
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
     * Test of getInstance method, of class EnvironmentSingleton.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        EnvironmentSingleton expResult = null;
        EnvironmentSingleton result = EnvironmentSingleton.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnv method, of class EnvironmentSingleton.
     */
    @Test
    public void testGetEnv() {
        System.out.println("getEnv");
        EfikaEnvironment result = EnvironmentSingleton.getInstance().getEnv();
        assertEquals(EfikaEnvironment.PROD, result);
    }
    
}
