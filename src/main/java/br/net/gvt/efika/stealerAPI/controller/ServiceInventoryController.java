/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.stealerAPI.controller.in.GetClienteIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import javax.ws.rs.POST;
import br.net.gvt.efika.stealerAPI.model.service.FactoryService;

/**
 *
 * @author G0041775
 */
@Path("/serviceInventory")
public class ServiceInventoryController {

    @POST
    @Path("/sophia")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteSophia(GetClienteIn in) {
        try {

            EfikaCustomer out = FactoryService.create().consultar(in.getInstancia());
            try {
                Log l = new Log(in);
                l.setOuput(out);
                FactoryDAO.createLogDAO().cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(out).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Path("/legado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteLegadoV1(GetClienteIn in) {
        try {

            EfikaCustomer out = FactoryService.create().consultar(in.getInstancia());
            try {
                Log l = new Log(in);
                l.setOuput(out);
                FactoryDAO.createLogDAO().cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(out).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
