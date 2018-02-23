/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.network_inventory;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.model.domain.InventarioRedeAdapter;

public class TbsNetworkInventoryServiceImpl implements NetworkInventoryService {

    private GetInfoOut info;

    public TbsNetworkInventoryServiceImpl() {
    }

    public TbsNetworkInventoryServiceImpl(GetInfoOut info) {
        this.info = info;
    }

    public GetInfoOut getInfo() {
        return info;
    }

    public void setInfo(GetInfoOut info) {
        this.info = info;
    }

    @Override
    public InventarioRede consultar(String instancia) throws Exception {
        return InventarioRedeAdapter.adapter(info);
    }

}
