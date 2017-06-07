/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.gvt.oss.inventory.service.impl.*;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static InventoryService create() {
        return new InventoryService();
    }

}
