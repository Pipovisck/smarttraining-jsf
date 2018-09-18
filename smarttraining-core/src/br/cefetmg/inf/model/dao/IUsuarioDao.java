package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IUsuarioDao {

    public Usuario getUsuario(String codCpf) throws SQLException;

    public Usuario getUsuarioPeloNome(String nome) throws SQLException;

    public ArrayList<Usuario> getListaUsuarios() throws SQLException;

    public void postUsuario(Usuario aluno) throws SQLException;

    public void putUsuario(Usuario aluno) throws SQLException;

    public void deleteUsuario(String codCpf) throws SQLException;

    public void fechaConexao();
}
