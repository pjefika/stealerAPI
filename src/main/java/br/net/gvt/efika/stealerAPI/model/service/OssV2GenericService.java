/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAOPnAdminImpl;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;
import br.net.gvt.efika.stealerAPI.model.service.service_inventory.SophiaServiceInventoryServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0042204
 */
public abstract class OssV2GenericService {

    private OSSGenericDAO dao;

    private InventarioLinhaDAO linha;

    private GetInfoOut info;

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
