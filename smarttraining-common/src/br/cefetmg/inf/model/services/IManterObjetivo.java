package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Objetivo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IManterObjetivo {

    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException;

    public Objetivo pesquisarPorNome(String nome) throws SQLException;

    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException;
    
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException;

    public void cadastrar(Objetivo objetivo) throws SQLException;

    public void alterar(Objetivo objetivo) throws SQLException;

    public void excluir(int codRegiao) throws SQLException;
}
