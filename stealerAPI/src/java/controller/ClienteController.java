/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FactoryDAO;
import dao.InterfaceDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Cliente;

/**
 *
 * @author G0041775
 */
@Path("/cliente")
@Stateless
public class ClienteController {

    private InterfaceDAO<Cliente> dao = FactoryDAO.createClienteDAO();

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("instancia") String instancia) {

        try {
            return dao.consultar(instancia);
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
