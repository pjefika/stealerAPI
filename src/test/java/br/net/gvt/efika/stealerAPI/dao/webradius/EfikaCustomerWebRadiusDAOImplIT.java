/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.webradius;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerWebRadiusDAOImplIT {

    public EfikaCustomerWebRadiusDAOImplIT() {
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
     * Test of consultar method, of class EfikaCustomerWebRadiusDAOImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            EfikaCustomer cust = new EfikaCustomer();
            InventarioRede rede = new InventarioRede();
            rede.setNrc("3632158241");
            cust.setRede(rede);
            EfikaCustomerWebRadiusDAOImpl instance = new EfikaCustomerWebRadiusDAOImpl();
            EfikaCustomer result = instance.consultar(cust);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
