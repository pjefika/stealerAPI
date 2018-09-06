/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class TbsNetworkInventoryServiceImplIT {

    public TbsNetworkInventoryServiceImplIT() {
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
     * Test of consultar method, of class TbsNetworkInventoryServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("4130886762");
            cust.setDesignador("CTA-81MMWYSLO-013");
            cust.setDesignadorAcesso("CTA-17074589-069");
            TbsNetworkInventoryServiceImpl instance = new TbsNetworkInventoryServiceImpl();
            InventarioRede result = instance.consultar(cust);
            System.out.println(new JacksonMapper<>(InventarioRede.class).serialize(result));
            assertTrue("Nuladade", result != null);
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }

}
