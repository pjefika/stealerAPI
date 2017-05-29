/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import input.TestValues;
import model.entity.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class ClienteComServicoTVJUnitTest {

    public ClienteComServicoTVJUnitTest() {
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
    public void hibrido() {
        ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();
        try {
            Cliente c = dao.consultarCliente(TestValues.HIBRIDO);
            assertEquals(true, c.getServicos().get(0).getIsHib());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void dth() {
        ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();
        try {
            Cliente c = dao.consultarCliente(TestValues.DTH);
            assertEquals(false, c.getServicos().get(0).getIsHib());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
