/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import dao.FactoryDAO;
import dao.WorkOrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import model.domain.validacao.ValidacaoAutenticacao;
import model.domain.validacao.ValidacaoReparo;
import model.domain.validacao.Validator;
import dao.OssTurbonetDAOInterface;

/**
 *
 * @author G0042204
 */
public class ValidadorManobra implements ValidadorManobraInterface {

    private WorkOrderDAOInterface w;

    private OssTurbonetDAOInterface m;

    private List<ValidacaoDTO> valids;

    private String order, designador;

    public ValidadorManobra(String designador, String order) {
        this.designador = designador;
        this.order = order;
        valids = new ArrayList<>();
        w = FactoryDAO.createWorkOrderDAO();
        m = FactoryDAO.createManobraDAO();
    }

    public ValidadorManobra() {
    }

    @Override
    public List<ValidacaoDTO> validar() {
        try {
            GetInfoOut info = m.getInfo(designador);
            WorkOrder wo = w.getWorkOrder(order);
            
            this.validar(new ValidacaoAutenticacao(m.isClienteAutenticado(info), wo));
            this.validar(new ValidacaoReparo(wo));

            return valids;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void validar(Validator v) {
        v.validar();
        valids.add((ValidacaoDTO) v);
    }

}
