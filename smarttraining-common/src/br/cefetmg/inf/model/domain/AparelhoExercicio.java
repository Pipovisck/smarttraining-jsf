/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.domain;

/**
 *
 * @author gabriel
 */
public class AparelhoExercicio {
    private Aparelho aparelho;
    private Exercicio exercicio;
    private String caminhoImagem;

    public AparelhoExercicio(Aparelho aparelho, Exercicio exercicio, String caminhoImagem) {
        this.aparelho = aparelho;
        this.exercicio = exercicio;
        this.caminhoImagem = caminhoImagem;
    }
    
    public AparelhoExercicio() {
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
    
    
}
