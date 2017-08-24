/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inventory;

import br.net.gvt.efika.customer.EfikaCustomer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.EfikaThread;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class AssociatedDesignatorsImplIT {

    public AssociatedDesignatorsImplIT() {
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
     * Test of getAssociatedDesignators method, of class
     * AssociatedDesignatorsImpl.
     */
    @Test
    public void testGetAssociatedDesignators() {
        System.out.println("getAssociatedDesignators");

        EfikaCustomer ec = new EfikaCustomer();

        AssociatedDesignatorsImpl as = new AssociatedDesignatorsImpl(ec);
        AssociatedDesignatorsTestImpl ast = new AssociatedDesignatorsTestImpl(ec);

        EfikaThread t1 = new EfikaThread(as);
        EfikaThread t2 = new EfikaThread(ast);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AssociatedDesignatorsImplIT.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(GsonUtil.serialize(ec));

    }

}
