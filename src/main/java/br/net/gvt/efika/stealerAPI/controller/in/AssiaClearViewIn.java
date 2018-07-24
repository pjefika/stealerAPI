/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller.in;

import br.net.gvt.efika.stealerAPI.model.entity.LoggerIn;

/**
 *
 * @author G0042204
 */
public class AssiaClearViewIn extends LoggerIn {

    private String designador;

    public AssiaClearViewIn() {
    }

    @Override
    public String getAcao() {
        return "AssiaController.clearViewRealTime";
    }

    public String getDesignador() {
        return designador;
    }

    public void setDesignador(String designador) {
        this.designador = designador;
    }

}
