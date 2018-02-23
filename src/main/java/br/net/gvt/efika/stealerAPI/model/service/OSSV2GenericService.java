/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAOPnAdminImpl;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;

/**
 *
 * @author G0042204
 */
public abstract class OSSV2GenericService {

    private OSSGenericDAO dao;

    private InventarioLinhaDAO linha;

    protected InventarioLinhaDAO linha() {
        if (linha == null) {
            linha = new InventarioLinhaDAOPnAdminImpl();
        }
        return linha;
    }

    protected OSSGenericDAO getDAO() {
        return dao == null ? FactoryDAO.createOSS() : dao;
    }

}
