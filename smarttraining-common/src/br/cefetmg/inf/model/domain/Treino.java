package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Treino {
    private String codCpfAluno;
    private int nroFicha;
    private int nroTreino;
    private String descricaoTreino;
    private ArrayList<Atividade> atividades;

    public Treino() {
    }

    public Treino(String codCpfAluno, int nroFicha, int nroTreino, String descricaoTreino, ArrayList<Atividade> atividades) {
        this.codCpfAluno = codCpfAluno;
        this.nroFicha = nroFicha;
        this.nroTreino = nroTreino;
        this.descricaoTreino = descricaoTreino;
        this.atividades = new ArrayList<>(atividades);
    }

    public String getCodCpfAluno() {
        return codCpfAluno;
    }

    public void setCodCpfAluno(String codCpfAluno) {
        this.codCpfAluno = codCpfAluno;
    }

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    public int getNroTreino() {
        return nroTreino;
    }

    public void setNroTreino(int nroTreino) {
        this.nroTreino = nroTreino;
    }

    public String getDescricaoTreino() {
        return descricaoTreino;
    }

    public void setDescricaoTreino(String descricaoTreino) {
        this.descricaoTreino = descricaoTreino;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = new ArrayList<>(atividades);
    }
    
    
}
