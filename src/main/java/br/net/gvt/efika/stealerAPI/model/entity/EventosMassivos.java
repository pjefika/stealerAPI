/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.model.entity;

import br.net.gvt.efika.customer.model.customer.EventoMassivo;
import java.util.List;

/**
 *
 * @author G0041775
 */
public class EventosMassivos {

    private List<EventoMassivo> eventos;

    public EventosMassivos() {
    }

    public List<EventoMassivo> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoMassivo> eventos) {
        this.eventos = eventos;
    }

}
