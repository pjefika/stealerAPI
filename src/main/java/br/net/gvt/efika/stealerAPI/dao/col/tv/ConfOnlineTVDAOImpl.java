/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.col.tv;

import br.com.gvt.www.tv.configuracaoTV.ConsultarEquipamentosTVIn;
import br.com.gvt.www.tv.configuracaoTV.ConsultarEquipamentosTVOut;
import br.com.gvt.www.tv.diagnosticoHPNA.ConsultaDiagnosticoHPNAIn;
import br.com.gvt.www.tv.diagnosticoHPNA.DiagnosticoHPNAIn;
import br.com.gvt.www.tv.diagnosticoHPNA.DiagnosticoHPNAOut;
import br.com.gvt.www.tv.diagnosticoHPNA.ExecutarDiagnosticoHPNAOut;
import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import br.net.gvt.efika.stealerAPI.dao.exception.ClienteSemTvException;
import br.net.gvt.efika.stealerAPI.dao.exception.FalhaDiagnosticoHPNAException;
import br.net.gvt.efika.stealerAPI.model.adapter.DecoderDecorator;
import com.gvt.services.eai.configuradoronline.ws.ConfiguradorOnlineProxy;
import com.gvt.www.metaData.smarttool.Credenciais;
import java.util.List;

public class ConfOnlineTVDAOImpl implements ConfOnlineTVDAO {

    private final ConfiguradorOnlineProxy col = new ConfiguradorOnlineProxy();
    private final Credenciais cred = new Credenciais("wise", "wise", "wise");
    private List<DecoderTV> basicList;

    @Override
    public List<DecoderTV> getStb(String tvDesignator) throws Exception {
        if (basicList == null) {
            ConsultarEquipamentosTVOut out = col.consultarEquipamentosDeTV(new ConsultarEquipamentosTVIn(tvDesignator));
            if (out.getSetTopBox() == null) {
                throw new ClienteSemTvException();
            }
            basicList = DecoderDecorator.createFromEqpsTvOut(out);
        }
        return basicList;
    }

    @Override
    public List<DecoderTV> getStbDiagnostics(String designator, String tvDesignator) throws Exception {
        int ammount;
        if (basicList == null) {
            this.getStb(tvDesignator);
        }
        ammount = basicList.size() * 150;
        ExecutarDiagnosticoHPNAOut out0 = col.executarDiagnosticoHPNA(new DiagnosticoHPNAIn(designator, false, cred));
        DiagnosticoHPNAOut out = col.consultarDiagnosticoHPNA(new ConsultaDiagnosticoHPNAIn(out0.getIdExecucao(), cred));
        if (out0.getIdExecucao() == 0) {
            throw new FalhaDiagnosticoHPNAException(out0.getMensagem());
        }
        int i = 0;
        int sleep = 30000;
        System.out.println("idexecucao->" + out0.getIdExecucao());
        while (out.getDiagnosticos() == null && i <= ammount) {
            Thread.sleep(sleep);
            out = col.consultarDiagnosticoHPNA(new ConsultaDiagnosticoHPNAIn(out0.getIdExecucao(), cred));
            i = i + (sleep / 1000);
        }
        if (out.getDiagnosticos() == null) {
            throw new FalhaDiagnosticoHPNAException();
        }

        return DecoderDecorator.createFromDiagnostic(out);
    }

}
