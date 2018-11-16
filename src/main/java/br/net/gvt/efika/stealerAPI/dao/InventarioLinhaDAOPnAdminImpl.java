/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.InventarioLinha;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoCentral;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import br.net.gvt.efika.util.bundle.EfikaResourceBundle;

public class InventarioLinhaDAOPnAdminImpl extends HttpDAO implements InventarioLinhaDAO {

    private NumberInventoryDAOInterface ni;

    @Override
    public InventarioLinha consultar(String instancia) {
        InventarioLinha i = new InventarioLinha();

        String resp = null;

        String bundle = "cred";

        try {
            resp = getComCookie("http://" + EfikaResourceBundle.getString(bundle, "login")
                    + ":" + EfikaResourceBundle.getString(bundle, "senha")
                    + "@pnadmin.gvt.com.br/pn/pn.jsp?numero=" + instancia);
//            System.out.println("PIRACEMA0");
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(\\d{10})(?:.*)(?!Hist)").matcher(resp);
            if (m.find()) {
                i.setDn(m.group(1).trim());
            }
        } catch (Exception e) {
//            System.out.println("ERROSETDN->");
            e.printStackTrace();
            i.setDn(instancia);
        }

        try {
//            System.out.println("PIRACEMA1");
            Matcher m = Pattern.compile("(?:Registro no Sisnum)(?:.*)(.{5}_.{3}\\d{2})(?:.*)(Hist)").matcher(resp);
//            System.out.println(resp);fix regex crazy
            if (m.find()) {
                i.setCentral(m.group(1).trim());
            }
        } catch (Exception e) {
//            System.out.println("ERROsetCentral->");
            e.printStackTrace();
            i.setCentral(null);
        }

//            System.out.println("PIRACEMA2");
        try {
            ni = new NumberInventoryDAO();
            i.setTipo(TipoCentral.valueOf(ni.getSwitchInfo(i.getCentral()).getSwitches(0).getSwitchType()));
        } catch (Exception e) {
            System.out.println("ERROsetTipo->");
            e.printStackTrace();
            i.setTipo(null);
        }

        System.out.println("PIRACEMA122");
        return i;
    }

}
