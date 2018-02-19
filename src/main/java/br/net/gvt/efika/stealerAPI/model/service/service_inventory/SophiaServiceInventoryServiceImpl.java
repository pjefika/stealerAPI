/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.service_inventory;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.customer.model.customer.enums.OrigemInventarioServico;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaAssociatedDesignators;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioServicos;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAOPnAdminImpl;
import br.net.gvt.efika.stealerAPI.dao.exception.ImpossivelIdentificarDesignadoresException;
import br.net.gvt.efika.stealerAPI.model.service.OssV2GenericService;

public class SophiaServiceInventoryServiceImpl extends OssV2GenericService implements ServiceInventoryService {

    private EfikaCustomer ec;

    @Override
    public synchronized EfikaCustomer consultar(String instancia) throws Exception {
        ec = new EfikaCustomer();
        InventoryAccountResponse accountItems = getDAO().getAccountItems(instancia);
        InventoryDesignatorsResponse associatedDesignators = getDAO().getAssociatedDesignators(instancia);
        try {
            new TratativaAssociatedDesignators(associatedDesignators, ec, accountItems).run();
            new TratativaInventarioServicos(accountItems, ec).run();
            ec.getServicos().setOrigem(OrigemInventarioServico.SOPHIA);
        } catch (Exception e) {
            if (e.getCause() instanceof InstanciaInvalidaException || e.getCause() instanceof ImpossivelIdentificarDesignadoresException) {
                throw e;
            }
        }
        return ec;
    }

}
