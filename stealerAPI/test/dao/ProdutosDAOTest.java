/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class ProdutosDAOTest {

    public ProdutosDAOTest() {
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
     * Test of getBanda method, of class ProdutosDAO.
     */
    @Test
    public void testGetBanda() {
        System.out.println("getBanda");
        ProdutosDAO instance = new ProdutosDAO("4133335556");
        try {
            instance.getBanda();
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getLinha method, of class ProdutosDAO.
     */
    @Test
    public void testGetLinha() {
        System.out.println("getLinha");
        ProdutosDAO instance = new ProdutosDAO("4133335556");
        try {
            instance.getLinha();
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getTv method, of class ProdutosDAO.
     */
    @Test
    public void testGetTv() {
        System.out.println("getTv");
        ProdutosDAO instance = new ProdutosDAO("4133335556");
        try {
            instance.getTv();
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
