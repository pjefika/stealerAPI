/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.InventarioRadius;

/**
 *
 * @author G0042204
 */
public interface InventarioRadiusDAO {

    public InventarioRadius consultarInventarioRadius(GetInfoOut info) throws Exception;

}
