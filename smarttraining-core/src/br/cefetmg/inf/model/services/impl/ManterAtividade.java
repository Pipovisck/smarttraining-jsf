package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.dao.impl.AtividadeDao;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import java.sql.SQLException;

public class ManterAtividade implements IManterAtividade {

    private IAtividadeDao atividadeDao;

    public ManterAtividade() {
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        atividadeDao = new AtividadeDao();
        Atividade resultado = atividadeDao.getAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        atividadeDao.fechaConexao();
        return resultado;
    }

    @Override
    public void cadastrar(Atividade atividade) throws SQLException {
        atividadeDao = new AtividadeDao();
        atividadeDao.postAtividade(atividade);
        atividadeDao.fechaConexao();
    }

    @Override
    public void alterar(Atividade atividade) throws SQLException {
        atividadeDao = new AtividadeDao();
        atividadeDao.putAtividade(atividade);
        atividadeDao.fechaConexao();
    }

    @Override
    public void excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        atividadeDao = new AtividadeDao();
        atividadeDao.deleteAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        atividadeDao.fechaConexao();
    }
}
