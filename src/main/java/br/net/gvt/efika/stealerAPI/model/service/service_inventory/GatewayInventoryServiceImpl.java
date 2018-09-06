/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryServiceInventory;

public class GatewayInventoryServiceImpl implements ServiceInventoryService {

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        try {
            return FactoryServiceInventory.createSophiaServiceInventoryServiceImpl().consultar(instancia);
        } catch (InstanciaInvalidaException e) {
            System.out.println("Consulta Legado: " + instancia);
            return FactoryServiceInventory.createLegadoServiceInventoryServiceImpl().consultar(instancia);
        }
    }

}
