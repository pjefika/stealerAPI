/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Cliente;
import model.InventarioServico;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static InterfaceDAO<Cliente> createClienteDAO() {
        return new ClienteDAO();
    }

    public static InterfaceDAO<InventarioServico> createServicosDAO() {
        return new ServicosDAO();
    }
}
