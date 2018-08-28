/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.adapter;

import br.com.gvt.www.tv.configuracaoTV.ConsultarEquipamentosTVOut;
import br.net.gvt.efika.stealer.model.entity.DecoderTV;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0041775
 */
public class DecoderDecorator {

    public static List<DecoderTV> createFromEqpsTvOut(ConsultarEquipamentosTVOut out) {
        List<DecoderTV> r = new ArrayList<>();
        for (int i = 0; i < out.getSetTopBox().length; i++) {
            DecoderTV d = new DecoderTV();
            d.setIsPvr(out.getSetTopBox(i).getPvr());
            d.setMac(out.getSetTopBox(i).getMacAddress());
            d.setSerial(out.getSetTopBox(i).getSerial());
            d.setTecnologia(out.getSetTopBox(i).getTecnologiaTV().getValue());
            r.add(d);
        }
        return r;
    }

}
