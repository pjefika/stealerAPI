package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class PostProxyNTLM {

    public static void main(String[] args) {
        // Define dados da requisicao
        String userName = "G0042204";
        String password = "D20m08.118200";
        String proxyHost = "acl.gvt.net.br";
        int proxyPort = 80;

        String domain = "gvt.net.br";
        String url = "http://pnadmin.gvt.com.br/pn/index.jsp";

        DefaultHttpClient httpclient = new DefaultHttpClient();

        // Registra o schema que autentica no CIFS
        httpclient.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
        // Seta o Proxy no HttpClient
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
                proxy);
        // Adiciona a autenticação do Proxy
        httpclient.getCredentialsProvider().setCredentials(
                new AuthScope(proxyHost, proxyPort),
                new NTCredentials(userName, password, proxyHost, domain));
        // Get na URL
        HttpGet httpget = new HttpGet(url);
        // Efetua a requisicao
        HttpResponse status;
        try {
            status = httpclient.execute(httpget);

            BufferedReader rd = new BufferedReader(new InputStreamReader(status.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line;

            System.out.println(status.getStatusLine().getStatusCode());

            while ((line = rd.readLine()) != null) {
                System.out.println(line);
                result.append(line);
            }

            System.out.println(result.toString());
            // Imprime o retorno do GET na URL
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Libera a conexao
            httpget.releaseConnection();
        }
    }
}
