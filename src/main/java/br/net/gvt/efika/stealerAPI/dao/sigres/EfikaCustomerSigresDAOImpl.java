/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.sigres;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customer.model.customer.InventarioRede;
import br.net.gvt.efika.customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.customer.model.customer.enums.OrigemRede;
import br.net.gvt.efika.customer.model.customer.enums.TipoRede;
import br.net.gvt.efika.stealerAPI.dao.InventarioRedeDAO;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import br.net.gvt.efika.util.regex.EfikaRegex;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

    protected String consultarPorTerminal(String terminal) throws Exception {
        try {
            doc = Jsoup.connect("http://192.168.236.92/portal/consultacliente.do")
                    .timeout(10000)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data("pagina_destino", "consulta_terminal")
                    .data("tipoConsulta", "porTerminal")
                    .data("Lp", terminal)
                    .cookies(getLogin().cookies())
                    .post();
            return doc.select("table td.bgform").get(18).text();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar SIGRES!");
        }
    }

    @Override
    public EfikaCustomer consultar(EfikaCustomer cust) throws Exception {
        String result = "";
        if (cust.getInstancia().length() < 15) {
            result = this.consultarPorTerminal(cust.getInstancia());
        } else {
            result = this.consultarPorIdFibra(cust.getInstancia());
        }

        System.out.println("result: " + result);
        if (result.contains("Terminal não encontrado")) {
            throw new InstanciaInvalidaException();
        }

        try {
            InventarioRede rede = new InventarioRede();
            rede.setTipo(TipoRede.GPON);
            rede.setOrigem(OrigemRede.ONLINE);
            rede.setPlanta(OrigemPlanta.VIVO1);
            rede.setNrc(EfikaRegex.capture(result, "(?:NRC.)(\\w{5,10})", 1));
            rede.setIpDslam(EfikaRegex.capture(result, "(?:Equipamento.)(BR_\\w{10,20})", 1));
            rede.setIdOnt(EfikaRegex.capture(result, "(?:Id ONT\\s{0,3})(.{10})", 1));
            rede.setTerminal(EfikaRegex.capture(result, "(?:Terminal.)\\s{0,3}(\\d{10,20})", 1));
            rede.setSlot(new Integer(EfikaRegex.capture(result, "(?:Cartão.{0,5}Cartão\\s{0,3})(\\d{0,2})", 1)));
            rede.setPorta(new Integer(EfikaRegex.capture(result, "(?:Porta.{0,5}Porta\\s{0,3})(\\d{0,2})", 1)));
            rede.setRin(new Integer(EfikaRegex.capture(result, "(?:VLan de Rede\\s{0,3})(\\d{0,4})", 1)));
            rede.setCvlan(new Integer(EfikaRegex.capture(result, "(?:VLan do Usuário\\s{0,3})(\\d{0,3})", 1)));
            rede.setBhs(EfikaRegex.capture(result, "(?:BHS/HGU Instalado\\s{0,3})(\\w{0,3})", 1).equalsIgnoreCase("SIM"));
            rede.setLogica(new Integer(EfikaRegex.capture(result, "(?:Id do Cliente\\s{0,3})(\\w{0,3})", 1)));
            rede.setSequencial(rede.getLogica());
            cust.setRede(rede);
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
