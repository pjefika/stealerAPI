/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import br.net.gvt.efika.stealerAPI.model.environment.EfikaEnvironment;
import br.net.gvt.efika.stealerAPI.model.environment.EnvironmentSingleton;
import br.net.gvt.efika.util.dao.http.Urls;
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

    private final EfikaEnvironment environment = EnvironmentSingleton.getInstance().getEnv();

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(1);
        cm.setDefaultMaxPerRoute(1);
        HttpHost ip = new HttpHost(environment.getIp(), environment.getPorta());
        cm.setMaxPerRoute(new HttpRoute(ip), 50);

        // Cookies
        RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(globalConfig)
                .build();

        HttpGet httpget = new HttpGet(Urls.NETWORK_INVENTORY_INVENTORY.getUrl() + instancia);
        httpget.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        CloseableHttpResponse response1 = httpclient.execute(httpget);

        if (response1.getStatusLine().getStatusCode() != 200) {
            System.out.println("lelelellelellelele");
            throw new Exception("Cadastro não encontrado na networkInventory");
        }

        StringBuffer result1;
        try (InputStream instream1 = response1.getEntity().getContent()) {
            BufferedReader rd1 = new BufferedReader(new InputStreamReader(response1.getEntity().getContent()));
            result1 = new StringBuffer();
            String line1 = "";
            while ((line1 = rd1.readLine()) != null) {
                result1.append(line1);
            }
        }
        return new ObjectMapper().readValue(result1.toString(), EfikaCustomer.class);
    }

}
