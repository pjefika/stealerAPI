/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.EventoMassivo;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemRede;
import com.gvt.ws.eai.oss.inventory.api.InventoryAccountResponse;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import br.net.gvt.efika.stealerAPI.dao.EventosMassivosDAO;
import br.net.gvt.efika.stealerAPI.dao.EventosMassivosDAOImpl;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.exception.ClienteSemBandaException;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import br.net.gvt.efika.stealerAPI.dao.oss.OSSGenericDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.net.gvt.efika.stealerAPI.model.asserts.facade.AssertFacadeFulltestCRMVivo2;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaAssociatedDesignators;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioLinha;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioRede;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioServicos;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAOPnAdminImpl;
import br.net.gvt.efika.stealerAPI.dao.NetworkInventoryDAO;
import br.net.gvt.efika.stealerAPI.dao.NetworkInventoryDAOImpl;
import br.net.gvt.efika.stealerAPI.dao.exception.ImpossivelIdentificarDesignadoresException;
import java.util.List;
import br.net.gvt.efika.stealerAPI.model.asserts.facade.AssertFacadeFulltestCRMVivo1;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaConsultaPorOrdem;
import br.net.gvt.efika.stealerAPI.model.service.tratativa.TratativaInventarioRadius;
import br.net.gvt.efika.util.thread.EfikaThread;
import com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse;

public class EfikaCustomerServiceImpl implements EfikaCustomerServiceOld {

    private EfikaCustomer ec;

    private OSSGenericDAO dao;

    private InventarioLinhaDAO linha;

    private GetInfoOut info;

    @Override
    public synchronized EfikaCustomer consultar(String designador) throws Exception {
        ec = new EfikaCustomer();
        dao = FactoryDAO.createOSS();
        InventoryAccountResponse accountItems = dao.getAccountItems(designador);
        InventoryDesignatorsResponse associatedDesignators = dao.getAssociatedDesignators(designador);

        EfikaThread t0 = new EfikaThread(new TratativaAssociatedDesignators(associatedDesignators, ec, accountItems));
        try {
            t0.join();
//            t0.possuiException();
            EfikaThread t2 = new EfikaThread(new TratativaInventarioServicos(accountItems, ec));
            t2.join();
//            t2.possuiException();
            /**
             * Refatorar!
             */
            if (ec.getRede().getPlanta() != OrigemPlanta.VIVO1) {
                EfikaThread t3 = new EfikaThread(new TratativaInventarioLinha(linha().consultar(ec.getInstancia()), ec));
                EfikaThread t1 = new EfikaThread(new TratativaInventarioRede(getInfo(), ec));
                EfikaThread t5 = new EfikaThread(new TratativaInventarioRadius(getInfo(), ec));
                t3.join();
                t1.join();
                t1.possuiException();
                t5.join();
                ec.setAsserts(new AssertFacadeFulltestCRMVivo2(getInfo()).assertThese());
            } else {
                EfikaThread t4 = new EfikaThread(() -> {
                    try {
                        NetworkInventoryDAO instance = new NetworkInventoryDAOImpl();
                        EfikaCustomer cst2 = instance.consultar(ec.getInstancia());
                        cst2.getRede().setOrigem(OrigemRede.ONLINE);
                        ec.setRede(cst2.getRede());
                        ec.setRedeExterna(cst2.getRedeExterna());
                    } catch (Exception ex) {
                        Logger.getLogger(EfikaCustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                t4.join();
                EfikaThread t6 = new EfikaThread(() -> {
                    try {
                        EventosMassivosDAO instance0 = new EventosMassivosDAOImpl();
                        List<EventoMassivo> lEm = instance0.consultar(ec);
                        ec.setEventos(lEm);
                    } catch (Exception ex) {
                        Logger.getLogger(EfikaCustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                t6.join();
                ec.setAsserts(new AssertFacadeFulltestCRMVivo1(ec).assertThese());
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (e.getCause() instanceof ImpossivelIdentificarDesignadoresException) {
                throw e;
            }
            if (e.getCause() instanceof InstanciaInvalidaException) {
                if (designador.contains("8-")) {
                    TratativaConsultaPorOrdem trat = new TratativaConsultaPorOrdem(designador, ec);
                    trat.run();
                    ec = trat.getC();
                }
            }
            if (e.getCause() instanceof ClienteSemBandaException) {
                EfikaThread t2 = new EfikaThread(new TratativaInventarioServicos(dao.getAccountItems(ec.getDesignador()), ec));
                EfikaThread t3 = new EfikaThread(new TratativaInventarioLinha(linha().consultar(ec.getInstancia()), ec));
                t2.join();
                t3.join();
            }
        }

        return ec;
    }

    public InventarioLinhaDAO linha() {
        if (linha == null) {
            linha = new InventarioLinhaDAOPnAdminImpl();
        }
        return linha;
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

        OSSTurbonetStatusConexaoOut auth = getDao().getAuth(str);
        int i = 0;
        while (auth == null) {
            auth = getDao().getAuth(str);
            i++;
            System.out.println(i);
            if (i > 5) {
                throw new Exception("Falha na consulta autenticação via OSS.");
            }
        }

        return auth;

    }

    @Override
    public ConsultInfoGponOut getInfoGpon(String instancia) throws Exception {
        return getDao().getInfoGpon(instancia);
    }

    public OSSGenericDAO getDao() {
        return dao == null ? FactoryDAO.createOSS() : dao;
    }

    public void setDao(OSSGenericDAO dao) {
        this.dao = dao;
    }

}
