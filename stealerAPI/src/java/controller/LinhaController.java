/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.net.gvt.efika.customer.InventarioLinha;
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
import dao.InventarioLinhaDAO;
import dao.InventarioLinhaDAOPnAdminImpl;

/**
 *
 * @author G0041775
 */
@Path("/linha")
public class LinhaController{

    private InterfaceDAO<Log> ldao;

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(@PathParam("instancia") String instancia) {
        try {
            InventarioLinhaDAO linha = new InventarioLinhaDAOPnAdminImpl();
            InventarioLinha out = linha.consultar(instancia);
            String persistOut = GsonUtil.serialize(out);
            try {
                Log l = new Log("LinhaController.consultar");
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

}
