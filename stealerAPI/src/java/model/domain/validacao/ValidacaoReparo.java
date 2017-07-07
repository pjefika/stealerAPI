/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.validacao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import model.domain.ValidacaoDTO;
import model.domain.enuns.ValidacaoEnum;

/**
 *
 * @author G0042204
 */
public class ValidacaoReparo extends ValidacaoDTO implements Validator {

    private final WorkOrder order;

    public ValidacaoReparo(WorkOrder order) {
        super(ValidacaoEnum.IS_REPARO);
        this.order = order;
    }

    /**
     * Houve autenticação após abertura da ordem
     *
     * @return
     */
    @Override
    public Boolean validar() {
        try {
            this.setResultado(order.getWorkOrderComprisedOf(0).getWorkOrderItemInvolvesWorkSpec().getSpecificationDescription(0).getValue().equalsIgnoreCase("DEFEITO"));
            if (this.getResultado()) {
                this.setMensagem("Atividade é um Reparo.");
            } else {
                this.setMensagem("Atividade é não um Reparo.");
            }
            return this.getResultado();
        } catch (NullPointerException e) {
            this.setMensagem("Não foi possível realizar validação.");
            return true;
        }
    }
}
