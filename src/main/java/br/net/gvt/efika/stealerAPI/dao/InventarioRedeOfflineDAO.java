/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.customer.InventarioRede;
import br.net.gvt.efika.enums.OrigemRede;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventarioRedeOfflineDAO extends GenericHttpClientDAO implements
        InventarioRedeDAO {

    private static final Logger LOG = Logger.getLogger(InventarioRedeOfflineDAO.class.getName());

    private InventarioRede rede;

    public InventarioRedeOfflineDAO() {
        rede = new InventarioRede();
    }

    @Override
    public InventarioRede consultarInventarioRede(String instancia) throws Exception {
        try {
            rede = this.getNetworkInventoryAPI(instancia).getRede();
            rede.setOrigem(OrigemRede.OFFLINE);
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
        }
        return rede;
    }

}
