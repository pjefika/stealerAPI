/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.gvt.www.eai.NumberInventoryServicesWS.GetNumberByFilterOut;
import java.rmi.RemoteException;

/**
 *
 * @author G0041775
 */
public interface NumberInventoryDAOInterface {
    
    public GetNumberByFilterOut getSwitchInfo(String instancia) throws RemoteException;
    
   
}
