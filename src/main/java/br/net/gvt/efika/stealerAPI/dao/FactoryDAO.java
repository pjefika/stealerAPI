/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;
import br.net.gvt.efika.stealerAPI.model.entity.Log;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static InterfaceDAO<EfikaCustomer> createInterfaceClienteDAO() {
        return null;
    }

    public static InterfaceDAO<Log> createLogDAO() {
        return new LogDAO();
    }

    public static WorkOrderDAOInterface createWorkOrderDAO() {
        return new WorkOrderDAO();
    }

    public static OssTurbonetDAOInterface createOssDAO() {
        return new CadastroDAO();
    }

    public static OSSGenericDAO createOSS() {
        return new OSSGenericDAO();
    }

    public static ChamadaBillingDAO createChamadaBillingDAO() {
        return new ChamadaBillingDAOImpl();
    }

}
