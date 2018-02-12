/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.util.util.json.JacksonMapper;
import java.util.Calendar;
import java.util.List;
import model.entity.ChamadaBilling;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.StringToCalendar;

/**
 *
 * @author G0042204
 */
public class ChamadaBillingDAOImplIT {

    public ChamadaBillingDAOImplIT() {
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
     * Test of listarPorDataInicio method, of class ChamadaBillingDAOImpl.
     */
    @Test
    public void testListarPorDataInicio() throws Exception {
        try {
            System.out.println("listarPorDataInicio");
            String instancia = "4130886762";
            Calendar data = StringToCalendar.parse("02/11/2017");
            ChamadaBillingDAOImpl instance = new ChamadaBillingDAOImpl();
            List<ChamadaBilling> result = instance.listarPorDataInicio(instancia, data);
            System.out.println("Result:"  + new JacksonMapper(List.class).serialize(result));
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
