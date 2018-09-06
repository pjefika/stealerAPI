/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.InventarioLinha;
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
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String instancia = "4133335556";
        InventarioLinhaDAOPnAdminImpl instance = new InventarioLinhaDAOPnAdminImpl();
        InventarioLinha result = instance.consultar(instancia);
        System.out.println(new JacksonMapper(InventarioLinha.class).serialize(result));
        assertTrue(result != null);

    }

}
