/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao;

import br.net.gvt.efika.efika_customer.model.customer.InventarioLinha;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoCentral;

/**
 *
 * @author G0041775
 */
public class LinhaClienteITDAO implements InventarioLinhaDAO {

    private final NumberInventoryDAOInterface numberDAO = new NumberInventoryDAO();
    private final ConsultaEquipamento eqpDAO = new ConsultaEquipamentoImpl();

    @Override
    public InventarioLinha consultar(String instancia) {
        InventarioLinha i = new InventarioLinha();

        i.setCentral(getSwitch(instancia));
        i.setDn(getDn(instancia));
        i.setTipo(getTipoCentral(instancia));

        return i;
    }

    public String getDn(String instancia) {
        try {
            return eqpDAO.consultar(instancia);
        } catch (Exception e) {
            return instancia;
        }
    }

    public String getSwitch(String instancia) {
        try {
            return numberDAO.getSwitchInfoByNumber(instancia).getSwitchName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoCentral getTipoCentral(String instancia) {
        try {
            return numberDAO.getSwitchInfoByNumber(instancia).getSwitchType().contentEquals("TDM") ? TipoCentral.TDM : TipoCentral.IMS;
        } catch (Exception e) {
            return null;
        }

    }

}
