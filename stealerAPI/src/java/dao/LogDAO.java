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
public class LogDAO extends AbstractMongoDAO<Log> implements InterfaceDAO<Log> {

    public LogDAO() {
        super("10.40.197.137", "stealerAPI", Log.class);
    }

    @Override
    public void cadastrar(Log t) throws Exception {
        save(t);
    }

}
