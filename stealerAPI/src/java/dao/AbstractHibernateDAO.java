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

    protected static EntityManager em = FactoryEntityManager.getInstance();

    public void persist(Object obj) throws Exception {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
