/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.factory;

import br.net.gvt.efika.stealerAPI.model.service.ChamadaBillingService;
import br.net.gvt.efika.stealerAPI.model.service.ChamadaBillingServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOldImpl;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOld;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.NetworkInventoryService;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.SigresNetworkInventoryServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.TbsNetworkInventoryServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static EfikaCustomerServiceOld create() {
        return new EfikaCustomerServiceOldImpl();
    }

    public static ChamadaBillingService createChamadaBillingService() {
        return new ChamadaBillingServiceImpl();
    }

    public static NetworkInventoryService createSigresNetworkInventoryServiceImpl() {
        return new SigresNetworkInventoryServiceImpl();
    }

    public static NetworkInventoryService createTbsNetworkInventoryServiceImpl() {
        return new TbsNetworkInventoryServiceImpl();
    }

}
