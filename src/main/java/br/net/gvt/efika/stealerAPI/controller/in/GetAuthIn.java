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
public class GetAuthIn extends LoggerIn {

    private String macOrIp;

    public GetAuthIn() {
    }

    @Override
    public String getAcao() {
        return "ClienteController.getAuth";
    }

    public String getMacOrIp() {
        return macOrIp;
    }

    public void setMacOrIp(String macOrIp) {
        this.macOrIp = macOrIp;
    }

}
