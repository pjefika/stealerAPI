/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import dao.FactoryDAO;
import dao.OssTurbonetDAOInterface;

/**
 *
 * @author G0042204
 */
public abstract class AbstractAssertFacade {

    private OssTurbonetDAOInterface oss;

    public OssTurbonetDAOInterface getOss() {
        if (oss == null) {
            oss = FactoryDAO.createOssDAO();
        }
        return oss;
    }

}
