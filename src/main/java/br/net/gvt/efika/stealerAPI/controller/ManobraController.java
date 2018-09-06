/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
import br.net.gvt.efika.stealerAPI.controller.in.ManobraITAssertIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InterfaceDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.stealerAPI.model.asserts.Assertter;
import br.net.gvt.efika.stealerAPI.model.asserts.facade.AssertsManobra;
import br.net.gvt.efika.stealerAPI.model.entity.Log;

/**
 *
 * @author G0041775
 */
@Path("/manobra")
public class ManobraController {

    private InterfaceDAO<Log> ldao = FactoryDAO.createLogDAO();

    @POST
    @Path("/asserts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response asserts(ManobraITAssertIn in) throws Exception {
        try {
            Assertter as = new AssertsManobra(in.getCust(), in.getWorkOrderId());
            List<CustomerAssert> assertThese = as.assertThese();
            try {
                Log l = new Log(in);
                l.setOuput(assertThese);
                ldao = FactoryDAO.createLogDAO();
                ldao.cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(assertThese).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();

        }

    }

}
