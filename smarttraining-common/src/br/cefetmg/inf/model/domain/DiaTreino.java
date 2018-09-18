package br.cefetmg.inf.model.domain;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Jamalz
 */
public class DiaTreino {
    private Atividade atividade;
    private LocalDate datTreino;

    public DiaTreino(Atividade atividade, LocalDate datTreino) {
        this.atividade = atividade;
        this.datTreino = datTreino;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public LocalDate getDatTreino() {
        return datTreino;
    }

    public void setDatTreino(LocalDate datTreino) {
        this.datTreino = datTreino;
    }
     
}
