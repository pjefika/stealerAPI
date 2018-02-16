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
public class WebRadiusJUnitTest {

    public WebRadiusJUnitTest() {
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
    public void post() throws IOException {
        System.out.println("post");

        Document doc = Jsoup.connect("http://10.18.77.146/webradius/consulta/consulta.php")
                .cookie("PHPSESSID", "27k8i2kpvt8um5klrkc8qeqq74riiol015mipd1be047dh9g9871")
                .timeout(10000)
                .data("valor1", "8862301101")
                .data("tipo", "n")
                .data("usuario", "G0048748")
                .data("submit", "\n")
                .post();

        Element nome = doc.select("pre").first();
        System.out.println("");

        assertTrue(doc != null);
    }
}
