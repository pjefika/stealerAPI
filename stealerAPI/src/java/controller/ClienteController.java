/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EfikaCustomerInterface;
import dao.FactoryDAO;
import dao.InterfaceDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.domain.EfikaCustomerDTO;
import model.entity.Log;
import util.GsonUtil;

/**
 *
 * @author G0041775
 */
@Path("/oss")
public class ClienteController implements EfikaCustomerRestInter {

    private EfikaCustomerInterface dao;

    private InterfaceDAO<Log> ldao = FactoryDAO.createLogDAO();

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getCliente(@PathParam("instancia") String instancia) {
        try {
            dao = FactoryDAO.createClienteDAO();
            EfikaCustomerDTO out = dao.consultarCliente(instancia);
            String persistOut = GsonUtil.serialize(out);
            try {
                Log l = new Log("ClienteController.getCliente");
                l.setInput(instancia);
                l.setOuput(persistOut);
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
