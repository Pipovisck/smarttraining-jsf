package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Atividade;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IAtividadeDao {

    public Atividade getAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public void postAtividade(Atividade atividade) throws SQLException;

    public void putAtividade(Atividade atividade) throws SQLException;

    public void deleteAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public void fechaConexao();
}
