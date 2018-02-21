/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.domain;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G0042204
 */
@XmlRootElement(name = "cliente")
public class EfikaCustomerDTO extends EfikaCustomer {
    
    public EfikaCustomerDTO(EfikaCustomer e) {
        this.setInstancia(e.getInstancia());
    }
    
    public EfikaCustomerDTO(String designador) {
        this.setDesignador(designador);
    }
    
}
