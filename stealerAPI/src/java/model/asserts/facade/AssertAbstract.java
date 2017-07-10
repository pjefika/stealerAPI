/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import br.net.gvt.efika.asserts.AssertsEnum;

/**
 *
 * @author G0042204
 */
public abstract class AssertAbstract {

    protected AssertsEnum as;

    public AssertAbstract(AssertsEnum as) {
        this.as = as;
    }

}
