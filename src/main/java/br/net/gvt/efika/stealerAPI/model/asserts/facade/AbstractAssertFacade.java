/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts.facade;

import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.OssTurbonetDAOInterface;
import br.net.gvt.efika.stealerAPI.dao.WorkOrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import br.net.gvt.efika.stealerAPI.model.asserts.Assertter;

/**
 *
 * @author G0042204
 */
public abstract class AbstractAssertFacade implements Assertter {

    private OssTurbonetDAOInterface oss;

    private WorkOrderDAOInterface work;

    private List<CustomerAssert> as = new ArrayList<>();

    protected OssTurbonetDAOInterface getOss() {
        if (oss == null) {
            oss = FactoryDAO.createOssDAO();
        }
        return oss;
    }

    protected WorkOrderDAOInterface getWork() {
        if (work == null) {
            work = FactoryDAO.createWorkOrderDAO();
        }
        return work;
    }

    @Override
    public List<CustomerAssert> assertThese() throws Exception{
        afirmar();
        return as;
    }

    protected void adicionarAssert(CustomerAssert asserts) {
        as.add(asserts);
    }

    public abstract void afirmar() throws Exception;

}
