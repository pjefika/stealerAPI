/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.efika_customer.model.customer.InventarioLinha;
import br.net.gvt.efika.stealerAPI.controller.in.ConsultarLinhaIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAO;
import br.net.gvt.efika.stealerAPI.dao.InventarioLinhaDAOPnAdminImpl;
import javax.ws.rs.POST;

/**
 *
 * @author G0041775
 */
@Path("/linha")
public class LinhaController {

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(ConsultarLinhaIn in) {
        try {
            InventarioLinhaDAO linha = new InventarioLinhaDAOPnAdminImpl();
            InventarioLinha out = linha.consultar(in.getInstancia());
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
