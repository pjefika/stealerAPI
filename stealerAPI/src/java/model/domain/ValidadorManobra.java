/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import br.net.gvt.efika.customer.CustomerAssert;
import dao.WorkOrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import model.domain.validacao.Validator;
import dao.OssTurbonetDAOInterface;

/**
 *
 * @author G0042204
 */
public class ValidadorManobra extends AbstractFulltestFacade implements ValidadorManobraInterface {

    private List<CustomerAssert> asserts;

    private String order, designador;

    public ValidadorManobra(String designador, String order) {
        this.designador = designador;
        this.order = order;
        asserts = new ArrayList<>();

    }

    public ValidadorManobra() {
    }

    @Override
    public List<CustomerAssert> validar() {
        try {
            GetInfoOut info = getM().getInfo(designador);
            WorkOrder wo = getW().getWorkOrder(order);

//            this.validar(new AssertAutenticacaoAposOrdem(m.isClienteAutenticado(info), wo));
//            this.validar(new ValidacaoReparo(wo));
            return asserts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void validar(Validator v) {
        v.validar();
        asserts.add((CustomerAssert) v);
    }

}
