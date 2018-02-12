/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.environment;

/**
 *
 * @author G0042204
 */
public enum EfikaEnvironment {

    PROD("10.200.35.67", 80),
    QA("10.40.195.81", 8080);

    private final String ip;

    private final Integer porta;

    private EfikaEnvironment(String ip, Integer porta) {
        this.ip = ip;
        this.porta = porta;
    }

    public String getURL() {
        return "http://" + ip + ":" + porta;
    }

    public String getIp() {
        return ip;
    }

    public Integer getPorta() {
        return porta;
    }

}
