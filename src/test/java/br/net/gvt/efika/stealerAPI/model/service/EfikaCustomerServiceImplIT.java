/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import br.net.gvt.efika.util.json.JacksonMapper;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceImplIT {

    private final String param = "4130886762";

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
            EfikaCustomerServiceOld instance = new EfikaCustomerServiceOldImpl();
            EfikaCustomer result = instance.consultar("1110048523");
//            assertTrue("nulo", result != null);
//            assertTrue("rede externa", result.getRedeExterna() != null);
//            assertTrue("rede", result.getRede() != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
//
}
