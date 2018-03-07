/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoRede;
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
public class LegadoServiceInventoryServiceImplIT {

    public LegadoServiceInventoryServiceImplIT() {
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
     * Test of consultar method, of class LegadoServiceInventoryServiceImpl.
     */
    @Test
    public void testConsultarIdFibra() {
        try {
            System.out.println("consultar - ID FIBRA");
            String instancia = "110002011309703";
            LegadoServiceInventoryServiceImpl instance = new LegadoServiceInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
            assertTrue("Inventário Rede - BHS", result.getRede().getBhs() != null);
            assertTrue("Inventário Rede - Origem", result.getRede().getPlanta() == OrigemPlanta.VIVO1);
            assertTrue("Inventário Rede - Tipo", result.getRede().getTipo() == TipoRede.GPON);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConsultarTerminal() {
        try {
            System.out.println("consultar - TERMINAL");
            String instancia = "1120414633";
            LegadoServiceInventoryServiceImpl instance = new LegadoServiceInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
            assertTrue("Inventário Rede - Origem", result.getRede().getPlanta() == OrigemPlanta.VIVO1);
            assertTrue("Inventário Rede - Tipo", result.getRede().getTipo() == TipoRede.METALICA);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void testConsultarIdfibra() {
        try {
            System.out.println("consultar - ID FIBRA: 116617519269601");
            String instancia = "116617519269601";
            LegadoServiceInventoryServiceImpl instance = new LegadoServiceInventoryServiceImpl();
            EfikaCustomer result = instance.consultar(instancia);
            System.out.println(new JacksonMapper<>(EfikaCustomer.class).serialize(result));
            assertTrue("Inventário Rede - Origem", result.getRede().getPlanta() == OrigemPlanta.VIVO1);
            assertTrue("Inventário Rede - Tipo", result.getRede().getTipo() == TipoRede.GPON);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

}
