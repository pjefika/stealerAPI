/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.enums.TecnologiaLinha;
import br.net.gvt.efika.enums.TecnologiaTv;
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
            assertEquals(TecnologiaLinha.SIP, dao.consultar(TestValues.SIP).getServicos().getTipoLinha());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void tdm() {
        try {
            assertEquals(TecnologiaLinha.TDM, dao.consultar(TestValues.TDM).getServicos().getTipoLinha());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
