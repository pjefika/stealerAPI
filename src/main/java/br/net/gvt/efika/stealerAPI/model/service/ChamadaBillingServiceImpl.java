/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import br.net.gvt.efika.stealerAPI.dao.ChamadaBillingDAO;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import java.util.Calendar;

public class ChamadaBillingServiceImpl implements ChamadaBillingService {

    private ChamadaBillingDAO dao;

    @Override
    public Boolean possuiChamada(String instancia, Calendar data) {
        try {
            dao = FactoryDAO.createChamadaBillingDAO();
            return !dao.listarPorDataInicio(instancia, data).isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
