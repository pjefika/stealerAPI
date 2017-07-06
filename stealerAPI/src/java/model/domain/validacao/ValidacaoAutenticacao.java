/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.validacao;

import br.com.gvt.www.ResourceManagement.WorkforceManagement.WorkforceManagementReporting.workOrderReportingEntities.WorkOrder;
import com.gvt.www.ws.eai.oss.OSSTurbonetClienteAutenticado.OSSTurbonetClienteAutenticadoOut;
import model.domain.ValidacaoDTO;
import model.domain.enuns.ValidacaoEnum;

/**
 *
 * @author G0042204
 */
public class ValidacaoAutenticacao extends ValidacaoDTO implements Validator {

    private final OSSTurbonetClienteAutenticadoOut auth;

    private final WorkOrder order;

    public ValidacaoAutenticacao(OSSTurbonetClienteAutenticadoOut auth, WorkOrder order) {
        super(ValidacaoEnum.AUTH_ABERTURA_ORDEM);
        this.auth = auth;
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
            this.setResultado(auth.getDataHoraAutenticacao().after(order.getDateOfSale()));
            if (this.getResultado()) {
                this.setMensagem("Existe autenticação após abertura da atividade.");
            } else {
                this.setMensagem("Não existe autenticação após abertura da atividade.");
            }
            return this.getResultado();
        } catch (NullPointerException e) {
            this.setMensagem("Não foi possível realizar validação.");
            return true;
        }
    }
}
