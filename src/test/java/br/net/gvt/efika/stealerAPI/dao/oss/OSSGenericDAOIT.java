/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.oss;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import br.net.gvt.efika.util.json.JacksonMapper;

/**
 *
 * @author G0041775
 */
public class OSSGenericDAOIT {

    public OSSGenericDAOIT() {
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
     * Test of getAssociatedDesignators method, of class OSSGenericDAO.
     */
    @Test
    public void testGetAssociatedDesignators() {
        System.out.println("getAssociatedDesignators");
        String instancia = "4130935248";
        OSSGenericDAO instance = new OSSGenericDAO();
//        InventoryDesignatorsResponse expResult = null;
        InventoryDesignatorsResponse result = instance.getAssociatedDesignators(instancia);
        result.getDesignator().forEach((t) -> {
            System.out.println(t.getValue());
        });
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfo method, of class OSSGenericDAO.
     */
    @Test
    public void testGetInfo() throws Exception {
        try {
            System.out.println("getInfo");
            String designador = "BHE-814OM37WK0-013";
            String designadorAcesso = "BHE-20216137-069";
            OSSGenericDAO instance = new OSSGenericDAO();
            GetInfoOut result = instance.getInfo(designador, designadorAcesso);
            System.out.println(new JacksonMapper(GetInfoOut.class).serialize(result));
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

    /**
     * Test of getAccountItems method, of class OSSGenericDAO.
     */
    @Test
    public void testGetAccountItems() throws Exception {
        System.out.println("getAccountItems");
        String designator = "4130776101";
        OSSGenericDAO instance = new OSSGenericDAO();
        InventoryAccountResponse result = instance.getAccountItems(designator);

        System.out.println("RESULT -> " + new JacksonMapper(InventoryAccountResponse.class).serialize(result));

//        result.getAccounts().forEach((t) -> {
//            t.getAddress().forEach((th) -> {
//                th.getItems().forEach((thi) -> {
//
//                    System.out.println("thi->" + thi.getDesignator().getValue());
//                    System.out.println("thi->" + thi.getStatusName());
//                    System.out.println("spec->" + thi.getSpecId());
//                    thi.getItems().forEach((t1) -> {
//                        System.out.println("des_" + t1.getDesignator().getValue());
//                        System.out.println("specId-" + t1.getSpecId());
//                        System.out.println("stat->" + t1.getStatusName());
//                        t1.getItems().forEach((t2) -> {
//                            System.out.println("des_2" + t2.getDesignator().getValue());
//                            System.out.println("specId-2" + t2.getSpecId());
//                            System.out.println("stat->2" + t2.getStatusName());
//                        });
//                    });
//                });
//            });
//        });
    }

    /**
     * Test of getAuth method, of class OSSGenericDAO.
     */
    @Test
    public void testGetAuth() throws Exception {
        System.out.println("getAuth");
        String mac = "";
        OSSGenericDAO instance = new OSSGenericDAO();
        OSSTurbonetStatusConexaoOut expResult = null;
        OSSTurbonetStatusConexaoOut result = instance.getAuth(mac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInfoGpon method, of class OSSGenericDAO.
     */
    @Test
    public void testGetInfoGpon() throws Exception {
        System.out.println("getInfoGpon");
        String instancia = "";
        OSSGenericDAO instance = new OSSGenericDAO();
        ConsultInfoGponOut expResult = null;
        ConsultInfoGponOut result = instance.getInfoGpon(instancia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
