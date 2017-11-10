/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static EfikaCustomerService create(){
        return new EfikaCustomerServiceImpl();
    }
    
    public static ChamadaBillingService createChamadaBillingService(){
        return new ChamadaBillingServiceImpl();
    }
    
}
