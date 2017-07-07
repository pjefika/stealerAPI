/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.domain.EfikaCustomerDTO;
import model.entity.Log;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static EfikaCustomerInterface createClienteDAO() {
        return new ClienteITDAO();
    }

    public static InterfaceDAO<EfikaCustomerDTO> createInterfaceClienteDAO() {
        return null;
    }

    public static InterfaceDAO<Log> createLogDAO() {
        return new LogDAO();
    }

    public static WorkOrderDAOInterface createWorkOrderDAO() {
        return new WorkOrderDAO();
    }

    public static OssTurbonetDAOInterface createManobraDAO() {
        return new CadastroDAO();
    }

}
