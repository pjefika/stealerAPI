/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsultaEquipamentoImpl extends HttpDAO implements ConsultaEquipamento {

    @Override
    public String consultar(String instancia) throws Exception {
        String resp = get("http://gvtapp/WebPort/QueryNumber.do?instancia=" + instancia);
//        System.out.println(resp);
        Matcher m = Pattern.compile("(?!<div class=\"server_response\">\\s{0,500})(\\d{10,11}\\s{1})").matcher(resp);
        if (m.find()) {
            return m.group(1).trim();

        }
        return instancia;
    }

}
