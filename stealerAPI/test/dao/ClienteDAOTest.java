/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import model.entity.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class ClienteDAOTest {

    public ClienteDAOTest() {
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
     * Test of getCliente method, of class ClienteDAO.
     */
    @Test
    public void testGetCliente() {
        System.out.println("getCliente");
        String designador = "1630140007";
        ClienteInterfaceDAO<Cliente> instance = FactoryDAO.createClienteDAO();
        try {
            Cliente result = instance.consultarCliente(designador);
            assertTrue(!result.getRede().get(0).getIpDslam().isEmpty());
        } catch (Exception e) {
            fail();
        }

    }

    /**
     * Test of getDesignador method, of class ClienteDAO.
     */
    @Test
    public void testGetDesignador() {
        System.out.println("getDesignador");
        String instancia = "1630140007";
        ClienteInterfaceDAO<Cliente> instance = FactoryDAO.createClienteDAO();
        try {
            Cliente result = instance.consultarCliente(instancia);
            assertTrue(!result.getDesignador().isEmpty());
            assertTrue(!result.getDesignadorAcesso().isEmpty());
            assertTrue(!result.getDesignador().isEmpty());
        } catch (Exception e) {
            fail();
        }

    }

    /**
     * Test of getAssociatedDesignators method, of class ClienteDAO.
     */
    @Test
    public void testGetAssociatedDesignators() {
        System.out.println("getAssociatedDesignators");
        Cliente c = new Cliente();
        c.setDesignador("1630140007");
        ClienteITDAO instance = new ClienteITDAO();
        instance.getAssociatedDesignators(c);
        assertTrue(!c.getInstancia().isEmpty());

    }

    /**
     * Test of getInfo method, of class ClienteDAO.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        String designador = "1630140007";
        ClienteITDAO instance = new ClienteITDAO();
        try {
            GetInfoOut result = instance.getInfo(designador);
            assertTrue(!result.getTechnology().isEmpty());
        } catch (Exception e) {
            fail();
        }

    }

    /**
     * Test of getAccessDesignator method, of class ClienteDAO.
     */
    @Test
    public void testGetAccessDesignator() {
        System.out.println("getAccessDesignator");
        String designador = "1630140007";
        ClienteITDAO instance = new ClienteITDAO();
        String expResult = "ARQ-02051851-069";
        try {
            String result = instance.getAccessDesignator(designador);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail();
        }

    }

}
