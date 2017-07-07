/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.List;
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
public class ValidadorManobraInterfaceIT {
    
    public ValidadorManobraInterfaceIT() {
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
     * Test of validar method, of class ValidadorManobraInterface.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        ValidadorManobraInterface instance = new ValidadorManobra("AUJ-81GCQQSC5-013", "8-2Q6NY8OG");
        List<ValidacaoDTO> expResult = null;
        List<ValidacaoDTO> result = instance.validar();
        
        System.out.println("end");
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
