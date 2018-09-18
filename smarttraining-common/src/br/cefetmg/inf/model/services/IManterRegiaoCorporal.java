package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IManterRegiaoCorporal {

    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException;

    public void cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException;

    public void alterar(RegiaoCorporal regiaoCorporal) throws SQLException;

    public void excluir(int codRegiao) throws SQLException;
}
