/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.stealerAPI.dao.ConsultaEquipamentoImpl;
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
public class ConsultaEquipamentoImplIT {

    public ConsultaEquipamentoImplIT() {
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
     * Test of consultar method, of class ConsultaEquipamentoImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            String instancia = "4130886762";
            String expResult = "4130886762";

            ConsultaEquipamentoImpl instance = new ConsultaEquipamentoImpl();
            String result = instance.consultar(instancia);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
