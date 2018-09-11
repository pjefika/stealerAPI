/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import br.net.gvt.efika.stealer.model.tv.request.DiagnosticoHpnaIn;
import br.net.gvt.efika.stealer.model.tv.request.GetStbsIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InterfaceDAO;
import br.net.gvt.efika.stealerAPI.dao.col.tv.ConfOnlineTVDAOImpl;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author G0041775
 */
@Path("/confOnline")
public class ConfOnlineController {
    
    private InterfaceDAO<Log> ldao;
    
    @POST
    @Path("/listStbs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listStbs(GetStbsIn in) {
        try {
            
            List<DecoderTV> out = FactoryService.colTVService().listStbs(in.getEc());
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
    
    @POST
    @Path("/diagnosticoHpna")
    @Produces(MediaType.APPLICATION_JSON)
    public Response diagnosticoHpna(DiagnosticoHpnaIn in) {
        try {
            //ConfOnlineTVDAOImpl instance = new ConfOnlineTVDAOImpl();
            //List<DecoderTV> out = instance.getStbDiagnostics(in.getEc().getDesignador(), in.getEc().getDesignadorTv());
            List<DecoderTV> out = FactoryService.colTVService().diagnosticoHpna(in.getEc());
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
