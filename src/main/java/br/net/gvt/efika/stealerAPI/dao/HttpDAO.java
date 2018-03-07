/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import br.net.gvt.efika.util.bundle.EfikaResourceBundle;

/**
 *
 * @author G0042204
 */
public abstract class HttpDAO {

    public static CloseableHttpClient client(String url) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(1);
        cm.setDefaultMaxPerRoute(1);
        cm.setMaxPerRoute(new HttpRoute(new HttpHost(url)), 50);

        // Cookies
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        return HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(globalConfig)
                .build();
    }

    public String get(String url) throws Exception {
        HttpGet http = new HttpGet(url);

        http.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        http.setHeader("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7");
        http.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        http.setHeader("Cookie", "PN_PREF=rO0ABXNyABFqYXZhLnV0aWwuSGFzaE1hcAUH2sHDFmDRAwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAx3CAAAABAAAAAHdAAPQkRPcyBjb20gZmFsaGFzdAABRXQAA0JET3EAfgADdAAUQmlsaGV0ZSBkZSBBdGl2aWRhZGVxAH4AA3QADVBvcnRhYmlsaWRhZGVxAH4AA3QAAkNYcQB+AAN0AANUQlNxAH4AA3QAGVByb2Nlc3NvIGRhIFBvcnRhYmlsaWRhZGVxAH4AA3g=; ACEPNADMIN=R2630205373; JSESSIONID=997B592C29AAB987D5533DF8D6F7E773; BACKURL=http://pnadmin.gvt.com.br:80/pn/index.jsp; SID=846218; GVT_USER_LOGIN=G0041775; GVT_AUTH_TYPE=NTLM");
        HttpEntity response = client(url).execute(http, context()).getEntity();
        InputStream instream = response.getContent();
        BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        instream.close();
//        System.out.println("RESULTTOSTRING->"+result.toString());
        return result.toString();
    }

    public static HttpClientContext context() throws Exception {
        HttpHost targetHost = new HttpHost("192.168.25.89", 8080, "http");
        InetAddress localMachine = InetAddress.getLocalHost();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                new NTCredentials(EfikaResourceBundle.getString("cred", "login"), EfikaResourceBundle.getString("cred", "senha"), localMachine.getHostName(), "gvt.net.br"));

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);

        return context;
    }

}
