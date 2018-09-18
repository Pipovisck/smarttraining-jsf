package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IFichaDao {

    public Ficha getFicha(String cpf, int numeroFicha) throws SQLException;

    public ArrayList<Ficha> getListaFicha(String cpf) throws SQLException;

    public void postFicha(Ficha ficha) throws SQLException;

    public void putFicha(Ficha ficha) throws SQLException;

    public void deleteFicha(String cpf, int nroFicha) throws SQLException;

    public void fechaConexao();
}
