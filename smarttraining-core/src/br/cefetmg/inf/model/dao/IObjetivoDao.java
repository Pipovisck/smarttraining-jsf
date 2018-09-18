package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Objetivo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IObjetivoDao {

    public ArrayList<Objetivo> getAvaliacaoObjetivos(String codCpf, LocalDate nroAvaliacao) throws SQLException;

    public Objetivo getObjetivo(int codObjetivo) throws SQLException;

    public Objetivo getObjetivo(String nome) throws SQLException;

    public ArrayList<Objetivo> getListaObjetivos() throws SQLException;

    public void postObjetivo(Objetivo objetivo) throws SQLException;

    public void putObjetivo(Objetivo objetivo) throws SQLException;

    public void deleteObjetivo(int codObjetivo) throws SQLException;

    public void fechaConexao();
}
