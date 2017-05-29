/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author G0041775
 */
@Entity
@Table(name = "STEALERAPI_INVENTARIO_REDE")
public class InventarioRede extends AbstractEntity {

    private String ipDslam, vendorDslam, modeloDslam;
    private Integer slot, porta, sequencial, logica, rin, vlanVoip, vlanVod, vlanMulticast;

    public InventarioRede() {
    }

    public InventarioRede(GetInfoOut out) {

    }

    public String getVendorDslam() {
        return vendorDslam;
    }

    public void setVendorDslam(String vendorDslam) {
        this.vendorDslam = vendorDslam;
    }

    public String getModeloDslam() {
        return modeloDslam;
    }

    public void setModeloDslam(String modeloDslam) {
        this.modeloDslam = modeloDslam;
    }

    
    public String getIpDslam() {
        return ipDslam;
    }

    public void setIpDslam(String ipDslam) {
        this.ipDslam = ipDslam;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getPorta() {
        return porta;
    }

    public void setPorta(Integer porta) {
        this.porta = porta;
    }

    public Integer getSequencial() {
        return sequencial;
    }

    public void setSequencial(Integer sequencial) {
        this.sequencial = sequencial;
    }

    public Integer getLogica() {
        return logica;
    }

    public void setLogica(Integer logica) {
        this.logica = logica;
    }

    public Integer getRin() {
        return rin;
    }

    public void setRin(Integer rin) {
        this.rin = rin;
    }

    public Integer getVlanVoip() {
        return vlanVoip;
    }

    public void setVlanVoip(Integer vlanVoip) {
        this.vlanVoip = vlanVoip;
    }

    public Integer getVlanVod() {
        return vlanVod;
    }

    public void setVlanVod(Integer vlanVod) {
        this.vlanVod = vlanVod;
    }

    public Integer getVlanMulticast() {
        return vlanMulticast;
    }

    public void setVlanMulticast(Integer vlanMulticast) {
        this.vlanMulticast = vlanMulticast;
    }

}
