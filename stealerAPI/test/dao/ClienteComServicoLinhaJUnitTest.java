/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import input.TestValues;
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

    private final ConsultaEfikaCustomer dao = FactoryDAO.createClienteDAO();

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
        try {
            assertEquals(true, dao.consultar(TestValues.SIP).getServicos().getIsSip());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void tdm() {
        try {
            assertEquals(false, dao.consultar(TestValues.TDM).getServicos().getIsSip());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
