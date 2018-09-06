/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import br.net.gvt.efika.stealerAPI.model.entity.ChamadaBilling;

public class ChamadaBillingDAOImpl extends AbstractHibernateDAO implements ChamadaBillingDAO {

    @Override
    public List<ChamadaBilling> listarPorDataInicio(String instancia, Calendar data) throws Exception {
        Query query = getEmCdrDS().createQuery("FROM ChamadaBilling i "
                + "WHERE "
                + "("
                + "i.numeroOrig =:param1 "
                + "OR i.numeroDest =:param1 "
                + ")"
                + "AND i.dataInicio >:param2");
        query.setParameter("param1", instancia);
        query.setParameter("param2", data);
        query.setMaxResults(10);
        return query.getResultList();
    }

}
