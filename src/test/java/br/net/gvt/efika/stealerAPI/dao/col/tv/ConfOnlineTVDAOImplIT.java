/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.col.tv;

import br.net.gvt.efika.stealer.model.entity.DecoderTV;
import br.net.gvt.efika.util.json.JacksonMapper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class ConfOnlineTVDAOImplIT {

    public ConfOnlineTVDAOImplIT() {
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
    ConfOnlineTVDAOImpl instance = new ConfOnlineTVDAOImpl();

    /**
     * Test of getStb method, of class ConfOnlineTVDAOImpl.
     */
    @Test
    public void testGetStb() throws Exception {
        System.out.println("getStb");
        List<DecoderTV> result = instance.getStb("TV-CTA-813PE2SDIU-050");
        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

    /**
     * Test of getStbDiagnostics method, of class ConfOnlineTVDAOImpl.
     */
    @Test
    public void testGetStbDiagnostics() throws Exception {
        System.out.println("getStbDiagnostics");
        String designator = "";
        ConfOnlineTVDAOImpl instance = new ConfOnlineTVDAOImpl();
        List<DecoderTV> expResult = null;
//        List<DecoderTV> result = instance.getStbDiagnostics(designator);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
