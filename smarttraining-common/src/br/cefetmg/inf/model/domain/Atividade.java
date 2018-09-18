package br.cefetmg.inf.model.domain;

/**
 *
 * @author Felipe
 */

public class Atividade {
    private AparelhoExercicio aparelhoExercicio;
    private String codCpf;
    private int nroFicha;
    private int nroTreino;
    private int qtdPeso;
    private int nroSeries;
    private int nroRepeticoes;

    public Atividade() {
    }

    public Atividade(AparelhoExercicio aparelhoExercicio, String cpf, int nroFicha, int nroTreino, int peso, int series, int repeticoes) {
        this.aparelhoExercicio = aparelhoExercicio;
        this.codCpf = cpf;
        this.nroFicha = nroFicha;
        this.nroTreino = nroTreino;
        this.qtdPeso = peso;
        this.nroSeries = series;
        this.nroRepeticoes = repeticoes;
    }

    public AparelhoExercicio getAparelhoExercicio() {
        return aparelhoExercicio;
    }

    public void setAparelhoExercicio(AparelhoExercicio aparelhoExercicio) {
        this.aparelhoExercicio = aparelhoExercicio;
    }

    public String getCodCpf() {
        return codCpf;
    }

    public void setCodCpf(String codCpf) {
        this.codCpf = codCpf;
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

    public int getQtdPeso() {
        return qtdPeso;
    }

    public void setQtdPeso(int qtdPeso) {
        this.qtdPeso = qtdPeso;
    }

    public int getNroSeries() {
        return nroSeries;
    }

    public void setNroSeries(int nroSeries) {
        this.nroSeries = nroSeries;
    }

    public int getNroRepeticoes() {
        return nroRepeticoes;
    }

    public void setNroRepeticoes(int nroRepeticoes) {
        this.nroRepeticoes = nroRepeticoes;
    }
}