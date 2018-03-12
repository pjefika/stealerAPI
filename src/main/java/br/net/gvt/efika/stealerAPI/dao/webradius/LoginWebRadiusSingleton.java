/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.webradius;

import br.net.gvt.efika.util.bundle.EfikaResourceBundle;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author G0042204
 */
public class LoginWebRadiusSingleton {

    private Connection.Response login;

    private static LoginWebRadiusSingleton instance = null;

    protected LoginWebRadiusSingleton() {
    }

    public static LoginWebRadiusSingleton getInstance() {
        if (instance == null) {
            instance = new LoginWebRadiusSingleton();
        }
        return instance;
    }

    public Connection.Response getLogin() throws Exception {
        try {
            if (login == null) {
                login = Jsoup.connect("http://10.18.77.146/webradius/index.php")
                        .timeout(10000)
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .data("usuario", EfikaResourceBundle.getString("cred", "webradius.login"))
                        .data("senha", EfikaResourceBundle.getString("cred", "webradius.senha"))
                        .method(Connection.Method.POST)
                        .execute();

            }
            return login;
        } catch (Exception e) {
            login = null;
            throw new Exception("Falha ao efetuar login no WebRadius!");
        }
    }

}
