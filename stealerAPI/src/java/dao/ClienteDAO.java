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
public class ClienteDAO extends AbstractHibernateDAO implements InterfaceDAO<Cliente> {

    @Override
    public void cadastrar(Cliente obj) throws Exception {
        super.persist(obj);
    }

}
