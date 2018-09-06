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
 * @author G0042204
 */
public class NetworkInventoryDAOIT {

    public NetworkInventoryDAOIT() {
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
     * Test of consultar method, of class NetworkInventoryDAO.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            String instancia = "110002021394401";
            NetworkInventoryDAO instance = new NetworkInventoryDAOImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
