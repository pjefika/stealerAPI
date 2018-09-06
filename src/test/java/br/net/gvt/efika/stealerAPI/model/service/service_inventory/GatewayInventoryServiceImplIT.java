/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemInventarioServico;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
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
    public void testConsultar() {
        try {
            System.out.println("consultar - cliente SOPHIA");
            String instancia = "4130886762";
            GatewayInventoryServiceImpl instance = new GatewayInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
            assertTrue("Inventário Serviços - SOPHIA", result.getServicos().getOrigem() == OrigemInventarioServico.SOPHIA);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testConsultarLegado() {
        try {
            System.out.println("consultar Legado");
            String instancia = "1275192696";
            GatewayInventoryServiceImpl instance = new GatewayInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
            assertTrue("Inventário Serviços - Legado", result.getServicos().getOrigem() == OrigemInventarioServico.LEGADO_VIVO1);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
