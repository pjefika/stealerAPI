/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.EventoMassivo;
import br.net.gvt.efika.util.util.json.JacksonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import br.net.gvt.efika.stealerAPI.model.entity.EventosMassivos;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

public class EventosMassivosDAOImpl extends HttpDAO implements EventosMassivosDAO {

    @Override
    public List<EventoMassivo> consultar(EfikaCustomer cust) throws Exception {
        HttpClient httpcliente = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://10.40.198.168:8080/plrestAPI/eventosMassivos/afetaCliente");

        // Request parameters and other properties.
        StringEntity param = new StringEntity("{\"cust\": " + new JacksonMapper(EfikaCustomer.class).serialize(cust) + " , \"executor\": \"stealerAPI\"}");
        httppost.addHeader("content-type", "application/json");
        httppost.setEntity(param);

        //Execute and get the response.
        HttpResponse response = httpcliente.execute(httppost);
        HttpEntity entity = response.getEntity();

        InputStream instream = entity.getContent();

        BufferedReader rd = new BufferedReader(new InputStreamReader(entity.getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
//            System.out.println("leLine->"+line);
        }
//        System.out.println("leResult->"+result.toString());
        instream.close();
        
        EventosMassivos evM = new ObjectMapper().readValue(result.toString(), EventosMassivos.class);
        return evM.getEventos();
    }

}
