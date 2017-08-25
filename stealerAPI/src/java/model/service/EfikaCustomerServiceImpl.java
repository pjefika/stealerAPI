/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.FactoryDAO;
import dao.LinhaClienteITDAO;
import dao.LinhaClienteInterface;
import dao.oss.OSSGenericDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.service.tratativa.TratativaAssociatedDesignators;
import model.service.tratativa.TratativaInventarioLinha;
import model.service.tratativa.TratativaInventarioRede;
import model.service.tratativa.TratativaInventarioServicos;
import util.EfikaThread;

public class EfikaCustomerServiceImpl implements EfikaCustomerService {

    private EfikaCustomer ec = new EfikaCustomer();

    private OSSGenericDAO dao = FactoryDAO.createOSS();

    private LinhaClienteInterface linha = new LinhaClienteITDAO();

    private GetInfoOut info;

    @Override
    public synchronized EfikaCustomer consultar(String designador) throws Exception {
        ec.setDesignador(designador);

        EfikaThread t0 = new EfikaThread(new TratativaAssociatedDesignators(dao.getAssociatedDesignators(designador), ec));
        System.out.println("t0");

        t0.join();

        EfikaThread t1 = new EfikaThread(() -> {
            try {
                info = dao.getInfo(ec.getDesignador(), ec.getDesignadorAcesso());
            } catch (Exception ex) {
                Logger.getLogger(EfikaCustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        EfikaThread t2 = new EfikaThread(() -> {
            try {
                info = dao.getInfo(ec.getDesignador(), ec.getDesignadorAcesso());
            } catch (Exception ex) {
                Logger.getLogger(EfikaCustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        new TratativaInventarioRede(getInfo(), ec);

        EfikaThread t3 = new EfikaThread(new TratativaInventarioServicos(dao.getAccountItems(ec.getDesignador()), ec));
        EfikaThread t4 = new EfikaThread(new TratativaInventarioLinha(linha.consultar(ec.getInstancia()), ec));

        try {
            t1.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {

        }

        return ec;
    }

    public GetInfoOut getInfo() {
        return info;
    }

}
