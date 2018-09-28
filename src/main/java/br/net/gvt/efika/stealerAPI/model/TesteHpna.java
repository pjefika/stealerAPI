package br.net.gvt.efika.stealerAPI.model;

import br.net.gvt.efika.stealer.model.tv.DecoderTV;

import java.util.List;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class TesteHpna {

    private String situacao;
    private String mensagem;
    private List<DecoderTV> stbs;

    public TesteHpna() {
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<DecoderTV> getStbs() {
        return stbs;
    }

    public void setStbs(List<DecoderTV> stbs) {
        this.stbs = stbs;
    }
}
