/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemInventarioServico;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaAssociatedDesignators;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioServicos;
import br.net.gvt.efika.stealerAPI.dao.exception.ImpossivelIdentificarDesignadoresException;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;

public class SophiaServiceInventoryServiceImpl implements ServiceInventoryService {

    private EfikaCustomer ec;

    @Override
    public synchronized EfikaCustomer consultar(String instancia) throws Exception {
        ec = new EfikaCustomer();
        OSSGenericDAO oss = FactoryDAO.createOSS();
        InventoryAccountResponse accountItems = oss.getAccountItems(instancia);
        InventoryDesignatorsResponse associatedDesignators = oss.getAssociatedDesignators(instancia);
        try {
            new TratativaAssociatedDesignators(associatedDesignators, ec, accountItems).run();
            new TratativaInventarioServicos(accountItems, ec).run();
            ec.getServicos().setOrigem(OrigemInventarioServico.SOPHIA);
        } catch (Exception e) {
            if (e instanceof InstanciaInvalidaException) {
                throw e;
            }
        }
        return ec;
    }

}
