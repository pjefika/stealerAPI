/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class ntlmDAOJUnitTest12 {

    public ntlmDAOJUnitTest12() {
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

        String userName = "G0042204";
        String password = "D20m08.118200";
        String proxyHost = "acl.gvt.net.br";

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpget = new HttpGet("http://pnadmin.gvt.com.br/pn/pn.jsp?numero=4130886762");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,
                new NTCredentials(userName, password, "", "GVT"));
        List<String> authtypes = new ArrayList<String>();
        authtypes.add(AuthPolicy.NTLM);
        httpclient.getParams().setParameter(AuthPNames.TARGET_AUTH_PREF, authtypes);

        localContext.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
        HttpResponse response = httpclient.execute(httpget, localContext);

        InputStream instream = response.getEntity().getContent();
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
