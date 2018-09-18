package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Musculo;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterMusculo {

    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException;

    public ArrayList <Musculo> pesquisarTodos() throws SQLException;
    
    public void cadastrar(Musculo musculo) throws SQLException;

    public void alterar(Musculo musculo) throws SQLException;

    public void excluir(int codMusculo) throws SQLException;
}
