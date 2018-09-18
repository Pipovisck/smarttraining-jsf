package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Avaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IAvaliacaoDao {

    public Avaliacao getAvaliacao(String cpf, LocalDate data) throws SQLException;

    public ArrayList<Avaliacao> getListaAvaliacao(String codCpf) throws SQLException;

    public void postAvaliacao(Avaliacao avaliacao) throws SQLException;

    public void putAvaliacao(Avaliacao avaliacao) throws SQLException;

    public void deleteAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException;

    public void fechaConexao();
}
