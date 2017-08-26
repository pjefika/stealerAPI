/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
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
public class EfikaCustomerInterfaceIT {

    public EfikaCustomerInterfaceIT() {
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
     * Test of consultarCliente method, of class EfikaCustomerInterface.
     */
    @Test
    public void testConsultarCliente() throws Exception {
        try {
            System.out.println("consultarCliente");
            String param1 = "4130222839";
            ConsultaEfikaCustomer instance = FactoryDAO.createClienteDAO();
            EfikaCustomer result = instance.consultar(param1);
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
