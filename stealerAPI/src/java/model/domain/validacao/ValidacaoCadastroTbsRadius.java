/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.validacao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;
import model.domain.ValidacaoDTO;
import model.domain.enuns.ValidacaoEnum;

/**
 *
 * @author G0042204
 */
public class ValidacaoCadastroTbsRadius extends ValidacaoDTO implements Validator {

    private final OSSTurbonetInconsistenciaTBSRadiusOut oss;

    private final GetInfoOut info;

    public ValidacaoCadastroTbsRadius(OSSTurbonetInconsistenciaTBSRadiusOut oss, GetInfoOut info) {
        super(ValidacaoEnum.DIVERGENCIA_TBS_RADIUS);
        this.oss = oss;
        this.info = info;
    }

    /**
     * Houve autenticação após abertura da ordem
     *
     * @return
     */
    @Override
    public Boolean validar() {
        try {

            if (oss.getEhInconsistente()) {
                this.setMensagem("Inconsistência entre TBS e Radius.");
                this.setResultado(Boolean.FALSE);
            }

            if (!info.getInfoTBS().getStatus().equalsIgnoreCase("ATIVO")) {
                this.setMensagem("Circuito TBS com Estado diferente de ATIVO.");
                this.setResultado(Boolean.FALSE);
            }

        } catch (NullPointerException e) {
            this.setMensagem("Não foi possível realizar validação.");
            this.setResultado(Boolean.TRUE);
        }
        return this.getResultado();
    }
}
