/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import input.TestValues;
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

    private final ConsultaEfikaCustomer dao = FactoryDAO.createClienteDAO();

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
        try {
            assertEquals(true, dao.consultar(TestValues.HIBRIDO).getServicos().getIsHib());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void dth() {
        try {
            assertEquals(false, dao.consultar(TestValues.DTH).getServicos().getIsHib());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
