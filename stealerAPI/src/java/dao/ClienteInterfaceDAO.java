/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.entity.Cliente;
import model.entity.InventarioRede;
import model.entity.InventarioServico;

/**
 *
 * @author G0042204
 * @param <T>
 */
public interface ClienteInterfaceDAO<T> {

    public InventarioRede consultarInventarioRede(String param1) throws Exception;

    public InventarioServico consultarInventarioServico(String param1) throws Exception;

    public Cliente consultarCliente(String param1) throws Exception;

}
