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
 */
public class ClienteOfflineDAO implements ClienteInterfaceDAO<Cliente>, InterfaceDAO <Cliente>{

    @Override
    public InventarioRede consultarInventarioRede(String param1) throws Exception {
        return new InventarioRede();
    }

    @Override
    public InventarioServico consultarInventarioServico(String param1) throws Exception {
        return new InventarioServico();
    }

    @Override
    public Cliente consultarCliente(String param1) throws Exception {
        return new Cliente();
    }

    @Override
    public void cadastrar(Cliente t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
