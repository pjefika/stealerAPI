
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.webradius;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.util.bundle.EfikaResourceBundle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class EfikaCustomerWebRadiusDAOImpl implements EfikaCustomerWebRadiusDAO {

    private Document doc;
    private final String url = "http://10.18.77.146/webradius/consulta/consulta.php";
    private final int timeout = 10000;

    @Override
    public EfikaCustomer consultar(EfikaCustomer cust) throws Exception {
        System.out.println(this.consultarPorNrc(cust.getRede().getNrc()).text());
        return null;
    }

    protected Elements consultarPorNrc(String nrc) throws Exception {
        try {
            doc = Jsoup.connect(url)
                    .timeout(timeout)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("valor1", nrc)
                    .data("tipo", "n")
                    .data("usuario", EfikaResourceBundle.getString("cred", "webradius.login"))
                    .data("submit", " ")
                    .cookies(LoginWebRadiusSingleton.getInstance().getLogin().cookies())
                    .post();
            return doc.getAllElements();
        } catch (Exception e) {
//            e.printStackTrace();
            throw new Exception("Falha ao consultar WebRadius!");
        }
    }

}
