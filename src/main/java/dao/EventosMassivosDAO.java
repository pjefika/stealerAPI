/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.EventoMassivo;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface EventosMassivosDAO {

    public List<EventoMassivo> consultar(EfikaCustomer cust) throws Exception;

}
