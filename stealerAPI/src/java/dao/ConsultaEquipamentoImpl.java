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
        System.out.println(resp);
        Matcher m = Pattern.compile("(?<!\\d)\\d{10,11}(?!\\d)").matcher(resp);
        if(m.find(resp.indexOf("server_response"))){
            return m.group();
        }
        return null;
    }

}
