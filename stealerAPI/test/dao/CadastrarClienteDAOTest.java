/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entity.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class CadastrarClienteDAOTest {

    public CadastrarClienteDAOTest() {
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
    public void cadastrar() {
        System.out.println("Cadastrar Cliente");
        String designador = "1630140007";
        ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();
        InterfaceDAO<Cliente> dao2 = (InterfaceDAO<Cliente>) FactoryDAO.createClienteDAO();
        try {
            Cliente c = dao.consultarCliente(designador);
            dao2.cadastrar(c);
            assertTrue(c.getId() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
