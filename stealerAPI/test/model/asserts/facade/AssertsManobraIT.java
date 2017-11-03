/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import br.net.gvt.efika.customer.CustomerAssert;
import java.util.List;
import model.asserts.Assertter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.service.EfikaCustomerService;
import model.service.EfikaCustomerServiceImpl;

/**
 *
 * @author G0042204
 */
public class AssertsManobraIT {

    EfikaCustomerService serv = new EfikaCustomerServiceImpl();

    public AssertsManobraIT() {
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
     * Test of afirmar method, of class AssertsManobra.
     */
    @Test
    public void testAfirmar() throws Exception {
        try {
            System.out.println("afirmar");
            Assertter instance = new AssertsManobra(serv.consultar("4130886762"), "8-2Q6NY8OG");
            List<CustomerAssert> cs = instance.assertThese();
            cs.forEach((t) -> {
                System.out.println("Assert: " + t.getAsserts().name() + " | R: " + t.getValue());
            });

            assertTrue(!cs.isEmpty());
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
    }

}
