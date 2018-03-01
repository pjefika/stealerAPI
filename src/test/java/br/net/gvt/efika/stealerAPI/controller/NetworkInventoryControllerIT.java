/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.util.json.JacksonMapper;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class NetworkInventoryControllerIT {

    public NetworkInventoryControllerIT() {
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
     * Test of getCliente method, of class NetworkInventoryController.
     */
    @Test
    public void testGetCliente() {
        try {
            System.out.println("getCliente");
            CustomerRequest body = new CustomerRequest();
            EfikaCustomer cust = new EfikaCustomer();
            cust.setDesignador("CTA-81MMWYSLO-013");
            cust.setDesignadorAcesso("CTA-17074589-069");
            InventarioRede rede = new InventarioRede();
            rede.setPlanta(OrigemPlanta.VIVO2);
            cust.setRede(rede);
            body.setCust(cust);
            NetworkInventoryController instance = new NetworkInventoryController();
            Response result = instance.getCliente(body);
            System.out.println(new JacksonMapper(Response.class).serialize(result));
            assertTrue(result.getStatus() == 200);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    /**
     * Test of getClienteTBS method, of class NetworkInventoryController.
     */
    @Test
    public void testGetClienteTBS() {
        System.out.println("getClienteTBS");
        CustomerRequest body = null;
        NetworkInventoryController instance = new NetworkInventoryController();
        Response expResult = null;
        Response result = instance.getClienteTBS(body);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClienteSigres method, of class NetworkInventoryController.
     */
    @Test
    public void testGetClienteSigres() {
        System.out.println("getClienteSigres");
        CustomerRequest body = null;
        NetworkInventoryController instance = new NetworkInventoryController();
        Response expResult = null;
        Response result = instance.getClienteSigres(body);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
