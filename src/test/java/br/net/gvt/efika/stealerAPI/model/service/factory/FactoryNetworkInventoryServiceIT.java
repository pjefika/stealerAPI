/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.factory;

import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.NetworkInventoryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class FactoryNetworkInventoryServiceIT {
    
    public FactoryNetworkInventoryServiceIT() {
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
     * Test of create method, of class FactoryNetworkInventoryService.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        OrigemPlanta planta = null;
        NetworkInventoryService expResult = null;
        NetworkInventoryService result = FactoryNetworkInventoryService.create(planta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
