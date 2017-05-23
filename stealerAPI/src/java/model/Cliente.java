/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G0041775
 */
@Entity
@Table(name = "STEALERAPI_CLIENTE")
public class Cliente implements Serializable {

    @Id
    private Long ID;

    private Long velDown, velUp;

    private Integer slot, porta, sequencial, logica, rin, vlanVoip, vlanVod, vlanMulticast;

    private String ipDslam, designador, instancia;

    private Boolean isSip, isHib;

    public Cliente() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
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

    public Long getVelDown() {
        return velDown;
    }

    public void setVelDown(Long velDown) {
        this.velDown = velDown;
    }

    public Long getVelUp() {
        return velUp;
    }

    public void setVelUp(Long velUp) {
        this.velUp = velUp;
    }

    public String getIpDslam() {
        return ipDslam;
    }

    public void setIpDslam(String ipDslam) {
        this.ipDslam = ipDslam;
    }

    public Boolean getIsSip() {
        return isSip;
    }

    public void setIsSip(Boolean isSip) {
        this.isSip = isSip;
    }

    public Boolean getIsHib() {
        return isHib;
    }

    public void setIsHib(Boolean isHib) {
        this.isHib = isHib;
    }

    public String getDesignador() {
        return designador;
    }

    public void setDesignador(String designador) {
        this.designador = designador;
    }

}
