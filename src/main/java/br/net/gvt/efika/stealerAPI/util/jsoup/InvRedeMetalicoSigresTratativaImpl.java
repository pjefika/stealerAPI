/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.stealerAPI.util.jsoup;

import br.net.gvt.efika.efika_customer.model.customer.InventarioRede;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemPlanta;
import br.net.gvt.efika.efika_customer.model.customer.enums.OrigemRede;
import br.net.gvt.efika.efika_customer.model.customer.enums.TipoRede;
import br.net.gvt.efika.util.regex.EfikaRegex;
import org.jsoup.select.Elements;

public class InvRedeMetalicoSigresTratativaImpl extends GenericTratativaImpl<InventarioRede, Elements> {

    private InventarioRede inv = new InventarioRede();

    @Override
    public InventarioRede parse(Elements elem) throws Exception {
        String str = elem.text();
        inv.setTipo(TipoRede.METALICA);
        inv.setOrigem(OrigemRede.ONLINE);
        inv.setPlanta(OrigemPlanta.VIVO1);
        inv.setNrc(EfikaRegex.capture(str, "(?:NRC.)(\\w{5,10})", 1));
        inv.setIpDslam(EfikaRegex.capture(str, "(?:Dslam.)(\\w{10,20})", 1));
        inv.setTerminal(EfikaRegex.capture(str, "(?:Terminal.)\\s{0,3}(\\d{8,20})", 1));
        inv.setSlot(new Integer(EfikaRegex.capture(str, "(?:-.{0,5}Cartão\\s{0,3})(\\d{0,2})", 1)));
        inv.setPorta(new Integer(EfikaRegex.capture(str, "(?:MaxBandWidth.{0,5}Porta\\s{0,3})(\\d{0,2})", 1)));
        inv.setRin(new Integer(EfikaRegex.capture(str, "(?:VLan de Rede\\s{0,3})(\\d{0,4})", 1)));
        inv.setCvlan(new Integer(EfikaRegex.capture(str, "(?:VLan do Usuário\\s{0,3})(\\d{0,3})", 1)));
        inv.setBhs(false);
        inv.setSequencial(new Integer(
                EfikaRegex.capture(str, "(?:Porta SND.{0,500}Porta\\s{0,3})(\\d{0,4}).{0,60}(?:Permuta)", 1)
        ));
        return inv;
    }

}
