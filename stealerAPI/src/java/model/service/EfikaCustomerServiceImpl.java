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
import dao.exception.ClienteSemBandaException;
import dao.exception.InstanciaInvalidaException;
import dao.oss.OSSGenericDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.asserts.facade.AssertFacadeFulltestCRM;
import model.service.tratativa.TratativaAssociatedDesignators;
import model.service.tratativa.TratativaInventarioLinha;
import model.service.tratativa.TratativaInventarioRede;
import model.service.tratativa.TratativaInventarioServicos;
import util.EfikaThread;
import dao.InventarioLinhaDAO;

public class EfikaCustomerServiceImpl implements EfikaCustomerService {

    private EfikaCustomer ec = new EfikaCustomer();

    private OSSGenericDAO dao = FactoryDAO.createOSS();

    private InventarioLinhaDAO linha = new LinhaClienteITDAO();

    private GetInfoOut info;

    @Override
    public synchronized EfikaCustomer consultar(String designador) throws Exception {
        ec.setDesignador(designador);

        EfikaThread t0 = new EfikaThread(new TratativaAssociatedDesignators(dao.getAssociatedDesignators(designador), ec));
        t0.join();

        try {
            t0.possuiException();
            EfikaThread t1 = new EfikaThread(new TratativaInventarioRede(getInfo(), ec));
            EfikaThread t2 = new EfikaThread(new TratativaInventarioServicos(dao.getAccountItems(ec.getDesignador()), ec));
            EfikaThread t3 = new EfikaThread(new TratativaInventarioLinha(linha.consultar(ec.getInstancia()), ec));

            t1.join();
            t2.join();
            t3.join();

            ec.setAsserts(new AssertFacadeFulltestCRM(getInfo()).assertThese());

        } catch (Exception e) {
            
            if (e.getCause() instanceof InstanciaInvalidaException) {
                throw e;
            }

            if (e.getCause() instanceof ClienteSemBandaException) {
                EfikaThread t2 = new EfikaThread(new TratativaInventarioServicos(dao.getAccountItems(ec.getDesignador()), ec));
                EfikaThread t3 = new EfikaThread(new TratativaInventarioLinha(linha.consultar(ec.getInstancia()), ec));
                t2.join();
                t3.join();
            }
        }

        return ec;
    }

    public GetInfoOut getInfo() {
        if (info == null) {
            try {
                info = dao.getInfo(ec.getDesignador(), ec.getDesignadorAcesso());
            } catch (Exception ex) {
                Logger.getLogger(EfikaCustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return info;
    }

}
