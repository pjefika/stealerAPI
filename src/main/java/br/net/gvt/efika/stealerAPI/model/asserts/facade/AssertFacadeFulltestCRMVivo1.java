///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.net.gvt.efika.stealerAPI.model.asserts.facade;
//
//import br.net.gvt.efika.efika_customer.model.customer.CustomerAssert;
//import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
//import br.net.gvt.efika.efika_customer.model.customer.asserts.AssertsEnum;
//import br.net.gvt.efika.stealerAPI.model.asserts.AssertInventarioRede;
//
///**
// *
// * @author G0042204
// */
//public class AssertFacadeFulltestCRMVivo1 extends AbstractAssertFacade {
//
//    private final EfikaCustomer cust;
//
//    public AssertFacadeFulltestCRMVivo1(EfikaCustomer cust) {
//        this.cust = cust;
//    }
//
//    @Override
//    public void afirmar() {
//        try {
//            adicionarAssert(new AssertInventarioRede(cust.getRede()).claim());
//            adicionarAssert(new CustomerAssert(AssertsEnum.DIVERGENCIA_TBS_RADIUS, Boolean.FALSE));
//            adicionarAssert(new CustomerAssert(AssertsEnum.HAS_BLOQUEIO_RADIUS, Boolean.FALSE));
//        } catch (Exception e) {
//        }
//    }
//
//}
