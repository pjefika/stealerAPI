/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util;

import br.net.gvt.efika.stealerAPI.util.EfikaResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class EfikaResourceBundleIT {

    public EfikaResourceBundleIT() {
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
     * Test of getString method, of class EfikaResourceBundle.
     */
    @Test
    public void testGetString() throws Exception {
        System.out.println("getString");
        String label = "login";
        EfikaResourceBundle instance = new EfikaResourceBundle();
        String result = instance.getString("cred", label);
        System.out.println(result);
        assertTrue(!result.isEmpty());
    }

}
