/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.com.gvt.www.eai.NumberInventoryServicesWS.GetNumberByFilterOut;
import br.com.gvt.www.eai.NumberInventoryServicesWS.GetSwitchInfoByFilterOut;
import java.rmi.RemoteException;

/**
 *
 * @author G0041775
 */
public interface NumberInventoryDAOInterface {
    
    public GetNumberByFilterOut getSwitchInfoByNumber(String instancia) throws RemoteException;
    
    public GetSwitchInfoByFilterOut getSwitchInfo(String central) throws RemoteException;
   
}
