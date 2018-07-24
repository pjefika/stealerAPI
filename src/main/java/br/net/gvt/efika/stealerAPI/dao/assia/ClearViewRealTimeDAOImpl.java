/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia;

import com.assia.dslo.napi.model.xsd.ParameterBean;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;
import com.assia.dslo.realtime.api.xsd.RealtimeRequest;
import com.assia.dslo.realtime.impl.Realtime;
import com.assia.dslo.realtime.impl.RealtimePortType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class ClearViewRealTimeDAOImpl extends AbstractAssiaSoapDAO implements ClearViewRealTimeDAO {

    private Realtime rl = new Realtime();

    @Override
    public ResponseDataBean preDefeito(String designadorBanda) throws Exception {
        ParameterBean[] parameterBean = new ParameterBean[1];
        ParameterBean p0 = new ParameterBean();
        com.assia.dslo.realtime.api.xsd.ObjectFactory objFactoryRealTime = new com.assia.dslo.realtime.api.xsd.ObjectFactory();
        com.assia.dslo.napi.model.xsd.ObjectFactory objFactoryModel = new com.assia.dslo.napi.model.xsd.ObjectFactory();
        JAXBElement<String> jaxbType = objFactoryModel.createParameterBeanType("REQUEST_TYPE");
        JAXBElement<String> jaxbVal = objFactoryModel.createParameterBeanValue("REAL_TIME_DIAGNOSTICS_WITHOUT_LOCALIZATION");
        p0.setType(jaxbType);
        p0.setValue(jaxbVal);
        parameterBean[0] = p0;
        JAXBElement<String> jaxbEntityID = objFactoryRealTime.createRealtimeRequestEntityID(designadorBanda);
        JAXBElement<String> jaxbRequestType = objFactoryRealTime.createRealtimeRequestRequestType("PON_LINE_SUMMARY_DATA");

        RealtimeRequest r = new RealtimeRequest();
        r.getAdditionalParameters().add(p0);
        r.setEntityID(jaxbEntityID);
        r.setRequestType(jaxbRequestType);
        RealtimePortType p = rl.getRealtimeHttpSoap11Endpoint();
        ((BindingProvider) p).getRequestContext().put(
                BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
        Map<String, List<String>> requestHeaders = new HashMap<>();
        List<String> cookies = new ArrayList<>();
        cookies.add("JSESSIONID=" + login().getSessionId());
        requestHeaders.put("cookie", cookies);
        ((BindingProvider) p).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
        ResponseDataBean ret = p.submitRequest(r, 30000);
        logout();
        return ret;
    }

    @Override
    public ResponseDataBean posDefeito(String designadorBanda) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
