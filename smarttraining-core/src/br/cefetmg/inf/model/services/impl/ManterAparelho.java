package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.impl.AparelhoDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAparelho implements IManterAparelho {

    private IAparelhoDao aparelhoDao;

    public ManterAparelho() {
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nroAparelho);
        aparelhoDao.fechaConexao();
        return resultado;
    }
    
    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException{
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nomAparelho);
        aparelhoDao.fechaConexao();
        return resultado;
    }
    
    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException{
        aparelhoDao = new AparelhoDao();
        ArrayList<Aparelho> resultado = aparelhoDao.getListaAparelhos();
        aparelhoDao.fechaConexao();
        return resultado;
    }

    @Override
    public void cadastrar(Aparelho aparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        aparelhoDao.postAparelho(aparelho);
        aparelhoDao.fechaConexao();
    }

    @Override
    public void alterar(Aparelho aparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        aparelhoDao.putAparelho(aparelho);
        aparelhoDao.fechaConexao();
    }

    @Override
    public void excluir(int nroAparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        aparelhoDao.deleteAparelho(nroAparelho);
        aparelhoDao.fechaConexao();
    }
}
