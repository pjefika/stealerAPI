/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.assia;

import com.assia.dslo.authentication.api.impl.AuthenticationLocator;
import com.assia.dslo.authentication.api.impl.AuthenticationPortType;
import com.assia.dslo.authentication.api.xsd.AuthSecureTokenBean;

/**
 *
 * @author G0041775
 */
public abstract class AbstractAssiaSoapDAO {

    private AuthenticationPortType ap;
    private AuthenticationLocator al = new AuthenticationLocator();
    protected AuthSecureTokenBean auth;

    public AbstractAssiaSoapDAO() {
    }

    public AuthSecureTokenBean login() throws Exception {
        ap = al.getauthenticationHttpSoap11Endpoint();
        auth = ap.login("co_user", "co_user");
        return auth;
    }

    public AuthSecureTokenBean logout() throws Exception {
        return ap.logout(auth);
    }

    public AuthenticationPortType getAp() {
        return ap;
    }

    public AuthenticationLocator getAl() {
        return al;
    }

    public AuthSecureTokenBean getAuth() {
        return auth;
    }

}
