/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.assia;

import br.net.gvt.efika.util.json.JacksonMapper;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class ClearViewRealTimeImplIT {

    public ClearViewRealTimeImplIT() {
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
     * Test of exec method, of class ClearViewRealTimeImpl.
     */
    @Test
    public void testExec() throws Exception {
        System.out.println("exec");
        String designador = "SLA-81H9M01I3-013";
        String usuario = "G0035037";
        ClearViewRealTimeImpl instance = new ClearViewRealTimeImpl();

        ResponseDataBean result = instance.exec(designador, usuario);
        System.out.println(new JacksonMapper(ResponseDataBean.class).serialize(result));
    }

}
