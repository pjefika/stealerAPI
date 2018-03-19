/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.customer.model.dto.CustomerRequest;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryNetworkInventoryService;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;
import javax.ws.rs.Consumes;

/**
 *
 * @author G0041775
 */
@Path("/networkInventory")
public class NetworkInventoryController {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(CustomerRequest body) {
        try {
            return Response.ok(FactoryNetworkInventoryService.create(body.getCustomer().getRede().getPlanta()).consultar(body.getCustomer())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
    @POST
    @Path("/tbs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteTBS(CustomerRequest body) {
        try {
            return Response.ok(FactoryService.createTbsNetworkInventoryServiceImpl().consultar(body.getCustomer())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
    @POST
    @Path("/sigres")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteSigres(CustomerRequest body) {
        try {
            
            return Response.ok(FactoryService.createSigresNetworkInventoryServiceImpl().consultar(body.getCustomer())).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
    
}
