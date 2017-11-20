/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioRede;
import com.google.gson.Gson;
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

public class NetworkInventoryDAOImpl implements NetworkInventoryDAO {

    @Override
    public InventarioRede consultar(String instancia) throws Exception {

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(1);
        cm.setDefaultMaxPerRoute(1);
        HttpHost ip = new HttpHost("10.200.35.67", 80);
        cm.setMaxPerRoute(new HttpRoute(ip), 50);

        // Cookies
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(globalConfig)
                .build();

        HttpGet httpget = new HttpGet("http://10.200.35.67:80/networkInventoryAPI/networkInventory/" + instancia);
        httpget.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        CloseableHttpResponse response1 = httpclient.execute(httpget);

        if (response1.getStatusLine().getStatusCode() != 200) {
            throw new Exception("Cadastro não encontrado na networkInventory");
        }

        InputStream instream1 = response1.getEntity().getContent();
        BufferedReader rd1 = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
        StringBuffer result1 = new StringBuffer();
        String line1 = "";
        while ((line1 = rd1.readLine()) != null) {
            result1.append(line1);
        }
        instream1.close();

        Gson g1 = new Gson();
        EfikaCustomer ec1 = g1.fromJson(result1.toString(), EfikaCustomer.class);
        return ec1.getRede();
    }

}
