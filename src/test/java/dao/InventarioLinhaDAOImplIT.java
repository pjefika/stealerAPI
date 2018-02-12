/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
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
            InventarioLinhaDAOPnAdminImpl instance = new InventarioLinhaDAOPnAdminImpl();
            InventarioLinha result = instance.consultar(instancia);
            System.out.println(new JacksonMapper(InventarioLinha.class).serialize(result));
            assertTrue(true);
            // TODO review the generated test code and remove the default call to fail.  
        } catch (Exception e) {
            fail(e.getMessage());

        }

    }

}
