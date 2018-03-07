/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.EventoMassivo;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface EventosMassivosDAO {

    public List<EventoMassivo> consultar(EfikaCustomer cust) throws Exception;

}
