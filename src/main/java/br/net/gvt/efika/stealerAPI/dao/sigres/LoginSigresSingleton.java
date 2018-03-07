/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import br.net.gvt.efika.util.bundle.EfikaResourceBundle;
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
                        .data("login", EfikaResourceBundle.getString("cred", "sigres.login"))
                        .data("senha", EfikaResourceBundle.getString("cred", "sigres.senha"))
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
