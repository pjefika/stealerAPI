/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

import org.jsoup.select.Elements;

public class IdentTipoTratTratativa extends GenericTratativaImpl<Tratativa, Elements> {

    private final String terminal;

    public IdentTipoTratTratativa(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public Tratativa parse(Elements elem) throws Exception {
        if (terminal.length() < 15 && elem.text().contains(terminal)) {
            System.out.println("trat: InvRedeMetalicoSigresTratativaImpl");
            return new InvRedeMetalicoSigresTratativaImpl();
        } else {
            System.out.println("trat: InvRedeFibraSigresTratativaImpl");
            return new InvRedeFibraSigresTratativaImpl();
        }
    }

}
