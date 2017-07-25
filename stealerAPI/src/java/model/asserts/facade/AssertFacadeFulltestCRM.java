/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.CustomerAssert;
import dao.FactoryDAO;
import dao.OssTurbonetDAOInterface;
import java.util.ArrayList;
import java.util.List;
import model.asserts.AssertBloqueioRadius;
import model.asserts.AssertCiruitoAtivo;
import model.asserts.AssertITImpl;
import model.asserts.AssertTbsRadiusDivergencia;

/**
 *
 * @author G0042204
 */
public class AssertFacadeFulltestCRM extends AbstractAssertFacade implements AssertITImpl {

    private List<CustomerAssert> as = new ArrayList<>();

    private final GetInfoOut info;

    public AssertFacadeFulltestCRM(GetInfoOut info) {
        this.info = info;
    }

    @Override
    public List<CustomerAssert> get() {
        try {
            as.add(new AssertTbsRadiusDivergencia(getOss().verificarInconsistenciaTBSRadius(info)).claim());
            as.add(new AssertCiruitoAtivo(info).claim());
            as.add(new AssertBloqueioRadius(info.getInfoRadius()).claim());
        } catch (Exception e) {
        }
        
        return as;
    }

}
