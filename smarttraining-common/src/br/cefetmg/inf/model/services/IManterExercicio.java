package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterExercicio {

    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException;

    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException;

    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException;

    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException;

    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException;
    
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException;

    public void cadastrar(Exercicio exercicio, String[] codMusculos) throws SQLException;
    
    public void cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException;

    public void alterar(Exercicio exercicio) throws SQLException;

    public void excluir(int codExercicio) throws SQLException;
}
