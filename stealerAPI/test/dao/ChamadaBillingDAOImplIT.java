/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Calendar;
import java.util.List;
import model.entity.ChamadaBilling;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
            String instancia = "4125253047";
            Calendar data = Calendar.getInstance();
            ChamadaBillingDAOImpl instance = new ChamadaBillingDAOImpl();
            List<ChamadaBilling> result = instance.listarPorDataInicio(instancia, data);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
