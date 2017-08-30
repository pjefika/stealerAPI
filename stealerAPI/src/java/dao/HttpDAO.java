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
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Lookup;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

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

    public String get(String url) throws IOException {
        HttpGet http = new HttpGet(url);

        http.setHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        http.setHeader("Cookie", "JSESSIONID=A588C80B5F44EA0BFE462326555AE387; SID=163436; GVT_USER_LOGIN=G0042204; GVT_AUTH_TYPE=NTLM; ACEPNADMIN=R2630205373");
        HttpEntity response = client(url).execute(http, context()).getEntity();
        InputStream instream = response.getContent();
        BufferedReader rd = new BufferedReader(new InputStreamReader(instream));
        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
//            System.out.println(line);
            result.append(line);
        }
        instream.close();
        return result.toString();
    }

    public static HttpClientContext context() {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY, new NTCredentials("G0042204", "D20m08.11820020", "gvt", "gvt.net.br"));

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);

        return context;
    }

}
