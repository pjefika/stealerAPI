/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts;

import br.net.gvt.efika.customer.CustomerAssert;
import dao.FactoryDAO;
import dao.OssTurbonetDAOInterface;
import java.util.List;
import model.asserts.facade.AssertFacadeFulltestCRMVivo2;
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
public class AssertITImplIT {

    private OssTurbonetDAOInterface oss = FactoryDAO.createOssDAO();

    public AssertITImplIT() {
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
     * Test of get method, of class AssertITImpl.
     */
    @Test
    public void testGet() {

        try {
            System.out.println("get");
            Assertter instance = new AssertFacadeFulltestCRMVivo2(oss.getInfo("VPIO-3019VQ1I6-013"));
            List<CustomerAssert> expResult = null;
            List<CustomerAssert> result = instance.assertThese();
            System.out.println("dev");
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
