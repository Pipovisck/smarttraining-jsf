package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.dao.impl.RegiaoCorporalDao;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import java.sql.SQLException;

public class ManterRegiaoCorporal implements IManterRegiaoCorporal {

    private IRegiaoCorporalDao regiaoCorporalDao;
    
    public ManterRegiaoCorporal() {
    }
    
    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException {
        regiaoCorporalDao = new RegiaoCorporalDao();
        RegiaoCorporal resultado = regiaoCorporalDao.getRegiaoCorporal(codRegiao);
        regiaoCorporalDao.fechaConexao();
        return resultado;
    }
    
    @Override
    public void cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException{
        regiaoCorporalDao = new RegiaoCorporalDao();
        regiaoCorporalDao.postRegiaoCorporal(regiaoCorporal, codMusculo);
        regiaoCorporalDao.fechaConexao();
    }

    @Override
    public void alterar(RegiaoCorporal regiaoCorporal) throws SQLException{
        regiaoCorporalDao = new RegiaoCorporalDao();
        regiaoCorporalDao.putRegiaoCorporal(regiaoCorporal);
        regiaoCorporalDao.fechaConexao();
    }

    @Override
    public void excluir(int codRegiao) throws SQLException{
        regiaoCorporalDao = new RegiaoCorporalDao();
        regiaoCorporalDao.deleteRegiaoCorporal(codRegiao);
        regiaoCorporalDao.fechaConexao();
    }     
}
