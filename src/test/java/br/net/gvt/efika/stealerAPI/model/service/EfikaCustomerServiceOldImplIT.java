/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;
import br.net.gvt.efika.util.json.JacksonMapper;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class EfikaCustomerServiceOldImplIT {

    public EfikaCustomerServiceOldImplIT() {
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
     * Test of consultar method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        String designador = "3125352127";
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
//        EfikaCustomer expResult = null;
        EfikaCustomer result = instance.consultar(designador);
        System.out.println(new JacksonMapper(EfikaCustomer.class).serialize(result));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of linha method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testLinha() {
        System.out.println("linha");
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
        InventarioLinhaDAO expResult = null;
        InventarioLinhaDAO result = instance.linha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
        GetInfoOut expResult = null;
        GetInfoOut result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutenticacaoByMacOrIp method, of class
     * EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testGetAutenticacaoByMacOrIp() throws Exception {
        System.out.println("getAutenticacaoByMacOrIp");
        String str = "";
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
        OSSTurbonetStatusConexaoOut expResult = null;
        OSSTurbonetStatusConexaoOut result = instance.getAutenticacaoByMacOrIp(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoGpon method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testGetInfoGpon() throws Exception {
        System.out.println("getInfoGpon");
        String instancia = "";
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
        ConsultInfoGponOut expResult = null;
        ConsultInfoGponOut result = instance.getInfoGpon(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDao method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testGetDao() {
        System.out.println("getDao");
        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
        OSSGenericDAO expResult = null;
        OSSGenericDAO result = instance.getDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDao method, of class EfikaCustomerServiceOldImpl.
     */
    @Test
    public void testSetDao() throws Exception {
        System.out.println("setDao");
        int count = 0;
        int countf = 0;
        String file = "C:\\Users\\G0041775\\Documents\\lote.csv";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {

            sb.append(line+"\n");
//            sb.append("\n");

            count++;
            if (count > 100) {
                PrintWriter pw = new PrintWriter(new File("C:\\Users\\G0041775\\Documents\\lotes\\lote" + countf + ".csv"));
                pw.write(sb.toString());
                pw.close();
                countf++;
                count = 0;
                sb = new StringBuilder();
            }
        }
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\G0041775\\Documents\\lotes\\lote" + countf + ".csv"));
        pw.write(sb.toString());
        pw.close();

        System.out.println("done!");

//        OSSGenericDAO dao = null;
//        EfikaCustomerServiceOldImpl instance = new EfikaCustomerServiceOldImpl();
//        instance.setDao(dao);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
