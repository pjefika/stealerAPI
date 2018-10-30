/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

/**
 *
 * @author G0041775
 */
@Path("/workOrder")
public class WorkOrderController {

    @GET
    @Path("/{ss}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response asserts(@PathParam("ss") String ss) throws Exception {
        try {

            return Response.status(200).entity(FactoryDAO.createWorkOrderDAO().getWorkOrder(ss)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();

        }

    }

}
