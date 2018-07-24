/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

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
public class ConsultaUsuarioDAOImplIT {
    
    public ConsultaUsuarioDAOImplIT() {
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
     * Test of getUserArea method, of class ConsultaUsuarioDAOImpl.
     */
    @Test
    public void testGetUserArea() throws Exception {
        System.out.println("getUserArea");
        String usuario = "G0058219";
        ConsultaUsuarioDAOImpl instance = new ConsultaUsuarioDAOImpl();
        
        String result = instance.getUserArea(usuario);
        System.out.println("RESULTADO->"+result);
    }
    
}
