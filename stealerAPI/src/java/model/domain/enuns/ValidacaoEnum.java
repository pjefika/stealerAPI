/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain.enuns;

/**
 *
 * @author G0042204
 */
public enum ValidacaoEnum {

    SINCRONISMO("Possui sincronismo?"),
    AUTH_ABERTURA_ORDEM("Houve autenticação após abertura da ordem?"),
    LINHA_MUDA("Reclamação Linha Muda?"),
    RUIDO_CHIADO("Reclamação Ruído e Chiado?"),
    IS_ADSL("É ADSL?"),
    IS_REPARO("É Reparo?");

    private final String nome;

    private ValidacaoEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
