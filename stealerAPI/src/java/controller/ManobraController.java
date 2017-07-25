/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.FactoryDAO;
import dao.InterfaceDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.asserts.Assertter;
import model.asserts.facade.AssertsManobra;
import model.entity.Log;

/**
 *
 * @author G0041775
 */
@Path("/manobra")
public class ManobraController {

    private InterfaceDAO<Log> ldao = FactoryDAO.createLogDAO();

    @POST
    @Path("/assertIT")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response fulltest(EfikaCustomer cs, String workOrderId) throws Exception {
        Response r;
        try {
            Assertter as = new AssertsManobra(cs, workOrderId);
            cs.getAsserts().addAll(as.assertThese());
            return Response.status(200).entity(cs).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();

        }

    }

}
