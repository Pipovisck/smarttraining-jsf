package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterFicha {

    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException;

    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException;

    public void cadastrar(Ficha ficha) throws SQLException;

    public void alterar(Ficha ficha) throws SQLException;

    public void excluir(String codCpf, int nroFicha) throws SQLException;
}
