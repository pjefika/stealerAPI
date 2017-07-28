/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.in.ManobraITAssertIn;
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
    public Response fulltest(ManobraITAssertIn in) throws Exception {
        try {
            System.out.println("in:" + in.getWorkOrderId());
            Assertter as = new AssertsManobra(in.getCust(), in.getWorkOrderId());
            return Response.status(200).entity(as.assertThese()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();

        }

    }

}
