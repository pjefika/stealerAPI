/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.stealerAPI.controller.in.AssiaClearViewIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InterfaceDAO;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;
import com.assia.dslo.napi.model.xsd.ResponseDataBean;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author G0041775
 */
@Path("/assia")
public class AssiaController {

    private InterfaceDAO<Log> ldao;

    @POST
    @Path("/clearViewRealTime")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearViewRealTime(AssiaClearViewIn in) {
        try {

            ResponseDataBean out = FactoryService.createClearViewRealTime().exec(in.getDesignador(), in.getExecutor());
            try {
                Log l = new Log(in);
                l.setOuput(out);
                ldao = FactoryDAO.createLogDAO();
                ldao.cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(out).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }
}
