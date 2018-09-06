/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.environment;

/**
 *
 * @author G0042204
 */
public class EnvironmentSingleton {

    private static EnvironmentSingleton instance;

    private final EfikaEnvironment env;

    public static EnvironmentSingleton getInstance() {
        if (instance == null) {
            instance = new EnvironmentSingleton(EfikaEnvironment.PROD);
        }
        return instance;
    }

    protected EnvironmentSingleton(EfikaEnvironment env) {
        this.env = env;
    }

    public EfikaEnvironment getEnv() {
        return env;
    }

}
