/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.customer.model.customer.InventarioRede;
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
public class InventarioRedeOfflineDAOIT {

    public InventarioRedeOfflineDAOIT() {
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
     * Test of consultarInventarioRede method, of class
     * InventarioRedeOfflineDAO.
     */
    @Test
    public void testConsultarInventarioRede() throws Exception {
        System.out.println("consultarInventarioRede");
        try {
            String instancia = "4130886762";
            InventarioRedeOfflineDAO instance = new InventarioRedeOfflineDAO();
            InventarioRede result = instance.consultarInventarioRede(instancia);
            System.out.println(new JacksonMapper(InventarioRede.class).serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }

}
