/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;

/**
 *
 * @author G0042204
 */
public interface ConsultaEfikaCustomer {

    public EfikaCustomer consultar(String param1) throws Exception;

}