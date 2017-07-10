/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import dao.FactoryDAO;
import dao.OssTurbonetDAOInterface;
import dao.WorkOrderDAOInterface;

/**
 *
 * @author G0042204
 */
public class AbstractFulltestFacade {

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
