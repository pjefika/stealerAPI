/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.conf_online;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import java.util.List;

/**
 *
 * @author G0041775
 */
public interface ColTVService {
    
    public List<DecoderTV> listStbs(EfikaCustomer ec) throws Exception;
    
    public List<DecoderTV> diagnosticoHpna(EfikaCustomer ec) throws Exception;
   
}
