/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia;

import br.net.gvt.efika.util.json.JacksonMapper;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class ClearViewRealTimeDAOImplIT {
    
    public ClearViewRealTimeDAOImplIT() {
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
     * Test of preDefeito method, of class ClearViewRealTimeDAOImpl.
     */
    @Test
    public void testPreDefeito() throws Exception {
        System.out.println("preDefeito");
        String designadorBanda = "CTA-811ZYQTS3-013";
        ClearViewRealTimeDAOImpl instance = new ClearViewRealTimeDAOImpl();

        ResponseDataBean result = instance.preDefeito(designadorBanda);
        System.out.println(new JacksonMapper(ResponseDataBean.class).serialize(result));
    }

    /**
     * Test of posDefeito method, of class ClearViewRealTimeDAOImpl.
     */
    @Test
    public void testPosDefeito() throws Exception {
        System.out.println("posDefeito");
        String designadorBanda = "CTA-811ZYQTS3-013";
        ClearViewRealTimeDAOImpl instance = new ClearViewRealTimeDAOImpl();
        ResponseDataBean result = instance.posDefeito(designadorBanda);
        System.out.println(new JacksonMapper(ResponseDataBean.class).serialize(result));
    }
    
}
