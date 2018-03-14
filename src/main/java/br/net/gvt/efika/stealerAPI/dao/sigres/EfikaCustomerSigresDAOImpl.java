/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.dao.InventarioRedeDAO;
import br.net.gvt.efika.stealerAPI.util.jsoup.GenericTratativaImpl;
import br.net.gvt.efika.stealerAPI.util.jsoup.IdentTipoTratTratativa;
import br.net.gvt.efika.stealerAPI.util.jsoup.SigresTerminalNaoEncontradoTratativa;
import br.net.gvt.efika.stealerAPI.util.jsoup.Tratativa;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EfikaCustomerSigresDAOImpl implements EfikaCustomerSigresDAO, InventarioRedeDAO {

    private Document doc;
    private final String url = "http://192.168.236.92/portal/consultacliente.do";
    private final int timeout = 10000;

    @Override
    public EfikaCustomer consultar(EfikaCustomer cust) throws Exception {
        try {
            Elements ret;
            if (cust.getInstancia().length() < 15) {
                ret = this.consultarPorTerminal(cust.getInstancia());
            } else {
                ret = this.consultarPorIdFibra(cust.getInstancia());
            }

            new SigresTerminalNaoEncontradoTratativa().parse(ret);
            GenericTratativaImpl<Tratativa, Elements> trat = new IdentTipoTratTratativa(cust.getInstancia());
            Tratativa<InventarioRede, Elements> parse = trat.parse(ret);
            cust.setRede(parse.parse(ret));
            return cust;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao tratar informações do SIGRES!");
        }
    }

    protected Elements consultarPorIdFibra(String idFibra) throws Exception {
        System.out.println("consultarPorIdFibra");
        try {
            doc = Jsoup.connect(url)
                    .timeout(timeout)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("pagina_destino", "consulta_terminal")
                    .data("tipoConsulta", "porLp")
                    .data("Lp", idFibra)
                    .cookies(getLogin().cookies())
                    .post();
            return doc.select("table td.bgform");
        } catch (Exception e) {
//            e.printStackTrace();
            throw new Exception("Falha ao consultar SIGRES!");
        }
    }

    protected Elements consultarPorTerminal(String terminal) throws Exception {
        System.out.println("consultarPorTerminal");
        try {
            doc = Jsoup.connect(url)
                    .timeout(timeout)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("pagina_destino", "consulta_terminal")
                    .data("tipoConsulta", "porTerminal")
                    .data("terminal", terminal)
                    .cookies(getLogin().cookies())
                    .post();
            int i = 0;
            Elements select = doc.select("center");
            for (Element element : select) {
                System.out.println(i + element.text());
                i++;
            }
            return select;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar SIGRES!");
        }
    }

    protected Response getLogin() throws Exception {
        return LoginSigresSingleton.getInstance().getLogin();
    }

    @Override
    public InventarioRede consultarInventarioRede(String instancia) throws Exception {
        EfikaCustomer ec = new EfikaCustomer();
        ec.setInstancia(instancia);
        return this.consultar(ec).getRede();
    }

}
