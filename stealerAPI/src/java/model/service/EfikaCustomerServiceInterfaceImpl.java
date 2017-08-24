/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.domain.EfikaCustomerDTO;

public class EfikaCustomerServiceInterfaceImpl implements EfikaCustomerServiceInterface {

    private EfikaCustomer ec = new EfikaCustomer();

    @Override
    public EfikaCustomerDTO consultar(String param1) throws Exception {
        ec.setDesignador(param1);
        return new EfikaCustomerDTO(ec);
    }

}
