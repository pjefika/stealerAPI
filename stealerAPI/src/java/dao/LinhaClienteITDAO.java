/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.net.gvt.efika.customer.TipoCentral;
import model.domain.EfikaCustomerDTO;

/**
 *
 * @author G0041775
 */
public class LinhaClienteITDAO implements EfikaCustomerInterface, LinhaClienteInterface {

    private final NumberInventoryDAOInterface numberDAO = new NumberInventoryDAO();
    private final ConsultaEquipamentoInterface eqpDAO = new ConsultaEquipamento();

    @Override
    public EfikaCustomerDTO consultarCliente(String param1) throws Exception {
        EfikaCustomerDTO ec = new EfikaCustomerDTO("");
        ec.setInstancia(param1);
        ec.getLinha().setCentral(getSwitch(param1));
        ec.getLinha().setDn(getDn(param1));
        ec.getLinha().setTipo(getTipoCentral(param1));
        return ec;
    }

    @Override
    public String getDn(String instancia) {
        try {
            return eqpDAO.consultar(instancia);
        } catch (Exception e) {
            return instancia;
        }
    }

    @Override
    public String getSwitch(String instancia) {
        try {
            return numberDAO.getSwitchInfo(instancia).getSwitchName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TipoCentral getTipoCentral(String instancia) {
        try {
            return numberDAO.getSwitchInfo(instancia).getSwitchType().contentEquals("TDM") ? TipoCentral.TDM : TipoCentral.IMS;
        } catch (Exception e) {
            return null;
        }

    }

}
