/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.mongo.dao.AbstractMongoDAO;
import br.net.gvt.efika.mongo.dao.MongoEndpointEnum;
import br.net.gvt.efika.stealerAPI.model.entity.Log;

/**
 *
 * @author G0042204
 */
public class LogDAO extends AbstractMongoDAO<Log> implements InterfaceDAO<Log> {

    public LogDAO() {
        //10.40.197.137
        //10.200.35.67
        super(MongoEndpointEnum.MONGO.getIp(), "stealerAPI", Log.class);
    }

    @Override
    public void cadastrar(Log t) throws Exception {
        save(t);
    }

}
