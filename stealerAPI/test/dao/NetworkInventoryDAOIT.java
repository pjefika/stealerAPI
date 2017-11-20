/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioRede;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

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
            InventarioRede result = instance.consultar(instancia);
            System.out.println(GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
