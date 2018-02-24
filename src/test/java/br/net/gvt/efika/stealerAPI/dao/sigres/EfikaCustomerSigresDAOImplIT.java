/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerSigresDAOImplIT {

    private EfikaCustomerSigresDAOImpl instance = new EfikaCustomerSigresDAOImpl();

    public EfikaCustomerSigresDAOImplIT() {
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
     * Test of consultar method, of class EfikaCustomerSigresDAOImpl.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("110001111270900");
            EfikaCustomer result = instance.consultar(cust);
            assertTrue(!result.getRede().getIpDslam().isEmpty());
            assertTrue(result.getRede().getBhs() != null);
            assertTrue(result.getRede().getCvlan() != null);
            System.out.println(new JacksonMapper(InventarioRede.class).serialize(result.getRede()));

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of consultarInventarioRede method, of class
     * EfikaCustomerSigresDAOImpl.
     */
    @Test
    public void testConsultarInventarioRede() throws Exception {
        try {
            System.out.println("consultarInventarioRede");
            String instancia = "110001111270900";
            InventarioRede result = instance.consultarInventarioRede(instancia);
            assertTrue(result != null);
            System.out.println(new JacksonMapper(InventarioRede.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConsultarTeste2() throws Exception {
        try {
            System.out.println("consultar");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("110007700117607");
            EfikaCustomer result = instance.consultar(cust);
            assertTrue(result != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConsultarTerminalFibra() throws Exception {
        try {
            System.out.println("testConsultarTerminalFibra");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("110007700117607");
            EfikaCustomer result = instance.consultar(cust);
            assertTrue(result != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConsultarTerminalMetalico() throws Exception {
        try {
            System.out.println("testConsultarTerminalMetalico");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("1120414633");
            EfikaCustomer result = instance.consultar(cust);
            assertTrue(result != null);
            System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
