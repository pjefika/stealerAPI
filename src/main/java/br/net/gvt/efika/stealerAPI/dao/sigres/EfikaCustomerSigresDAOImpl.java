/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.dao.InventarioRedeDAO;
import br.net.gvt.efika.stealerAPI.util.jsoup.InvRedeFibraSigresTratativaImpl;
import br.net.gvt.efika.stealerAPI.util.jsoup.InvRedeMetalicoSigresTratativaImpl;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EfikaCustomerSigresDAOImpl implements EfikaCustomerSigresDAO, InventarioRedeDAO {

    private Response login;

    private Document doc;

    protected String consultarPorIdFibra(String idFibra) throws Exception {
        try {
            doc = Jsoup.connect("http://192.168.236.92/portal/consultacliente.do")
                    .timeout(10000)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("pagina_destino", "consulta_terminal")
                    .data("tipoConsulta", "porLp")
                    .data("Lp", idFibra)
                    .cookies(getLogin().cookies())
                    .post();
            return doc.select("table td.bgform").get(18).text();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar SIGRES!");
        }
    }

    protected Elements consultarPorTerminal(String terminal) throws Exception {
        try {
            doc = Jsoup.connect("http://192.168.236.92/portal/consultacliente.do")
                    .timeout(10000)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("pagina_destino", "consulta_terminal")
                    .data("tipoConsulta", "porTerminal")
                    .data("terminal", terminal)
                    .cookies(getLogin().cookies())
                    .post();
            int i = 0;
            for (Element element : doc.select("table td.conttabela")) {
                System.out.println(i + element.text());
                i++;
            }
            return doc.select("table td.conttabela");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar SIGRES!");
        }
    }

    @Override
    public EfikaCustomer consultar(EfikaCustomer cust) throws Exception {
        try {
            if (cust.getInstancia().length() < 15) {
                cust.setRede(new InvRedeMetalicoSigresTratativaImpl().parse(this.consultarPorTerminal(cust.getInstancia())));
            } else {
                cust.setRede(new InvRedeFibraSigresTratativaImpl().parse(this.consultarPorIdFibra(cust.getInstancia())));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tratar informações do SIGRES!");
        }
        return cust;
    }

    protected Response getLogin() throws Exception {
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

    protected void setLogin(Response login) {
        this.login = login;
    }

    @Override
    public InventarioRede consultarInventarioRede(String instancia) throws Exception {
        EfikaCustomer ec = new EfikaCustomer();
        ec.setInstancia(instancia);
        return this.consultar(ec).getRede();
    }

}
