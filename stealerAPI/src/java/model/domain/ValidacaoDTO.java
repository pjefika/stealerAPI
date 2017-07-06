/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import model.domain.enuns.ValidacaoEnum;

/**
 *
 * @author G0042204
 */
public class ValidacaoDTO {

    private ValidacaoEnum valid;

    private Boolean resultado;

    private String mensagem;

    public ValidacaoDTO(ValidacaoEnum valid) {
        this.valid = valid;
    }


    public ValidacaoEnum getValid() {
        return valid;
    }

    public void setValid(ValidacaoEnum valid) {
        this.valid = valid;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public void setResultado(Boolean resultado) {
        this.resultado = resultado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
