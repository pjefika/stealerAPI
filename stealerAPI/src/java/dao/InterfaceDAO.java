/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author G0042204
 * @param <T>
 */
public interface InterfaceDAO<T> {

    public T consultar(String param1) throws Exception;
    
    public void cadastrar(T obj) throws Exception;

}
