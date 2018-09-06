/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author G0042204
 */
public class FactoryEntityManager {

    static EntityManagerFactory emf;

    public static EntityManager getInstance() {

        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("stealerAPIPU");
        }
        return emf.createEntityManager();
    }
}
