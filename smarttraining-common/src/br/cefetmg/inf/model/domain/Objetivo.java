package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Objetivo {
    private int codObjetivo;
    private String nomObjetivo;
    private String desObjetivo;

    public Objetivo() {
    }

    public Objetivo(int nroSequenciaObjetivo, String nome, String descricao) {
        this.codObjetivo = nroSequenciaObjetivo;
        this.nomObjetivo = nome;
        this.desObjetivo = descricao;
    }

    public int getCodObjetivo() {
        return codObjetivo;
    }

    public void setCodObjetivo(int codObjetivo) {
        this.codObjetivo = codObjetivo;
    }

    public String getNomObjetivo() {
        return nomObjetivo;
    }

    public void setNomObjetivo(String nomObjetivo) {
        this.nomObjetivo = nomObjetivo;
    }

    public String getDesObjetivo() {
        return desObjetivo;
    }

    public void setDesObjetivo(String desObjetivo) {
        this.desObjetivo = desObjetivo;
    }
}
