/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.assia;

import br.net.gvt.efika.stealerAPI.dao.ConsultaUsuarioDAO;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.assia.ClearViewRealTimeDAO;
import br.net.gvt.efika.stealerAPI.dao.assia.factory.FactoryAssiaDAO;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;

public class ClearViewRealTimeImpl implements ClearViewRealTime {

    ClearViewRealTimeDAO clearView = FactoryAssiaDAO.clearViewDAO();
    ConsultaUsuarioDAO consultaUsuario = FactoryDAO.consultaUsuario();

    @Override
    public ResponseDataBean exec(String designador, String usuario) throws Exception {
        String area = consultaUsuario.getUserArea(usuario);

        if (area.equalsIgnoreCase("triagem")) {
            return clearView.posDefeito(designador);
        } else if (area.isEmpty()) {
            return null;
        } else {
            return clearView.preDefeito(designador);
        }
    }

}
