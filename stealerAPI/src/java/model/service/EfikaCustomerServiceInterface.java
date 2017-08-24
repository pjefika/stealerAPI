/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.domain.EfikaCustomerDTO;

/**
 *
 * @author G0042204
 */
public interface EfikaCustomerServiceInterface {

    public EfikaCustomerDTO consultar(String param1) throws Exception;

}
