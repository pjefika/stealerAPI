/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.factory;

import br.net.gvt.efika.stealerAPI.model.service.ChamadaBillingService;
import br.net.gvt.efika.stealerAPI.model.service.ChamadaBillingServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.EfikaCustomerServiceOld;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.NetworkInventoryService;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.SigresNetworkInventoryServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.TbsNetworkInventoryServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.service_inventory.LegadoServiceInventoryServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.service_inventory.SophiaServiceInventoryServiceImpl;
import br.net.gvt.efika.stealerAPI.model.service.service_inventory.ServiceInventoryService;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static EfikaCustomerServiceOld create() {
        return new EfikaCustomerServiceImpl();
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
