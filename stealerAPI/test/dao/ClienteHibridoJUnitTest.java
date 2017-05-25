/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
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
public class ClienteHibridoJUnitTest {

    public ClienteHibridoJUnitTest() {
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

    @Test
    public void clienteHibrido() {

        InterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();

        try {
            Cliente c = dao.consultar("4130222839");
            assertEquals(true, c.getServicos().get(0).getIsHib());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
