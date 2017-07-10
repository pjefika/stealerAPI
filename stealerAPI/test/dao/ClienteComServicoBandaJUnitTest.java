/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import input.TestValues;
import model.domain.EfikaCustomerDTO;
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
public class ClienteComServicoBandaJUnitTest {

    private final EfikaCustomerInterface dao = FactoryDAO.createClienteDAO();

    public ClienteComServicoBandaJUnitTest() {
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
    public void velocidade() {
        try {
            assertEquals(true, dao.consultarCliente(TestValues.VEL_51200_25600).getServicos().getVelDown().compareTo(25600l) == 0);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
        @Test
    public void degustacaoTest() {
        try {
            EfikaCustomerDTO oi = dao.consultarCliente("2135563108");
            System.out.println("end");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

  
}
