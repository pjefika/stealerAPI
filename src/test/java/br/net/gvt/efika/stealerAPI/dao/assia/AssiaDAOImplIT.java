/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia;

import com.assia.dslo.authentication.api.impl.AuthenticationLocator;
import com.assia.dslo.authentication.api.impl.AuthenticationPortType;
import com.assia.dslo.authentication.api.xsd.AuthSecureTokenBean;
import com.assia.dslo.napi.model.xsd.ParameterBean;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;
import com.assia.dslo.realtime.api.xsd.RealtimeRequest;
import com.assia.dslo.realtime.impl.Realtime;
import com.assia.dslo.realtime.impl.RealtimePortType;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.rpc.ServiceException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class AssiaDAOImplIT {

    public AssiaDAOImplIT() {
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
    public void testSomeMethod() throws ServiceException, RemoteException {
        ParameterBean[] parameterBean = new ParameterBean[1];
        ParameterBean p0 = new ParameterBean();
        com.assia.dslo.realtime.api.xsd.ObjectFactory objFactoryRealTime = new com.assia.dslo.realtime.api.xsd.ObjectFactory();
        com.assia.dslo.napi.model.xsd.ObjectFactory objFactoryModel = new com.assia.dslo.napi.model.xsd.ObjectFactory();
        JAXBElement<String> jaxbType = objFactoryModel.createParameterBeanType("REQUEST_TYPE");
        JAXBElement<String> jaxbVal = objFactoryModel.createParameterBeanType("REAL_TIME_DIAGNOSTICS_WITHOUT_LOCALIZATION");
        p0.setType(jaxbType);
        p0.setValue(jaxbVal);
//        p1.setType("REAL_TIME_ANALYSIS_AFTER_FIX");
//        p1.setValue("true");
        parameterBean[0] = p0;
//        parameterBean[1] = p1;
        String entityID = "CTA-811ZYQTS3-013";
        String requestType = "PON_LINE_SUMMARY_DATA";

        JAXBElement<String> jaxbEntityID = objFactoryRealTime.createRealtimeRequestEntityID(entityID);
        JAXBElement<String> jaxbRequestType = objFactoryRealTime.createRealtimeRequestRequestType(requestType);

        RealtimeRequest r = new RealtimeRequest();
        r.getAdditionalParameters().add(p0);
        r.setEntityID(jaxbEntityID);
        r.setRequestType(jaxbRequestType);
        Realtime rl = new Realtime();
        RealtimePortType p = rl.getRealtimeHttpSoap11Endpoint();

        AuthenticationLocator al = new AuthenticationLocator();
        AuthenticationPortType ap = al.getauthenticationHttpSoap11Endpoint();
        AuthSecureTokenBean auth = ap.login("co_user", "co_user");
        try {
            ((BindingProvider) p).getRequestContext().put(
                    BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
            Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
            List<String> cookies = new ArrayList<String>();
            cookies.add("JSESSIONID=" + auth.getSessionId());
            requestHeaders.put("cookie", cookies);
            ((BindingProvider) p).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);

            ResponseDataBean result = p.submitRequest(r, 30000);
            ap.logout(auth);
            System.out.println("");
        } catch (Exception e) {
            ap.logout(auth);
            throw e;
        }

    }

}
