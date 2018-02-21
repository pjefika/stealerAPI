/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemInventarioServico;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class SophiaServiceInventoryServiceImplIT {

    public SophiaServiceInventoryServiceImplIT() {
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
     * Test of consultar method, of class SophiaServiceInventoryServiceImpl.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            String instancia = "4130886762";
            SophiaServiceInventoryServiceImpl instance = new SophiaServiceInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            assertTrue("Inventário é Sophia", result.getServicos().getOrigem() == OrigemInventarioServico.SOPHIA);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
