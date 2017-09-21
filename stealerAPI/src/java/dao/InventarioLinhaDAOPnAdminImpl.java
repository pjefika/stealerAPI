/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
import br.net.gvt.efika.customer.TipoCentral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.EfikaResourceBundle;

public class InventarioLinhaDAOPnAdminImpl extends HttpDAO implements InventarioLinhaDAO {

    private NumberInventoryDAOInterface ni = new NumberInventoryDAO();

    @Override
    public InventarioLinha consultar(String instancia) {
        InventarioLinha i = new InventarioLinha();

        String resp = null;

        String bundle = "cred";

        try {
            resp = get("http://" + EfikaResourceBundle.getString(bundle, "login")
                    + ":" + EfikaResourceBundle.getString(bundle, "senha") 
                    + "@pnadmin.gvt.com.br/pn/pn.jsp?numero=" + instancia);
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(\\d{10})(?:.*)(?!Hist)").matcher(resp);
            if (m.find()) {
                i.setDn(m.group(1).trim());
            }
        } catch (Exception e) {
            i.setDn(instancia);
        }

        try {
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(.{5}_.{3}\\d{2})(?:.*)(Hist)").matcher(resp);
//            System.out.println(resp);fix regex crazy
            if (m.find()) {
                i.setCentral(m.group(1).trim());
            }
        } catch (Exception e) {
            i.setCentral(null);
        }

        try {
            i.setTipo(TipoCentral.valueOf(ni.getSwitchInfo(i.getCentral()).getSwitches(0).getSwitchType()));
        } catch (Exception e) {
            i.setTipo(null);
        }

        return i;
    }

}
