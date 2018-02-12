/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import br.net.gvt.efika.customer.EfikaCustomer;
import java.util.Calendar;
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
public class StringToCalendarIT {

    public StringToCalendarIT() {
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
     * Test of parse method, of class StringToCalendar.
     */
    @Test
    public void testParse() throws Exception {
        System.out.println("parse");

        String diaMes = "02";

        String dia = diaMes + "/11/2017";
        Calendar expResult = null;
        Calendar result = StringToCalendar.parse(dia);
        System.out.println("GsonUtil.serialize(result): " + new br.net.gvt.efika.util.util.json.JacksonMapper(Calendar.class).serialize(result));
        assertEquals(diaMes, result.get(Calendar.DAY_OF_MONTH));
        
        
    }

}
