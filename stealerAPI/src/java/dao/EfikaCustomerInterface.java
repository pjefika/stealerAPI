/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioRede;
import model.domain.EfikaCustomerDTO;

/**
 *
 * @author G0042204
 */
public interface EfikaCustomerInterface {

    public EfikaCustomerDTO consultar(String param1) throws Exception;

//    public InventarioRede consultarInventarioRede(String param1) throws Exception;
}
