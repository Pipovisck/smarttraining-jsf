package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IAvaliacaoDao;
import br.cefetmg.inf.model.dao.impl.AvaliacaoDao;
import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterAvaliacao implements IManterAvaliacao {

    private IAvaliacaoDao avaliacaoDao;
    
    public ManterAvaliacao() {
    }
    
    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException{
        avaliacaoDao = new AvaliacaoDao();
        ArrayList<Avaliacao> resultado = new ArrayList<>(avaliacaoDao.getListaAvaliacao(codCpf));
        avaliacaoDao.fechaConexao();
        return resultado;       
    }
    
    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException {
        avaliacaoDao = new AvaliacaoDao();
        Avaliacao resultado = avaliacaoDao.getAvaliacao(codCpf, data);
        avaliacaoDao.fechaConexao();
        return resultado;
    }
    
    @Override
    public void cadastrar(Avaliacao avaliacao) throws SQLException{
        avaliacaoDao = new AvaliacaoDao();
        avaliacaoDao.postAvaliacao(avaliacao);
        avaliacaoDao.fechaConexao();
    }

    @Override
    public void alterar(Avaliacao avaliacao) throws SQLException{
        avaliacaoDao = new AvaliacaoDao();
        avaliacaoDao.putAvaliacao(avaliacao);
        avaliacaoDao.fechaConexao();
    }

    @Override
    public void excluir(String codCpf, LocalDate datAvaliacao) throws SQLException {
        avaliacaoDao = new AvaliacaoDao();
        avaliacaoDao.deleteAvaliacao(codCpf, datAvaliacao);
        avaliacaoDao.fechaConexao();
    }     
}