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
public class OrdemInvalidaException extends Exception{

    public OrdemInvalidaException() {
        super("Número da Ordem inválido.");
    }    
    
}
