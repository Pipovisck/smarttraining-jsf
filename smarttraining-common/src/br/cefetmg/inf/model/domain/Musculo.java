package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Musculo {
    private int codMusculo;
    private int codRegiaoCorporal;
    private String nomMusculo;
    private String caminhoImagem; 
    private ArrayList<Exercicio> listaExercicios;

    public Musculo() {
    }

    
    public Musculo(int nroSequenciaMusculo, int nroSequenciaRegiaoCorporal, String nomeMusculo, String caminhoImagem, ArrayList<Exercicio> listaExercicios) {
        this.codMusculo = nroSequenciaMusculo;
        this.codRegiaoCorporal = nroSequenciaRegiaoCorporal;
        this.nomMusculo = nomeMusculo;
        this.caminhoImagem = caminhoImagem;
        this.listaExercicios = new ArrayList<>(listaExercicios);
    }
    
    public int getCodMusculo() {
        return codMusculo;
    }

    public void setCodMusculo(int codMusculo) {
        this.codMusculo = codMusculo;
    }

    public int getCodRegiaoCorporal() {
        return codRegiaoCorporal;
    }

    public void setCodRegiaoCorporal(int codRegiaoCorporal) {
        this.codRegiaoCorporal = codRegiaoCorporal;
    }

    public String getNomMusculo() {
        return nomMusculo;
    }

    public void setNomMusculo(String nomMusculo) {
        this.nomMusculo = nomMusculo;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public ArrayList<Exercicio> getListaExercicios() {
        return listaExercicios;
    }

    public void setListaExercicios(ArrayList<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }
}
