/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.stealerAPI.dao.LinhaClienteITDAO;
import br.net.gvt.efika.customer.InventarioLinha;
import br.net.gvt.efika.customer.TipoCentral;
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
public class LinhaClienteITDAOIT {
    
    public LinhaClienteITDAOIT() {
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
     * Test of consultarCliente method, of class LinhaClienteITDAO.
     */
    @Test
    public void testConsultarCliente() throws Exception {
        System.out.println("consultarCliente");
        String param1 = "4133335556";
        LinhaClienteITDAO instance = new LinhaClienteITDAO();
        InventarioLinha result = instance.consultar(param1);
        System.out.println(result.getCentral());
        System.out.println(result.getDn());
        System.out.println(result.getTipo());
        assertTrue(result != null);
        
    }

    /**
     * Test of getDn method, of class LinhaClienteITDAO.
     */
    @Test
    public void testGetDn() {
        System.out.println("getDn");
        String instancia = "";
        LinhaClienteITDAO instance = new LinhaClienteITDAO();
        String expResult = "";
        String result = instance.getDn(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwitch method, of class LinhaClienteITDAO.
     */
    @Test
    public void testGetSwitch() {
        System.out.println("getSwitch");
        String instancia = "";
        LinhaClienteITDAO instance = new LinhaClienteITDAO();
        String expResult = "";
        String result = instance.getSwitch(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoCentral method, of class LinhaClienteITDAO.
     */
    @Test
    public void testGetTipoCentral() {
        System.out.println("getTipoCentral");
        String instancia = "";
        LinhaClienteITDAO instance = new LinhaClienteITDAO();
        TipoCentral expResult = null;
        TipoCentral result = instance.getTipoCentral(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
