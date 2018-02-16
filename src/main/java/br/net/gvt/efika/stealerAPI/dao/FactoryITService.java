
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.com.gvt.oss.inventory.service.impl.*;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonet;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;

/**
 *
 * @author G0042204
 */
public class FactoryITService {

    public static InventoryService createInvServ() {
        return new InventoryService();
    }

    public static OSSTurbonet createOss() {
        return new OSSTurbonetProxy();
    }

}
