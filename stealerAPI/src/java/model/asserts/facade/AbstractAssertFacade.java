/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import br.net.gvt.efika.customer.CustomerAssert;
import dao.FactoryDAO;
import dao.OssTurbonetDAOInterface;
import dao.WorkOrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import model.asserts.Assertter;

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
