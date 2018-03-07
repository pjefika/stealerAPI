/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsultaEquipamentoImpl extends HttpDAO implements ConsultaEquipamento {

    @Override
    public String consultar(String instancia) throws Exception {
        String resp = get("http://pnadmin.gvt.com.br/pn/pn.jsp?numero=" + instancia);
//        System.out.println(resp);
        try {
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(\\d{10})(?:.*)(?!Histórico do Sisnum)").matcher(resp);
            if (m.find()) {
                return m.group(1).trim();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instancia;
    }

}
