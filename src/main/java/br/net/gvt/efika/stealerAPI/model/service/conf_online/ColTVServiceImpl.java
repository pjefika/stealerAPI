/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.service.conf_online;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.col.tv.ConfOnlineTVDAO;
import java.util.List;

public class ColTVServiceImpl implements ColTVService {

    private ConfOnlineTVDAO dao = FactoryDAO.colTVDAO();

    @Override
    public List<DecoderTV> listStbs(EfikaCustomer ec) throws Exception {
        return dao.getStb(ec.getDesignadorTv());
    }

    @Override
    public List<DecoderTV> diagnosticoHpna(EfikaCustomer ec) throws Exception {
        List<DecoderTV> stbs = listStbs(ec);
        List<DecoderTV> diag = dao.getStbDiagnostics(ec.getDesignador(), ec.getDesignadorTv());
        stbs.forEach((tlist) -> {
            int end = 15;
            if (tlist.getMac().substring(-1).equalsIgnoreCase("F")) {
                end = 13;
            }
            String leMac = tlist.getMac().substring(0, end);
            diag.forEach((tdiag) -> {
                if (tdiag.getMac().contains(leMac)) {
                    tlist.setAttenuation(tdiag.getAttenuation());
                    tlist.setBaudRate(tdiag.getBaudRate());
                    tlist.setCertified(tdiag.getCertified());
                    tlist.setIsPvr(tdiag.getIsPvr());
                    tlist.setPacketsLost(tdiag.getPacketsLost());
                    tlist.setPacketsReceived(tdiag.getPacketsReceived());
                    tlist.setPhyRate(tdiag.getPhyRate());
                    tlist.setSnr(tdiag.getSnr());
                }
            });
        });
        return stbs;
    }

}
