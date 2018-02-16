/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller.in;

import br.net.gvt.efika.stealerAPI.model.entity.LoggerIn;

/**
 *
 * @author G0042204
 */
public class ConsultarLinhaIn extends LoggerIn {

    private String instancia;

    public ConsultarLinhaIn() {
    }

    @Override
    public String getAcao() {
        return "LinhaController.consultar";
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String macOrIp) {
        this.instancia = macOrIp;
    }

}
