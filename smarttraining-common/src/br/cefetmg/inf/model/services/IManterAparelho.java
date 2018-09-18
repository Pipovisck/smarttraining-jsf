package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Aparelho;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterAparelho {

    public Aparelho pesquisar(int nroAparelho) throws SQLException;
    
    public Aparelho pesquisar(String nomAparelho) throws SQLException;
    
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException;
    
    public void cadastrar(Aparelho aparelho) throws SQLException;

    public void alterar(Aparelho aparelho) throws SQLException;

    public void excluir(int nroAparelho) throws SQLException;
}
