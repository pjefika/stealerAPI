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
public class GetAuthIn extends LoggerIn {

    private String mac;

    public GetAuthIn() {
    }

    @Override
    public String getInput() {
        return "{\"macOrIp\":\"" + mac + "\"}";
    }

    @Override
    public String getAcao() {
        return "ClienteController.getAuth";
    }

    public String getMacOrIp() {
        return mac;
    }

    public void setMacOrIp(String macOrIp) {
        this.mac = macOrIp;
    }

}
