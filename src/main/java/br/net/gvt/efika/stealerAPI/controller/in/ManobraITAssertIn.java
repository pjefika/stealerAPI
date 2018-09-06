/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller.in;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealer.model.entity.LoggerIn;

/**
 *
 * @author G0042204
 */
public class ManobraITAssertIn extends LoggerIn {

    private EfikaCustomer cust;

    private String workOrderId;

    public ManobraITAssertIn() {
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    @Override
    public String getAcao() {
        return "ControllerManobra.asserts";
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

}
