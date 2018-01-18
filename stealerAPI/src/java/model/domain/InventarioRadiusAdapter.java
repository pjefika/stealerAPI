/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.InventarioRadius;


/**
 *
 * @author G0042204
 */
public class InventarioRadiusAdapter {
    
    public static InventarioRadius adapter(GetInfoOut out) {
        
        InventarioRadius rad = new InventarioRadius();
        
        rad.setArmario(out.getInfoRadius().getCabinet());
        rad.setIpFixo(out.getInfoRadius().getIpProfissional());
        rad.setIsIpFixo(out.getInfoRadius().isProfissional());
        rad.setPorta(new Integer(out.getInfoRadius().getRadiusPort()).toString());
        rad.setProfile(out.getInfoRadius().getRadiusProfile());
        rad.setRin(out.getInfoRadius().getRin());
        rad.setStatus(out.getInfoRadius().getStatus());
        rad.setVelocidade(out.getInfoRadius().getDownUp());
        
        return rad;
    }
    
}
