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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class ClienteComServicoLinhaJUnitTest {

    public ClienteComServicoLinhaJUnitTest() {
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
    public void sip() {
        ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();
        try {
            Cliente c = dao.consultarCliente(TestValues.SIP);
            assertEquals(true, c.getServicos().get(0).getIsSip());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void tdm() {
        ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();
        try {
            Cliente c = dao.consultarCliente(TestValues.TDM);
            assertEquals(false, c.getServicos().get(0).getIsSip());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
