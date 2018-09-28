/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.dao.col.tv;

import br.net.gvt.efika.stealer.model.tv.DecoderTV;
import br.net.gvt.efika.stealerAPI.model.TesteHpna;

import java.util.List;

/**
 *
 * @author G0041775
 */
public interface ConfOnlineTVDAO {

    public List<DecoderTV> getStb(String tvDesignator) throws Exception;

    public TesteHpna getStbDiagnostics(String designator, String tvDesignator) throws Exception;

}
