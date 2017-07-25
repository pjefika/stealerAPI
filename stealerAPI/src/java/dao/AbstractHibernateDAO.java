/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author G0042204
 */
public class AbstractHibernateDAO {

    private EntityManager em;

    public void persist(Object obj) throws Exception {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    public EntityManager getEm() {
        if (em == null || !em.isOpen()) {
            em = FactoryEntityManager.getInstance();
        }
        return em;
    }

}
