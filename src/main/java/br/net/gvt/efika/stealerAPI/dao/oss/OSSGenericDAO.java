/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.oss;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.com.gvt.oss.inventory.service.impl.InventoryImpl;
import br.net.gvt.efika.stealerAPI.dao.FactoryITService;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponIn;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonet;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;

/**
 *
 * @author G0042204
 */
public class OSSGenericDAO {

    private OSSTurbonet ws;
    private InventoryImpl port;
    private GetInfoOut info;

    protected OSSTurbonet oss() {
        if (ws == null) {
            ws = FactoryITService.createOss();
        }
        return ws;
    }

    protected InventoryImpl inventory() throws ServiceException {
        if (port == null) {
            port = FactoryITService.createInvServ().getInventoryImplPort();
        }
        return port;
    }

    public InventoryDesignatorsResponse getAssociatedDesignators(String instancia) throws RemoteException, ServiceException {
        return inventory().getAssociatedDesignators(instancia, null, true);
    }

    public GetInfoOut getInfo(String designador, String designadorAcesso) throws Exception {
        if (info == null) {
            info = oss().getInfo(designador, designadorAcesso, "wise", "wise", designador, "wise", "0", "0");
        }
        return info;
    }

    public InventoryAccountResponse getAccountItems(String designator) throws RemoteException, ServiceException {
        return inventory().getAccountItems(null, null, designator, null, true);
    }

    public OSSTurbonetStatusConexaoOut getAuth(String mac) throws Exception {

        return oss().getAuthenticationByIPorMac(mac);
    }

//    public ConsultInfoGponOut getInfoGpon(String instancia) throws Exception {
//        ConsultInfoGponIn gponIn = new ConsultInfoGponIn(oss().getAccessDesignator(instancia));
//        return oss().consultInfoGpon(gponIn);
//    }

}
