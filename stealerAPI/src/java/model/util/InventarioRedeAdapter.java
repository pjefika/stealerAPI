/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.util;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import model.entity.InventarioRede;

/**
 *
 * @author G0042204
 */
public class InventarioRedeAdapter {

    public static InventarioRede adapter(GetInfoOut out) {

        InventarioRede r = new InventarioRede();
        r.setVendorDslam(out.getInfoTBS().getDslamModel());
        r.setModeloDslam(out.getInfoTBS().getDslamVendor());
        r.setIpDslam(out.getInfoTBS().getIpDslam());
        r.setLogica(new Integer(out.getInfoTBS().getPortAddrSequence().toString()));
        r.setSequencial(new Integer(out.getInfoTBS().getPortAddrSeq().toString()));
        r.setPorta(new Integer(out.getInfoTBS().getPortNumber().toString()));
        r.setRin(new Integer(out.getInfoTBS().getRin()));
        r.setSlot(new Integer(out.getInfoTBS().getSlot().toString()));
        r.setVlanMulticast(out.getInfoTBS().getVlanMcast());
        r.setVlanVod(out.getInfoTBS().getVlanVoD());
        r.setVlanVoip(out.getInfoTBS().getVlanVoIP());

        return r;
    }

}
