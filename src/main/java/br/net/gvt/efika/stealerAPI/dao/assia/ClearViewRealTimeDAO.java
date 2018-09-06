/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia;

import com.assia.dslo.napi.model.xsd.ResponseDataBean;

/**
 *
 * @author G0041775
 */
public interface ClearViewRealTimeDAO {

    public ResponseDataBean preDefeito(String designadorBanda) throws Exception;

    public ResponseDataBean posDefeito(String designadorBanda) throws Exception;
}
