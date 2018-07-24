/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.util.dao.http.HttpDAOGenericNonProxyImpl;
import br.net.gvt.efika.util.dao.http.exception.ServiceFailureException;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;
import br.net.gvt.efika.util.json.JacksonMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ConsultaUsuarioDAOImpl implements ConsultaUsuarioDAO {

    @Override
    public String getUserArea(String usuario) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://10.40.196.171:8080/auth/usuario/setor?usuario=" + usuario);
        CloseableHttpResponse response = httpClient.execute(get);
        InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
        BufferedReader br = new BufferedReader(reader);
        String output;
        StringBuilder result = new StringBuilder();
        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        httpClient.close();

        return result.toString();
    }

}
