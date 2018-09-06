/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.factory;

import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.stealerAPI.model.service.network_inventory.NetworkInventoryService;

/**
 *
 * @author G0042204
 */
public class FactoryNetworkInventoryService {

    public static NetworkInventoryService create(OrigemPlanta planta) throws Exception {
        if (OrigemPlanta.VIVO1 == planta) {
            return FactoryService.createSigresNetworkInventoryServiceImpl();
        }

        if (OrigemPlanta.VIVO2 == planta) {
            return FactoryService.createTbsNetworkInventoryServiceImpl();
        }

        throw new Exception("Tipo Planta não informado.");
    }

}
