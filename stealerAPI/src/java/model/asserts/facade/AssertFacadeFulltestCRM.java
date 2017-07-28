/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.asserts.facade;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import model.asserts.AssertBloqueioRadius;
import model.asserts.AssertCiruitoAtivo;
import model.asserts.AssertTbsRadiusDivergencia;

/**
 *
 * @author G0042204
 */
public class AssertFacadeFulltestCRM extends AbstractAssertFacade {

    private final GetInfoOut info;

    public AssertFacadeFulltestCRM(GetInfoOut info) {
        this.info = info;
    }

    @Override
    public void afirmar() {
        try {
            adicionarAssert(new AssertTbsRadiusDivergencia(getOss().verificarInconsistenciaTBSRadius(info)).claim());
            adicionarAssert(new AssertCiruitoAtivo(info).claim());
            adicionarAssert(new AssertBloqueioRadius(info.getInfoRadius()).claim());
        } catch (Exception e) {
        }
    }

}
