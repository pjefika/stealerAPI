/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.InventarioLinha;
import br.net.gvt.efika.customer.TipoCentral;

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

    protected String getDn(String instancia) {
        try {
            return eqpDAO.consultar(instancia);
        } catch (Exception e) {
            return instancia;
        }
    }

    protected String getSwitch(String instancia) {
        try {
            return numberDAO.getSwitchInfo(instancia).getSwitchName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected TipoCentral getTipoCentral(String instancia) {
        try {
            return numberDAO.getSwitchInfo(instancia).getSwitchType().contentEquals("TDM") ? TipoCentral.TDM : TipoCentral.IMS;
        } catch (Exception e) {
            return null;
        }

    }

}
