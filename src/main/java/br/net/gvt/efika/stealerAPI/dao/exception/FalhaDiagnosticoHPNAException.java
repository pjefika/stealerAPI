/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.exception;

/**
 *
 * @author G0041775
 */
public class FalhaDiagnosticoHPNAException extends Exception {

    public FalhaDiagnosticoHPNAException() {
        super("Falha ao realizar o diagnóstico HPNA.");
    }

    public FalhaDiagnosticoHPNAException(String message) {
        super(message);
    }
    

}
