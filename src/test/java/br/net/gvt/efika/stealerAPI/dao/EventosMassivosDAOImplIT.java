/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.EventoMassivo;
import java.util.List;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOldImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOld;
import br.net.gvt.efika.util.json.JacksonMapper;

/**
 *
 * @author G0041775
 */
public class EventosMassivosDAOImplIT {

    public EventosMassivosDAOImplIT() {
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
     * Test of consultar method, of class EventosMassivosDAOImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String param1 = "1110226652";
        EfikaCustomerServiceOld instance0 = new EfikaCustomerServiceOldImpl();
        EfikaCustomer cust = instance0.consultar(param1);
        EventosMassivosDAOImpl instance = new EventosMassivosDAOImpl();
        List<EventoMassivo> result = instance.consultar(cust);
        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

}
