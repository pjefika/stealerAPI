/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EfikaCustomerInterface;
import dao.FactoryDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.domain.EfikaCustomerDTO;

/**
 *
 * @author G0041775
 */
@Path("/oss")
public class ClienteController implements EfikaCustomerRestInter{

    private EfikaCustomerInterface dao = FactoryDAO.createClienteDAO();

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public EfikaCustomerDTO getCliente(@PathParam("instancia") String instancia) {
        try {
            return dao.consultarCliente(instancia);
        } catch (Exception ex) {
            return new EfikaCustomerDTO(instancia);
        }
    }

}
