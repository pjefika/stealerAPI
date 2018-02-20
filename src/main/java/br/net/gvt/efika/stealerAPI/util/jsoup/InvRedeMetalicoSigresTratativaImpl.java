/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

import br.net.gvt.efika.customer.model.customer.InventarioRede;
import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;

public class InvRedeMetalicoSigresTratativaImpl extends GenericTratativaImpl<InventarioRede> {

    @Override
    public InventarioRede parse(String str) throws Exception {
        if (str.contains("Terminal não encontrado")) {
            throw new InstanciaInvalidaException();
        }
        return null;
    }

}
