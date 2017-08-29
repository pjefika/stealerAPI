/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventarioLinhaDAOPnAdminImpl extends HttpDAO implements InventarioLinhaDAO {

    @Override
    public InventarioLinha consultar(String instancia) {
        InventarioLinha i = new InventarioLinha();
        
        String resp = null;
        
        try {
            resp = get("http://pnadmin.gvt.com.br/pn/pn.jsp?numero=" + instancia);
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(\\d{10})(?:.*)(?!Histórico do Sisnum)").matcher(resp);
            if (m.find()) {
                i.setDn(m.group(1).trim());
            }
        } catch (Exception e) {
            i.setDn(instancia);
        }

        try {
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(.{5}_.{3}\\d{2})(?:.*)(?!Histórico do Sisnum)").matcher(resp);
            if (m.find()) {
                i.setCentral(m.group(1).trim());
            }
        } catch (Exception e) {
            i.setCentral(null);
        }

        return i;
    }

}
