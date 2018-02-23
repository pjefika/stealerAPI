/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

import br.net.gvt.efika.stealerAPI.dao.exception.InstanciaInvalidaException;
import org.jsoup.select.Elements;

public class SigresTerminalNaoEncontradoTratativa extends GenericTratativaImpl<Elements, Elements> {

    @Override
    public Elements parse(Elements elem) throws Exception {
        if (elem.text().contains("Terminal não encontrado")) {
            throw new InstanciaInvalidaException();
        }
        return elem;

//        result = new InventarioRede();
//        result.setTipo(TipoRede.GPON);
//        result.setOrigem(OrigemRede.ONLINE);
//        result.setPlanta(OrigemPlanta.VIVO1);
//        result.setNrc(EfikaRegex.capture(str, "(?:NRC.)(\\w{5,10})", 1));
//        result.setIpDslam(EfikaRegex.capture(str, "(?:Dslam.)(\\w{10,20})", 1));
//        result.setTerminal(EfikaRegex.capture(str, "(?:Terminal.)\\s{0,3}(\\d{8,20})", 1));
//        result.setSlot(new Integer(EfikaRegex.capture(str, "(?:Cartão.{0,5}Cartão\\s{0,3})(\\d{0,2})", 1)));
//        result.setPorta(new Integer(EfikaRegex.capture(str, "(?:Porta.{0,5}Porta\\s{0,3})(\\d{0,2})", 1)));
//        result.setRin(new Integer(EfikaRegex.capture(str, "(?:VLan de Rede\\s{0,3})(\\d{0,4})", 1)));
//        result.setCvlan(new Integer(EfikaRegex.capture(str, "(?:VLan do Usuário\\s{0,3})(\\d{0,3})", 1)));
//        result.setBhs(EfikaRegex.capture(str, "(?:BHS/HGU Instalado\\s{0,3})(\\w{0,3})", 1).equalsIgnoreCase("SIM"));
//        result.setLogica(new Integer(EfikaRegex.capture(str, "(?:Id do Cliente\\s{0,3})(\\w{0,3})", 1)));
//        result.setSequencial(result.getLogica());
//        return result;
    }

}
