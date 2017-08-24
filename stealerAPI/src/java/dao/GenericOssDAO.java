/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.oss.inventory.service.impl.InventoryImpl;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
import model.service.FactoryITService;

/**
 *
 * @author G0042204
 */
public abstract class GenericOssDAO {

    private OSSTurbonetProxy ws;
    private InventoryImpl port;

    public OSSTurbonetProxy oss() {
        if (ws == null) {
            port = FactoryITService.createInvServ().getInventoryImplPort();
        }
        return ws;
    }

    public InventoryImpl inventory() {
        if (ws == null) {
            port = FactoryITService.createInvServ().getInventoryImplPort();
        }
        return port;
    }

}
