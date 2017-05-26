/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entity.Cliente;

/**
 *
 * @author G0042204
 */
public class FactoryDAO{

    public static ClienteInterfaceDAO<Cliente> createClienteDAO() {
        return new ClienteITDAO();
    }

}
