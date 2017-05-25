/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G0041775
 */
@Entity
@Table(name = "STEALERAPI_CLIENTE")
@XmlRootElement(name = "cliente")
public class Cliente extends AbstractEntity {

    private String designador, instancia, designadorAcesso;

    @OneToMany(fetch = FetchType.LAZY)
    private List<InventarioRede> rede;

    @OneToMany(fetch = FetchType.LAZY)
    private List<InventarioServico> servicos;

    public Cliente() {
        rede = new ArrayList<>();
        servicos = new ArrayList<>();
    }

    public String getDesignadorAcesso() {
        return designadorAcesso;
    }

    public void setDesignadorAcesso(String designadorAcesso) {
        this.designadorAcesso = designadorAcesso;
    }

    public String getDesignador() {
        return designador;
    }

    public void setDesignador(String designador) {
        this.designador = designador;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public List<InventarioRede> getRede() {
        return rede;
    }

    public void setRede(List<InventarioRede> rede) {
        this.rede = rede;
    }

    public List<InventarioServico> getServicos() {
        return servicos;
    }

    public void setServicos(List<InventarioServico> servicos) {
        this.servicos = servicos;
    }

}
