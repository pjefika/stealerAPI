/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class ntlmDAOJUnitTest {

    public ntlmDAOJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    public void test() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createSystem();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        InetAddress localMachine = InetAddress.getLocalHost();
        credsProvider.setCredentials(AuthScope.ANY,
                new NTCredentials("G0042204", "D20m08.118201023", localMachine.getHostName(), "gvt.net.br"));
        HttpHost target = new HttpHost("sv2kpsan1.gvt.net.br");
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        HttpGet httpget = new HttpGet("http://sv2kpsan1.gvt.net.br/ChamadoSAN/");
        CloseableHttpResponse response1 = httpclient.execute(target, httpget, context);
        System.out.println(response1.getStatusLine().getStatusCode());
        InputStream instream = response1.getEntity().getContent();
        BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            result.append(line);
        }
        instream.close();
    }
}
