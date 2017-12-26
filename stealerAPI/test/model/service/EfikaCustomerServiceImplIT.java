/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import dao.InventarioLinhaDAO;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class EfikaCustomerServiceImplIT {

    private final String param = "4130886762";

    public EfikaCustomerServiceImplIT() {
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
     * Test of consultar method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testConsultar() {
        try {
            System.out.println("consultar");
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();
            EfikaCustomer result = instance.consultar(param);
            assertTrue("nulo", result != null);
            assertTrue("rede externa", result.getRedeExterna() != null);
            assertTrue("rede", result.getRede() != null);
            System.out.println(GsonUtil.serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of linha method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testLinha() {
        System.out.println("linha");
        EfikaCustomerServiceImpl instance = new EfikaCustomerServiceImpl();
        InventarioLinhaDAO expResult = null;
        InventarioLinhaDAO result = instance.linha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        EfikaCustomerServiceImpl instance = new EfikaCustomerServiceImpl();
        GetInfoOut expResult = null;
        GetInfoOut result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutenticacaoByMacOrIp method, of class
     * EfikaCustomerServiceImpl.
     */
    @Test
    public void testGetAutenticacaoByMacOrIp() throws Exception {
        System.out.println("getAutenticacaoByMacOrIp");
        String str = "ac:c6:62:7e:40:08";
        EfikaCustomerServiceImpl instance = new EfikaCustomerServiceImpl();
//        OSSTurbonetStatusConexaoOut expResult = null;
        OSSTurbonetStatusConexaoOut result = instance.getAutenticacaoByMacOrIp(str);
        System.out.println(GsonUtil.serialize(result));
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoGpon method, of class EfikaCustomerServiceImpl.
     */
    @Test
    public void testGetInfoGpon() throws Exception {
        System.out.println("getInfoGpon");
        String instancia = "";
        EfikaCustomerServiceImpl instance = new EfikaCustomerServiceImpl();
        ConsultInfoGponOut expResult = null;
        ConsultInfoGponOut result = instance.getInfoGpon(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
