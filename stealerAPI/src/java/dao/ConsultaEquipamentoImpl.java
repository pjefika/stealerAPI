/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

public class ConsultaEquipamentoImpl extends HttpDAO implements ConsultaEquipamento {

    @Override
    public String consultar(String instancia) throws Exception {
        return post("http://gvtapp/WebPort/QueryNumber.do");
    }

}
