/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryServiceInventory;

public class SigresNetworkInventoryServiceImpl implements NetworkInventoryService {

    @Override
    public EfikaCustomer consultar(EfikaCustomer cust) throws Exception {
        cust.setRede(FactoryServiceInventory.createLegadoServiceInventoryServiceImpl().consultar(cust.getInstancia()).getRede());
        return cust;
    }

}
