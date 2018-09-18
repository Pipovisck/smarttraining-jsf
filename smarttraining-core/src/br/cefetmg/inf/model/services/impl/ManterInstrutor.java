package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.InstrutorDao;
import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.inf.model.services.IManterUsuario;

public class ManterInstrutor implements IManterUsuario {

    private IUsuarioDao instrutorDao;

    public ManterInstrutor() {
    }

    @Override
    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException {
        instrutorDao = new InstrutorDao();
        Instrutor resultado = (Instrutor) instrutorDao.getUsuario(codCpf);
        instrutorDao.fechaConexao();
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        instrutorDao = new InstrutorDao();
        Instrutor resultado = (Instrutor) instrutorDao.getUsuarioPeloNome(nome);
        instrutorDao.fechaConexao();
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        instrutorDao = new InstrutorDao();
        ArrayList<Usuario> listaInstrutores = instrutorDao.getListaUsuarios();
        instrutorDao.fechaConexao();
        return listaInstrutores;
    }

    @Override
    public void cadastrar(Usuario instrutor) throws SQLException {
        instrutorDao = new InstrutorDao();
        instrutorDao.postUsuario((Instrutor) instrutor);
        instrutorDao.fechaConexao();
    }

    @Override
    public void alterar(Usuario instrutor) throws SQLException {
        instrutorDao = new InstrutorDao();
        instrutorDao.putUsuario((Instrutor) instrutor);
        instrutorDao.fechaConexao();
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        instrutorDao = new InstrutorDao();
        instrutorDao.deleteUsuario(codCpf);
        instrutorDao.fechaConexao();
    }
}
