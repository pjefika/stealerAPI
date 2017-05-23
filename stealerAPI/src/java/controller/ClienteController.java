/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import model.Cliente;

/**
 *
 * @author G0041775
 */
@Path("/getCliente")
public class ClienteController {

    @Inject
    private ClienteDAO dao;

    @GET 
//    @Produces("application/json")
    @Produces("text/plain")
    public String getCliente(){
        Cliente c = new Cliente();
        c.setDesignador("oi");
        return c.getDesignador();
    }
}
