/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.customer.model.dto.GenericRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryServiceInventory;

/**
 *
 * @author G0041775
 */
@Path("/radiusInventory")
public class RadiusInventoryController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRadiusInventory(CustomerRequest in) {
        try {
            return Response.ok().entity(FactoryServiceInventory.createGatewayInventoryServiceImpl().consultar(in.getParameter())).build();
        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }
    }

}
