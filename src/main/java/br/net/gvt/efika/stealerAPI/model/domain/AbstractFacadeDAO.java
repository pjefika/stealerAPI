/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.domain;

import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.OssTurbonetDAOInterface;
import br.net.gvt.efika.stealerAPI.dao.WorkOrderDAOInterface;

/**
 *
 * @author G0042204
 */
public class AbstractFacadeDAO {

    private WorkOrderDAOInterface w;

    private OssTurbonetDAOInterface m;

    public WorkOrderDAOInterface getW() {
        if (w == null) {
            w = FactoryDAO.createWorkOrderDAO();
        }
        return w;
    }

    public OssTurbonetDAOInterface getM() {
        if (m == null) {
            m = FactoryDAO.createOssDAO();
        }
        return m;
    }

}
