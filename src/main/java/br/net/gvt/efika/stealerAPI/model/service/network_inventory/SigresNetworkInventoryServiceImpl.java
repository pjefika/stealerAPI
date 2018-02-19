/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import br.net.gvt.efika.customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.model.service.FactoryService;

public class SigresNetworkInventoryServiceImpl implements NetworkInventoryService {

    @Override
    public InventarioRede consultar(String instancia) throws Exception {
        return FactoryService.createLegadoServiceInventoryServiceImpl().consultar(instancia).getRede();
    }

}
