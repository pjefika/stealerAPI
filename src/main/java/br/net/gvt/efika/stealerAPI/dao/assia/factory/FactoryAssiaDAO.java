/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia.factory;

import br.net.gvt.efika.stealerAPI.dao.assia.ClearViewRealTimeDAO;
import br.net.gvt.efika.stealerAPI.dao.assia.ClearViewRealTimeDAOImpl;

/**
 *
 * @author G0041775
 */
public class FactoryAssiaDAO {

    public static ClearViewRealTimeDAO clearViewDAO() {
        return new ClearViewRealTimeDAOImpl();
    }

}
