/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.inventory;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.GenericOssDAO;

public class AssociatedDesignatorsImpl extends GenericOssDAO implements AssociatedDesignators, Runnable {

    private EfikaCustomer c;

    public AssociatedDesignatorsImpl(EfikaCustomer c) {
        this.c = c;
    }

    @Override
    public void getAssociatedDesignators() {
        c.setInstancia("getAssociatedDesignators");
    }

    @Override
    public void run() {
        this.getAssociatedDesignators();
    }

}
