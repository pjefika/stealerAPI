/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.util.dao.http.HttpDAOGenericImpl;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 *
 * @author G0042204
 */
public class GenericHttpClientDAO {

    public static EfikaCustomer getNetworkInventoryAPI(String instancia) {
        try {

//            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//            cm.setMaxTotal(1);
//            cm.setDefaultMaxPerRoute(1);
//            HttpHost ip = new HttpHost("10.200.35.67", 80);
//            cm.setMaxPerRoute(new HttpRoute(ip), 50);
//
//            // Cookies
//            RequestConfig globalConfig = RequestConfig.custom()
//                    .setCookieSpec(CookieSpecs.DEFAULT)
//                    .build();
//
//            CloseableHttpClient httpclient = HttpClients.custom()
//                    .setConnectionManager(cm)
//                    .setDefaultRequestConfig(globalConfig)
//                    .build();
//
//            HttpGet httpget = new HttpGet("http://10.200.35.67:80/networkInventoryAPI/networkInventory/" + instancia);
//            httpget.setHeader(HttpHeaders.CONTENT_TYPE, "text/html");
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            InputStream instream = response.getEntity().getContent();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//            StringBuffer result = new StringBuffer();
//            String line = "";
//            while ((line = rd.readLine()) != null) {
//                result.append(line);
//            }
//            instream.close();

            br.net.gvt.efika.util.dao.http.HttpDAO dao = new HttpDAOGenericImpl(EfikaCustomer.class) {
            };

            EfikaCustomer ec = (EfikaCustomer) dao.get("http://10.200.35.67:80/networkInventoryAPI/networkInventory/" + instancia);

            return ec;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}