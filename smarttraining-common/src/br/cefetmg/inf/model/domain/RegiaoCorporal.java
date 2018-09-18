package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class RegiaoCorporal {
    private int nroSequenciaRegiaoCorporal;
    private String nomeRegiao;
    private ArrayList<Musculo> listaMusculos;

    public RegiaoCorporal() {
    }

    public RegiaoCorporal(int nroSequenciaRegiaoCorporal, String nomeRegiao, ArrayList<Musculo> listaMusculos) {
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
        this.nomeRegiao = nomeRegiao;
        this.listaMusculos=new ArrayList<>(listaMusculos);
    }

    public int getNroSequenciaRegiaoCorporal() {
        return nroSequenciaRegiaoCorporal;
    }

    public void setNroSequenciaRegiaoCorporal(int nroSequenciaRegiaoCorporal) {
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }

    public ArrayList<Musculo> getListaMusculos() {
        return listaMusculos;
    }

    public void setListaMusculos(ArrayList<Musculo> listaMusculos) {
        this.listaMusculos = new ArrayList<>(listaMusculos);
    }
    
    
}
