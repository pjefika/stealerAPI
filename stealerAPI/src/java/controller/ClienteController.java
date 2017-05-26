/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FactoryDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.entity.Cliente;
import dao.ClienteInterfaceDAO;

/**
 *
 * @author G0041775
 */
@Path("/cliente")
public class ClienteController {

    private ClienteInterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("instancia") String instancia) {
        try {
            return dao.consultarCliente(instancia);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Cliente(instancia);
        }
    }

}
