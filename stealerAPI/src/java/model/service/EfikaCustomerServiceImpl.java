/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.OrigemPlanta;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import dao.FactoryDAO;
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
import dao.InventarioLinhaDAOPnAdminImpl;
import dao.exception.ImpossivelIdentificarDesignadoresException;

public class EfikaCustomerServiceImpl implements EfikaCustomerService {

    private EfikaCustomer ec = new EfikaCustomer();

    private OSSGenericDAO dao = FactoryDAO.createOSS();

    private InventarioLinhaDAO linha = new InventarioLinhaDAOPnAdminImpl();

    private GetInfoOut info;

    @Override
    public synchronized EfikaCustomer consultar(String designador) throws Exception {
//        ec.setInstancia(designador);
//        ec.setDesignador(designador);
        InventoryAccountResponse accountItems = dao.getAccountItems(designador);
        System.out.println("");
        InventoryDesignatorsResponse associatedDesignators = dao.getAssociatedDesignators(designador);

        EfikaThread t0 = new EfikaThread(new TratativaAssociatedDesignators(associatedDesignators, ec, accountItems));

        while (t0.isAlive()) {
            Thread.sleep(2000);
        }

        try {
            t0.possuiException();
            EfikaThread t2 = new EfikaThread(new TratativaInventarioServicos(accountItems, ec));
            t2.join();
            if (ec.getRede().getPlanta() == OrigemPlanta.VIVO2) {
                EfikaThread t1 = new EfikaThread(new TratativaInventarioRede(getInfo(), ec));
                EfikaThread t3 = new EfikaThread(new TratativaInventarioLinha(linha.consultar(ec.getInstancia()), ec));
                t1.join();
                t3.join();
                ec.setAsserts(new AssertFacadeFulltestCRM(getInfo()).assertThese());
            }

        } catch (Exception e) {

            if (e.getCause() instanceof InstanciaInvalidaException || e.getCause() instanceof ImpossivelIdentificarDesignadoresException) {
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

    @Override
    public OSSTurbonetStatusConexaoOut getAutenticacaoByMacOrIp(String str) throws Exception {
        return dao.getAuth(str);
    }

    @Override
    public ConsultInfoGponOut getInfoGpon(String instancia) throws Exception {
        return dao.getInfoGpon(instancia);
    }

}
