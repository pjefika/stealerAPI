/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceImplIT {

    public EfikaCustomerServiceImplIT() {
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
     * Test of consultar method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            String param1 = "4130886762";
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();
            EfikaCustomer result = instance.consultar(param1);
            System.out.println(GsonUtil.serialize(result));
            System.out.println("");
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
