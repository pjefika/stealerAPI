/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.asserts;

import br.net.gvt.efika.customer.model.customer.CustomerAssert;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface Assertter {

    public List<CustomerAssert> assertThese() throws Exception;

}
