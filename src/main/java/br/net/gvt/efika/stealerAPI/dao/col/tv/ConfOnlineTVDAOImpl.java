/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.col.tv;

import br.com.gvt.www.tv.configuracaoTV.ConsultarEquipamentosTVIn;
import br.com.gvt.www.tv.configuracaoTV.ConsultarEquipamentosTVOut;
import br.com.gvt.www.tv.diagnosticoCPE.DiagnosticoParam;
import br.com.gvt.www.tv.diagnosticoHPNA.ConsultaDiagnosticoHPNAIn;
import br.com.gvt.www.tv.diagnosticoHPNA.DiagnosticoHPNA;
import br.com.gvt.www.tv.diagnosticoHPNA.DiagnosticoHPNAIn;
import br.com.gvt.www.tv.diagnosticoHPNA.DiagnosticoHPNAOut;
import br.com.gvt.www.tv.diagnosticoHPNA.ExecutarDiagnosticoHPNAOut;
import br.net.gvt.efika.stealer.model.entity.DecoderTV;
import br.net.gvt.efika.stealerAPI.dao.exception.ClienteSemTvException;
import br.net.gvt.efika.stealerAPI.model.adapter.DecoderDecorator;
import com.gvt.services.eai.configuradoronline.ws.ConfiguradorOnlineProxy;
import com.gvt.www.metaData.smarttool.Credenciais;
import java.util.ArrayList;
import java.util.List;

public class ConfOnlineTVDAOImpl implements ConfOnlineTVDAO {

    private final ConfiguradorOnlineProxy col = new ConfiguradorOnlineProxy();
    private final Credenciais cred = new Credenciais("wise", "wise", "wise");

    @Override
    public List<DecoderTV> getStb(String tvDesignator) throws Exception {
        ConsultarEquipamentosTVOut out = col.consultarEquipamentosDeTV(new ConsultarEquipamentosTVIn(tvDesignator));
        if (out.getSetTopBox() == null) {
            throw new ClienteSemTvException();
        }
        return DecoderDecorator.createFromEqpsTvOut(out);
    }

    @Override
    public List<DecoderTV> getStbDiagnostics(String designator, String tvDesignator) throws Exception {
        int ammount = this.getStb(tvDesignator).size() * 150;
        ExecutarDiagnosticoHPNAOut out0 = col.executarDiagnosticoHPNA(new DiagnosticoHPNAIn(designator, false, cred));
        DiagnosticoHPNAOut out = col.consultarDiagnosticoHPNA(new ConsultaDiagnosticoHPNAIn(out0.getIdExecucao(), cred));
        int i = 0;
        int sleep = 30000;
        while (out.getDiagnosticos() == null && i <= ammount) {
            Thread.sleep(sleep);
            out = col.consultarDiagnosticoHPNA(new ConsultaDiagnosticoHPNAIn(out0.getIdExecucao(), cred));
            i = i + (sleep / 1000);
        }
        List<DecoderTV> r = new ArrayList<>();
        out.getDiagnosticos();
        for (DiagnosticoHPNA diagnostico : out.getDiagnosticos()) {
            DecoderTV d = new DecoderTV();
            d.setMac(diagnostico.getMacAddressDestino());
            d.setAttenuation(new Double(getParamByName(diagnostico.getParametros(), "HPNA-ATTENUATION").getValor()));
        }
        return r;
    }

    public DiagnosticoParam getParamByName(DiagnosticoParam[] arr, String nome) {
        for (DiagnosticoParam diagnosticoParam : arr) {
            if (diagnosticoParam.getNome().equalsIgnoreCase(nome)) {
                return diagnosticoParam;
            }
        }
        return null;
    }
}
