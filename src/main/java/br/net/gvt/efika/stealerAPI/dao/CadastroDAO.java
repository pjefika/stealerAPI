///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.net.gvt.efika.stealerAPI.dao;
//
//import bean.ossturbonet.oss.gvt.com.GetInfoOut;
//import bean.ossturbonet.oss.gvt.com.InfoAuthentication;
//import com.gvt.www.ws.eai.oss.OSSTurbonetClienteAutenticado.OSSTurbonetClienteAutenticadoIn;
//import com.gvt.www.ws.eai.oss.OSSTurbonetClienteAutenticado.OSSTurbonetClienteAutenticadoOut;
//import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusIn;
//import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;
//import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoIn;
//import com.gvt.www.ws.eai.oss.OSSTurbonetStatusConexao.OSSTurbonetStatusConexaoOut;
//import com.gvt.www.ws.eai.oss.ossturbonet.OSSTurbonetProxy;
//import java.rmi.RemoteException;
//
///**
// *
// * @author G0041775
// */
//public class CadastroDAO implements OssTurbonetDAOInterface {
//
//    private final OSSTurbonetProxy ws;
//
//    public CadastroDAO() {
//        ws = new OSSTurbonetProxy();
//    }
//
//    @Override
//    public OSSTurbonetInconsistenciaTBSRadiusOut verificarInconsistenciaTBSRadius(GetInfoOut info) throws RemoteException {
//        return ws.verificarInconsistenciaTBSRadius(new OSSTurbonetInconsistenciaTBSRadiusIn(new OSSTurbonetInAdapter(info)));
//    }
//
////    public String getDesignador(String instancia) throws RemoteException {
////        return ws.getDesignatorByAccessDesignator(instancia);
////    }
//
//    @Override
//    public OSSTurbonetClienteAutenticadoOut isClienteAutenticado(GetInfoOut info) throws RemoteException {
//        return ws.isClienteAutenticado(new OSSTurbonetClienteAutenticadoIn(new OSSTurbonetInAdapter(info)));
//    }
//
//    /**
//     * Consulta de Autenticação via Cache (Radius Relay);
//     *
//     * @param info
//     * @return
//     * @throws RemoteException
//     */
//    public OSSTurbonetStatusConexaoOut getAuthRadiusRelay(GetInfoOut info) throws RemoteException {
//        return ws.getStatusConexao(new OSSTurbonetStatusConexaoIn(new OSSTurbonetInAdapter(info)));
//    }
//
//    public GetInfoOut getInfo(String designador) throws RemoteException {
//        String designator = this.getDesignador(designador);
//        String accessDesignator = this.getAccessDesignator(designator);
////        GetInfoOut leInfo = new GetInfoOut();
//        return ws.getInfo(designator, accessDesignator, "wise", "wise", designator, "wise", "0", "0");
//    }
//
////    public String getAccessDesignator(String designador) throws RemoteException {
////        return ws.getAccessDesignator(designador);
////    }
//
//    public InfoAuthentication getAutentication(GetInfoOut i) throws RemoteException {
//        return ws.getInfoAuthentication(i.getDesignator(), i.getDesignator(), "wise", "wise", "wise");
//    }
//
//    public OSSTurbonetStatusConexaoOut getAuthenticationByIPorMac(String ipOrmac) throws RemoteException {
//        return ws.getAuthenticationByIPorMac(ipOrmac);
//    }
//
//}
