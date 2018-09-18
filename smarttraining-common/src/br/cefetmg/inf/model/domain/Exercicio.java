package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Exercicio {
    private int codExercicio;
    private String nomeExercicio;
    private String descricaoExercicio;
    

    public Exercicio() {
        
    }

    public Exercicio(int codExercicio, String nomeExercicio, String descricaoExercicio) {
        this.codExercicio = codExercicio;
        this.nomeExercicio = nomeExercicio;
        this.descricaoExercicio = descricaoExercicio;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }
    
    
}
