/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.www.ws.eai.oss.OSSTurbonetClienteAutenticado.OSSTurbonetClienteAutenticadoOut;
import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;

/**
 *
 * @author G0042204
 */
public interface OssTurbonetDAOInterface {

    public OSSTurbonetInconsistenciaTBSRadiusOut verificarInconsistenciaTBSRadius(GetInfoOut info) throws Exception;

    public GetInfoOut getInfo(String designador) throws Exception;

    public OSSTurbonetClienteAutenticadoOut isClienteAutenticado(GetInfoOut info) throws Exception;
}
