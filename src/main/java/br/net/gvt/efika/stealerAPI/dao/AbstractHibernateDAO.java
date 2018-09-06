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
public class AbstractHibernateDAO {

    private EntityManagerFactory emf;

    private EntityManager em;

    public void persist(Object obj) throws Exception {
        getEm().getTransaction().begin();
        getEm().persist(obj);
        getEm().getTransaction().commit();
        this.close();
    }

    public EntityManager getEm() {
        if (em == null) {
            em = getEmf().createEntityManager();
        }
        return em;
    }

    public EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("stealerAPIPU");
        }
        return emf;
    }

    public EntityManager getEmCdrDS() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("cdrPU");
            em = emf.createEntityManager();
        }
        return em;
    }

    public void close() {
        try {
            em.close();
        } catch (Exception e) {
        }
        try {
            emf.close();
        } catch (Exception e) {
        }
    }

}
