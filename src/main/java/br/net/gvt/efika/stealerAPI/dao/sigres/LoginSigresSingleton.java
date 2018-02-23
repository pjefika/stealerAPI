/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author G0042204
 */
public class LoginSigresSingleton {

    private Connection.Response login;

    private static LoginSigresSingleton instance = null;

    protected LoginSigresSingleton() {
        // Exists only to defeat instantiation.
    }

    public static LoginSigresSingleton getInstance() {
        if (instance == null) {
            instance = new LoginSigresSingleton();
        }
        return instance;
    }

    protected Connection.Response getLogin() throws Exception {
        try {
            if (login == null) {
                login = Jsoup.connect("http://192.168.236.92/portal/homeLogar.do")
                        .timeout(10000)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .data("pagina_origem", "login")
                        .data("login", "R3542204")
                        .data("senha", "d20M08!")
                        .method(Connection.Method.POST)
                        .execute();
            }
            return login;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao Efetuar Login no SIGRES!");
        }
    }

}
