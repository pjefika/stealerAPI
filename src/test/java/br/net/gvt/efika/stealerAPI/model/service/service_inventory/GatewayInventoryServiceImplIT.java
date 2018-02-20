/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customer.model.customer.enums.OrigemInventarioServico;
import br.net.gvt.efika.customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.util.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class GatewayInventoryServiceImplIT {

    public GatewayInventoryServiceImplIT() {
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
     * Test of consultar method, of class GatewayInventoryServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar - cliente SOPHIA");
        String instancia = "4130886762";
        GatewayInventoryServiceImpl instance = new GatewayInventoryServiceImpl();
        EfikaCustomer result = instance.consultar(instancia);
        System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
        assertTrue("Inventário Serviços - SOPHIA", result.getServicos().getOrigem() == OrigemInventarioServico.SOPHIA);

    }

}
