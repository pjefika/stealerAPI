/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.TipoCentral;

/**
 *
 * @author G0041775
 */
public interface LinhaClienteInterface {

    public String getDn(String instancia);
    
    public String getSwitch(String instancia);
    
    public TipoCentral getTipoCentral(String instancia);
    
}
