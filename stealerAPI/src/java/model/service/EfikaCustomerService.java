/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;

/**
 *
 * @author G0042204
 */
public interface EfikaCustomerService {

    public EfikaCustomer consultar(String param1) throws Exception;
    
    public OSSTurbonetStatusConexaoOut getAutenticacaoByMacOrIp(String str) throws Exception;
    

}
