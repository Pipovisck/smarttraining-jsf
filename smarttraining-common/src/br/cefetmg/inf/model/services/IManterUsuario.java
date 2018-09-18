package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterUsuario {

    public Usuario pesquisarPorCpf(String codCpf) throws SQLException;

    public Usuario pesquisarPorNome(String nome) throws SQLException;
    
    public ArrayList <Usuario> pesquisarTodos() throws SQLException;
    
    public void cadastrar(Usuario aluno) throws SQLException;

    public void alterar(Usuario aluno) throws SQLException;

    public void excluir(String codCpf) throws SQLException;
}
