///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.net.gvt.efika.stealerAPI.model.asserts.facade;
//
//import bean.ossturbonet.oss.gvt.com.GetInfoOut;
//import br.net.gvt.efika.stealerAPI.model.asserts.AssertBloqueioRadius;
//import br.net.gvt.efika.stealerAPI.model.asserts.AssertCiruitoAtivo;
//import br.net.gvt.efika.stealerAPI.model.asserts.AssertTbsRadiusDivergencia;
//
///**
// *
// * @author G0042204
// */
//public class AssertFacadeFulltestCRMVivo2 extends AbstractAssertFacade {
//
//    private final GetInfoOut info;
//
//    public AssertFacadeFulltestCRMVivo2(GetInfoOut info) {
//        this.info = info;
//    }
//
//    @Override
//    public void afirmar() {
//        try {
//            adicionarAssert(new AssertTbsRadiusDivergencia(getOss().verificarInconsistenciaTBSRadius(info)).claim());
//            adicionarAssert(new AssertCiruitoAtivo(info).claim());
//            adicionarAssert(new AssertBloqueioRadius(info.getInfoRadius()).claim());
//        } catch (Exception e) {
//        }
//    }
//
//}
