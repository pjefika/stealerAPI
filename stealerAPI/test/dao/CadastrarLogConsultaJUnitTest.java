/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import input.TestValues;
import model.entity.Log;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class CadastrarLogConsultaJUnitTest {

    private ConsultaEfikaCustomer dao = FactoryDAO.createClienteDAO();

    private InterfaceDAO<Log> ldao = FactoryDAO.createLogDAO();

    public CadastrarLogConsultaJUnitTest() {
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
    public void consultarCliente() {
        try {
            EfikaCustomer out = dao.consultar(TestValues.HIBRIDO);
            try {
                Log l = new Log("ClienteController.getCliente");
                l.setInput(out.getInstancia());
                l.setOuput(GsonUtil.serialize(out));
                ldao.cadastrar(l);
                assertTrue(l.getId() != null);
            } catch (Exception e) {
                fail(e.getMessage());
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
