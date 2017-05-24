/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.ClienteDAO;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.Cliente;

/**
 *
 * @author G0041775
 */
@Path("/getCliente/{instancia}")
@Stateless
public class ClienteController {

    private ClienteDAO dao = new ClienteDAO();

    @GET
    @Produces("text/plain")
    public String getCliente(@PathParam("instancia") String instancia) {
//        Cliente c = new Cliente();
//        c.setDesignador("oi");
//        return c.getDesignador();
        Gson g = new Gson();
        try {
            return "{cliente: "+g.toJson(dao.getCliente(instancia), Cliente.class)+"}";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "{exception: "+ex.getMessage()+"}";
        }
    }
}
