/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import dao.FactoryDAO;
import dao.ManobraDAOInterface;
import dao.WorkOrderDAOInterface;
import java.util.ArrayList;
import java.util.List;
import model.domain.validacao.ValidacaoAutenticacao;
import model.domain.validacao.Validator;

/**
 *
 * @author G0042204
 */
public class ValidadorManobra implements ValidadorManobraInterface {

    private WorkOrderDAOInterface w;

    private ManobraDAOInterface m;

    private List<ValidacaoDTO> valids;

    private String order, designador;

    public ValidadorManobra(String designador, String order) {
        this.designador = designador;
        this.order = order;
        valids = new ArrayList<>();
        w = FactoryDAO.createWorkOrderDAO();
    }

    public ValidadorManobra() {
    }

    @Override
    public List<ValidacaoDTO> validar() {
        try {
            GetInfoOut info = m.getInfo(designador);
            this.validar(new ValidacaoAutenticacao(m.isClienteAutenticado(info), w.getWorkOrder(order)));

            return valids;
        } catch (Exception e) {
            return null;
        }
    }

    public void validar(Validator v) {
        v.validar();
        valids.add((ValidacaoDTO) v);
    }

}
