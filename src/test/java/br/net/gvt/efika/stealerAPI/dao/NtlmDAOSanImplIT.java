/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.stealerAPI.dao.NtlmDAOSanImpl;
import br.net.gvt.efika.stealerAPI.model.domain.ntlm.CredencialDominio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class NtlmDAOSanImplIT {

    public NtlmDAOSanImplIT() {
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
     * Test of verificarCredenciais method, of class NtlmDAOSanImpl.
     */
    @Test
    public void testVerificarCredenciais() {
        try {
            System.out.println("verificarCredenciais");
            CredencialDominio cred = new CredencialDominio("#####", "#####");
            NtlmDAOSanImpl instance = new NtlmDAOSanImpl();
            Boolean expResult = true;
            Boolean result = instance.verificarCredenciais(cred);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
