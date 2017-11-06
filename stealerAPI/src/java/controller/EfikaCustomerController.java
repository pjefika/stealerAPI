/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import com.gvt.www.ws.eai.oss.gpon.ConsultInfoGponOut;
import controller.in.GetAuthIn;
import controller.in.GetClienteIn;
import controller.in.GetInfoGponIn;
import dao.FactoryDAO;
import dao.InterfaceDAO;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.entity.Log;
import util.GsonUtil;
import javax.ws.rs.POST;
import model.service.EfikaCustomerService;
import model.service.EfikaCustomerServiceImpl;

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
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();

            EfikaCustomer out = instance.consultar(in.getInstancia());
            String persistOut = GsonUtil.serialize(out);
            try {
                Log l = new Log(in);
                l.setOuput(persistOut);
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
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();
            OSSTurbonetStatusConexaoOut autenticacaoByMacOrIp = instance.getAutenticacaoByMacOrIp(in.getMacOrIp());
            String persistOut = GsonUtil.serialize(autenticacaoByMacOrIp);
            try {
                Log l = new Log(in);
                l.setOuput(persistOut);
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
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();
            ConsultInfoGponOut infoGpon = instance.getInfoGpon(in.getInstancia());
            String persistOut = GsonUtil.serialize(infoGpon);
            try {
                Log l = new Log(in);
                l.setOuput(persistOut);
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
