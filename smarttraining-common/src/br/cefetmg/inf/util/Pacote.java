/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Pacote {

    TipoOperacao tipoOperacao;
    ArrayList<String> dados;

    public Pacote(TipoOperacao tipoOperacao, ArrayList<String> dados) {
        this.tipoOperacao = tipoOperacao;
        this.dados = dados;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public ArrayList<String> getDados() {
        return dados;
    }

    public void setDados(ArrayList<String> dados) {
        this.dados = dados;
    }
    
}
