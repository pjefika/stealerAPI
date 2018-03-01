/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.stealerAPI.model.entity.Log;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class LogDAOIT {

    public LogDAOIT() {
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
     * Test of cadastrar method, of class LogDAO.
     */
    @Test
    public void testCadastrar() throws Exception {
        try {
            LogDAO instance = new LogDAO();
            System.out.println("cadastrar");
            Log t = new Log();
            t.setAction("Teste");
            t.setExecutor("G0042204");
            instance.cadastrar(t);
        } catch (Exception e) {
            fail(e.getMessage());

        }

    }

}
