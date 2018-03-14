/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class SigresNetworkInventoryServiceImplIT {

    public SigresNetworkInventoryServiceImplIT() {
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
     * Test of consultar method, of class SigresNetworkInventoryServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            EfikaCustomer cust = new EfikaCustomer();
            cust.setInstancia("110000088932099");
            InventarioRede rede = new InventarioRede();
            rede.setPlanta(OrigemPlanta.VIVO1);
            cust.setRede(rede);
            SigresNetworkInventoryServiceImpl instance = new SigresNetworkInventoryServiceImpl();
            InventarioRede result = instance.consultar(cust);
            assertFalse(result.getIpDslam().isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());

        }
    }

}
