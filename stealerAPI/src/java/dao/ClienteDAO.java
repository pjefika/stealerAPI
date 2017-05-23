/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
import dao.util.TratativaDesignadores;
import model.Cliente;

/**
 *
 * @author G0041775
 */
public class ClienteDAO {

    private OSSTurbonetProxy ws = new OSSTurbonetProxy();
    private br.com.gvt.oss.inventory.service.impl.InventoryService service = new br.com.gvt.oss.inventory.service.impl.InventoryService();
    private br.com.gvt.oss.inventory.service.impl.InventoryImpl port = service.getInventoryImplPort();

    public ClienteDAO() {
    }

    public Cliente getCliente(String designador) throws Exception {
        Cliente c = new Cliente();
        ProdutosDAO prod = new ProdutosDAO(designador);
        c.setDesignador(getDesignador(designador));
        GetInfoOut leCadastro = getInfo(designador);
        c.setIpDslam(leCadastro.getInfoTBS().getIpDSLAM());
        c.setLogica(new Integer(leCadastro.getInfoTBS().getPortAddrSequence().toString()));
        c.setSequencial(new Integer(leCadastro.getInfoTBS().getPortAddrSeq().toString()));
        c.setPorta(new Integer(leCadastro.getInfoTBS().getPortNumber().toString()));
        c.setRin(new Integer(leCadastro.getInfoTBS().getRin()));
        c.setSlot(new Integer(leCadastro.getInfoTBS().getSlot().toString()));
        c.setVlanMulticast(leCadastro.getInfoTBS().getVlanMcast());
        c.setVlanVod(leCadastro.getInfoTBS().getVlanVoD());
        c.setVlanVoip(leCadastro.getInfoTBS().getVlanVoIP());
        
        c = getAssociatedDesignators(c);
        c = prod.getProdCliente(c);
        
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

}
