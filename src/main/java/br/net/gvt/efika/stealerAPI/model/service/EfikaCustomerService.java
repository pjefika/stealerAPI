/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;

/**
 *
 * @author G0042204
 */
public interface EfikaCustomerService {

    public EfikaCustomer consultar(String param1) throws Exception;
    
    public OSSTurbonetStatusConexaoOut getAutenticacaoByMacOrIp(String macouip) throws Exception;
    
    public ConsultInfoGponOut getInfoGpon(String instancia) throws Exception;
    

}
