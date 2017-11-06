/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.in;

import model.entity.LoggerIn;

/**
 *
 * @author G0042204
 */
public class GetInfoGponIn extends LoggerIn {

    private String instancia;

    public GetInfoGponIn() {
    }

    @Override
    public String getInput() {
        return "{\"instancia\":\"" + instancia + "\"}";
    }

    @Override
    public String getAcao() {
        return "ClienteController.getInfoGpon";
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

}
