/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;

/**
 *
 * @author G0042204
 */
public interface ServiceInventoryService {

    public EfikaCustomer consultar(String instancia) throws Exception;

}