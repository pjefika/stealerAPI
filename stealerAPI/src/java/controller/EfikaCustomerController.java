/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.net.gvt.efika.customer.EfikaCustomer;
import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
import dao.FactoryDAO;
import dao.InterfaceDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.entity.Log;
import util.GsonUtil;
import dao.ConsultaEfikaCustomer;
import model.service.EfikaCustomerService;
import model.service.EfikaCustomerServiceImpl;

/**
 *
 * @author G0041775
 */
@Path("/oss")
public class EfikaCustomerController implements EfikaCustomerRestInter {

    private ConsultaEfikaCustomer dao;

    private InterfaceDAO<Log> ldao;

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getCliente(@PathParam("instancia") String instancia) {
        try {
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();

            EfikaCustomer out = instance.consultar(instancia);
            String persistOut = GsonUtil.serialize(out);
            try {
                Log l = new Log("ClienteController.getCliente");
                l.setInput(instancia);
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

    @GET
    @Path("/auth/{mac}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuth(@PathParam("mac") String mac) {
        try {
            EfikaCustomerService instance = new EfikaCustomerServiceImpl();
            OSSTurbonetStatusConexaoOut autenticacaoByMacOrIp = instance.getAutenticacaoByMacOrIp(mac);
            String persistOut = GsonUtil.serialize(autenticacaoByMacOrIp);
            try {
                Log l = new Log("ClienteController.getCliente");
                l.setInput(mac);
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

}
