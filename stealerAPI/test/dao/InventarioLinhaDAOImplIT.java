/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
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
public class InventarioLinhaDAOImplIT {

    public InventarioLinhaDAOImplIT() {
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
     * Test of consultar method, of class InventarioLinhaDAOImpl.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            String instancia = "4133335556";
            InventarioLinhaDAOImpl instance = new InventarioLinhaDAOImpl();
            InventarioLinha result = instance.consultar(instancia);
            System.out.println(GsonUtil.serialize(result));
            assertTrue(true);
            // TODO review the generated test code and remove the default call to fail.  
        } catch (Exception e) {
            fail(e.getMessage());

        }

    }

}
