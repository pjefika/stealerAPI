/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author G0041775
 */
@Entity
@Table(name = "STEALERAPI_CLIENTE")
public class Cliente extends AbstractEntity {

    private String designador, instancia, designadorAcesso;

    @OneToMany
    private InventarioRede rede;

    @OneToMany
    private InventarioServico servicos;

    public Cliente() {
        rede = new InventarioRede();
        servicos = new InventarioServico();
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

    public InventarioRede getRede() {
        return rede;
    }

    public void setRede(InventarioRede rede) {
        this.rede = rede;
    }

    public InventarioServico getServicos() {
        return servicos;
    }

    public void setServicos(InventarioServico servicos) {
        this.servicos = servicos;
    }

}
