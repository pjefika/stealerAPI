/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entity.Log;

/**
 *
 * @author G0042204
 */
public class LogDAO extends AbstractHibernateDAO implements InterfaceDAO<Log> {

    @Override
    public void cadastrar(Log t) throws Exception {
        super.persist(t);
        this.close();
    }

}
