/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.controller;

import br.net.gvt.efika.customer.model.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import br.net.gvt.efika.stealerAPI.controller.in.GetAuthIn;
import br.net.gvt.efika.stealerAPI.controller.in.GetClienteIn;
import br.net.gvt.efika.stealerAPI.controller.in.GetInfoGponIn;
import br.net.gvt.efika.stealerAPI.dao.FactoryDAO;
import br.net.gvt.efika.stealerAPI.dao.InterfaceDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.stealerAPI.model.entity.Log;
import javax.ws.rs.POST;
import br.net.gvt.efika.stealerAPI.model.service.factory.FactoryService;

/**
 *
 * @author G0041775
 */
@Path("/oss")
public class EfikaCustomerController implements EfikaCustomerRestInter {

    private InterfaceDAO<Log> ldao;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getCliente(GetClienteIn in) {
        try {

            EfikaCustomer out = FactoryService.create().consultar(in.getInstancia());
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
    @Path("/auth/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuth(GetAuthIn in) {
        try {
            OSSTurbonetStatusConexaoOut autenticacaoByMacOrIp = FactoryService.create().getAutenticacaoByMacOrIp(in.getMacOrIp());
            try {
                Log l = new Log(in);
                l.setOuput(autenticacaoByMacOrIp);
                ldao = FactoryDAO.createLogDAO();
                ldao.cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(autenticacaoByMacOrIp).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

    @POST
    @Path("/infoGpon/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoGpon(GetInfoGponIn in) {
        try {
            ConsultInfoGponOut infoGpon = FactoryService.create().getInfoGpon(in.getInstancia());
            try {
                Log l = new Log(in);
                l.setOuput(infoGpon);
                ldao = FactoryDAO.createLogDAO();
                ldao.cadastrar(l);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Response.status(200).entity(infoGpon).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
