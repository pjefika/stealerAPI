/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.sigres.EfikaCustomerSigresDAO;

public class LegadoServiceInventoryServiceImpl implements ServiceInventoryService {

    private EfikaCustomerSigresDAO dao;

    public LegadoServiceInventoryServiceImpl() {
        dao = FactoryDAO.createSigresDAO();
    }

    @Override
    public EfikaCustomer consultar(String instancia) throws Exception {
        EfikaCustomer ec = new EfikaCustomer();
        ec.setInstancia(instancia);
        return dao.consultar(ec);
    }

}
