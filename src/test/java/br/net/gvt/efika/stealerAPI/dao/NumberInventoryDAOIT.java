/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.stealerAPI.dao.NumberInventoryDAO;
import br.com.gvt.www.eai.NumberInventoryServicesWS.GetNumberByFilterOut;
import br.com.gvt.www.eai.NumberInventoryServicesWS.GetSwitchInfoByFilterOut;
import br.net.gvt.efika.util.util.json.JacksonMapper;
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
public class NumberInventoryDAOIT {
    
    public NumberInventoryDAOIT() {
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
     * Test of getSwitchInfoByNumber method, of class NumberInventoryDAO.
     */
    @Test
    public void testGetSwitchInfoByNumber() throws Exception {
       System.out.println("getSwitchInfoByNumber");
        String instancia = "4160435534";
        NumberInventoryDAO instance = new NumberInventoryDAO();
        String expResult = "TDM";
        GetNumberByFilterOut result = instance.getSwitchInfoByNumber(instancia);
        System.out.println(result.getSwitchName());
        System.out.println(result.getSwitchType());
        assertEquals(expResult, result.getSwitchType());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getSwitchInfo method, of class NumberInventoryDAO.
     */
    @Test
    public void testGetSwitchInfo() throws Exception {
        System.out.println("getSwitchInfo");
        String central = "PRCTA_LPS01";
        NumberInventoryDAO instance = new NumberInventoryDAO();
        GetSwitchInfoByFilterOut expResult = null;
        GetSwitchInfoByFilterOut result = instance.getSwitchInfo(central);
        System.out.println(new JacksonMapper(GetSwitchInfoByFilterOut.class).serialize(result));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
