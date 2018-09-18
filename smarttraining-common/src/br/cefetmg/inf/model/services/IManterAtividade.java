package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Atividade;
import java.sql.SQLException;

public interface IManterAtividade {

    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public void cadastrar(Atividade atividade) throws SQLException;

    public void alterar(Atividade atividade) throws SQLException;

    public void excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;
}
