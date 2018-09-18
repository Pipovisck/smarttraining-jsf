package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.dao.impl.MusculoDao;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterMusculo implements IManterMusculo {

    private IMusculoDao musculoDao;
    
    public ManterMusculo() {
    }
    
    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException{
        musculoDao = new MusculoDao();
        Musculo resultado = musculoDao.getMusculo(codMusculo);
        musculoDao.fechaConexao();
        return resultado;
    }
       
    @Override
    public ArrayList <Musculo> pesquisarTodos() throws SQLException {
        musculoDao = new MusculoDao();
        ArrayList <Musculo> listaMusculos = musculoDao.getListaMusculos();
        musculoDao.fechaConexao();
        return listaMusculos;
    }
    
    @Override
    public void cadastrar(Musculo musculo) throws SQLException{
        musculoDao = new MusculoDao();
        musculoDao.postMusculo(musculo);
        musculoDao.fechaConexao();
    }

    @Override
    public void alterar(Musculo musculo) throws SQLException{
        musculoDao = new MusculoDao();
        musculoDao.putMusculo(musculo);
        musculoDao.fechaConexao();
    }

    @Override
    public void excluir(int codMusculo) throws SQLException{
        musculoDao = new MusculoDao();
        musculoDao.deleteMusculo(codMusculo);
        musculoDao.fechaConexao();
    }     


}
