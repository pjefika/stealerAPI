/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.exception;

/**
 *
 * @author G0042204
 */
public class CircuitoNaoEncontradoException extends Exception {

    public CircuitoNaoEncontradoException() {
        super("Erro de Cadastro - Circuito não assinalado no TBS.");
    }

}
