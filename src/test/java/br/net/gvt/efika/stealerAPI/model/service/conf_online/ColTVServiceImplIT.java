/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.conf_online;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOldImpl;
import br.net.gvt.efika.util.json.JacksonMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class ColTVServiceImplIT {

    public ColTVServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            ec = new EfikaCustomerServiceOldImpl().consultar("5131103912");
        } catch (Exception ex) {
            Logger.getLogger(ColTVServiceImplIT.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    ColTVServiceImpl instance = new ColTVServiceImpl();
    static EfikaCustomer ec;

    /**
     * Test of listStbs method, of class ColTVServiceImpl.
     */
    @Test
    public void testListStbs() throws Exception {
        System.out.println("listStbs");
        List<DecoderTV> result = instance.listStbs(ec);
        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

    /**
     * Test of diagnosticoHpna method, of class ColTVServiceImpl.
     */
    @Test
    public void testDiagnosticoHpna() throws Exception {
        System.out.println("diagnosticoHpna");
//        List<DecoderTV> result = instance.diagnosticoHpna(ec);
//        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

}
