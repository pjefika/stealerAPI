/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.model.domain.InventarioRedeAdapter;

public class TbsNetworkInventoryServiceImpl implements NetworkInventoryService {

    public TbsNetworkInventoryServiceImpl() {
    }

    @Override
    public InventarioRede consultar(EfikaCustomer cust) throws Exception {
        return InventarioRedeAdapter.adapter(FactoryDAO.createOSS().getInfo(cust.getDesignador(), cust.getDesignadorAcesso()));
    }

}
