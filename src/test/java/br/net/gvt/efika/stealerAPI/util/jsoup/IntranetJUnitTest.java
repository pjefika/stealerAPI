/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class IntranetJUnitTest {

    public IntranetJUnitTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void get() throws IOException {
        System.out.println("get");
        Document doc = Jsoup.connect("http://intranet.telefonica.com.br/perfil-publico?idre=3542204")
                .cookie("OAMAuthnCookie_intranet.telefonica.com.br:80", "9xA6CEABfCl2HXXIUNkkKND9xUhlctoUF6%2F626RKCZsrvTaYYSxqk1BDSFXVSE1%2FdGhjvVv6FQE%2F66UEUlhjwaDhamgJ725MtaAdBeYc01Z8XSTQyah%2BYHnrFnHueQZmmXjtqKCKg3QklsPcUGwsSI6pKYdgourr6MAUJDeLUpTUsP6kNZOp4xM2%2Fp1j76gN5iWZ5Fd5y0G2FRPDFoHE8YFJp%2BCiGjNmieyxbEVTQSnfjMCCIZ5MQtEwnInpXVU0fhouhn7yVoWo5WxmRxT6H5TSmlDAcyU5fpf4%2F59J%2FwdYMcqh%2B29CFw2x%2F0M9wm4LDxfIKUzE%2F%2B%2Bj4g47UTGgI%2FCzyRO7pB%2F2dzorKt1k60d2%2FtHqrM%2FnF26CpOXnL6x3YBe1f4KwsHlLgDweR52R6XuVkk2k42Mvs3RuXgAeq3XGrk3QJPr1HPnG36pGK404oPPwsVssNxeo8IIEEuVm8hqZqyafNcVHXOtPAy%2Bbxy02CKIJibb0lavXw62zRjWl%2FqzTzBhX%2F%2B2aapdskrn4E66CzDqKEHdxJjmsQMH1P1x8SSuWJVQZxINJxkHrNtswYGMyLc16t3%2BqaEm036H66nxB569w80nd1LBsk31J%2BI0eUhKs1aIwqLFRq0MLFJvSyPmPEwzlVnFCr0yeAQFAJw%3D%3D")
                .cookie("JSESSIONID", "1zvVhXMhLz5lLgrsWptMnlkpCw3h2BkCk02pdnJnhGTmvx1GdnZq!-1197898673; _ga=GA1.3.460296671.1515415886")
                .timeout(10000)
                .get();

        Element nome = doc.select("input[name='name']").get(0);
        System.out.println("Nome Completo: " + nome.val());

        Element celular = doc.select("input[name='name']").get(1);
        System.out.println("Celular: " + celular.val());

        Element email = doc.select("input[name='name']").get(3);
        System.out.println("Email: " + email.val());

        Element cargo = doc.select("input[name='name']").get(5);
        System.out.println("Cargo: " + cargo.val().toUpperCase());

        Element vp = doc.select("input[name='name']").get(6);
        System.out.println("VP: " + vp.val().toUpperCase());

        Element dir = doc.select("input[name='name']").get(7);
        System.out.println("Dir: " + dir.val().toUpperCase());

        Element area = doc.select("input[name='name']").get(8);
        System.out.println("area: " + area.val().toUpperCase());

        Element gestor = doc.select("input[name='name']").get(9);
        System.out.println("gestor: " + gestor.val().toUpperCase());

        Element local = doc.select("input[name='name']").get(11);
        System.out.println("local: " + local.val().toUpperCase());

        assertTrue(doc != null);
    }
}
