/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Cliente;
import model.InventarioServico;
import model.util.TratativaDesignadores;

/**
 *
 * @author G0041775
 */
public class ClienteDAO implements InterfaceDAO<Cliente> {

    private OSSTurbonetProxy ws = new OSSTurbonetProxy();
    private br.com.gvt.oss.inventory.service.impl.InventoryService service = new br.com.gvt.oss.inventory.service.impl.InventoryService();
    private br.com.gvt.oss.inventory.service.impl.InventoryImpl port = service.getInventoryImplPort();

    public ClienteDAO() {
    }

    public Cliente consultar(String designador) throws Exception {
        Cliente c = new Cliente();
        c.setDesignador(designador);
        ServicosDAO prod = new ServicosDAO(designador, service, port);
        GetInfoOut leCadastro = getInfo(designador);
        c = getAssociatedDesignators(c);
        c.getRede().get(0).setIpDslam(leCadastro.getInfoTBS().getIpDslam());
        c.getRede().get(0).setLogica(new Integer(leCadastro.getInfoTBS().getPortAddrSequence().toString()));
        c.getRede().get(0).setSequencial(new Integer(leCadastro.getInfoTBS().getPortAddrSeq().toString()));
        c.getRede().get(0).setPorta(new Integer(leCadastro.getInfoTBS().getPortNumber().toString()));
        c.getRede().get(0).setRin(new Integer(leCadastro.getInfoTBS().getRin()));
        c.getRede().get(0).setSlot(new Integer(leCadastro.getInfoTBS().getSlot().toString()));
        c.getRede().get(0).setVlanMulticast(leCadastro.getInfoTBS().getVlanMcast());
        c.getRede().get(0).setVlanVod(leCadastro.getInfoTBS().getVlanVoD());
        c.getRede().get(0).setVlanVoip(leCadastro.getInfoTBS().getVlanVoIP());

        List<InventarioServico> l = new ArrayList<>();
        l.set(0, prod.consultar());
        c.setServicos(l);

        return c;
    }

    public String getDesignador(String instancia) throws Exception {
        return ws.getDesignatorByAccessDesignator(instancia);
    }

    public Cliente getAssociatedDesignators(Cliente c) {
        com.gvt.ws.eai.oss.inventory.api.InventoryDesignatorsResponse result = port.getAssociatedDesignators(c.getDesignador(), null);
        return new TratativaDesignadores(result, c).getC();
    }

    public GetInfoOut getInfo(String designador) throws Exception {
        String designator = this.getDesignador(designador);
        String accessDesignator = this.getAccessDesignator(designator);
//        GetInfoOut leInfo = new GetInfoOut();
        return ws.getInfo(designator, accessDesignator, "wise", "wise", designator, "wise", "0", "0");
    }

    public String getAccessDesignator(String designador) throws Exception {
        return ws.getAccessDesignator(designador);
    }

    @Override
    public void cadastrar(Cliente obj) throws Exception {
        EntityManager em = FactoryEntityManager.getInstance();
        em.getTransaction();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
