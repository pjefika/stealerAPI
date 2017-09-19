
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.oss.inventory.service.impl.*;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonet;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

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
