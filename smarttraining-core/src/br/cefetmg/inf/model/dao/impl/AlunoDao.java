package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao implements IUsuarioDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AlunoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Usuario getUsuario(String codCpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + codCpf + "' AND idt_tipo_usuario = 'A'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            aluno = new Usuario(codCpf,
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return aluno;
    }

    @Override
    public Usuario getUsuarioPeloNome(String nome) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE nom_usuario = '" + nome;

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            aluno = new Usuario(resultado.getString("cod_cpf"),
                    nome,
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return aluno;
    }

    @Override
    public ArrayList<Usuario> getListaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE idt_tipo_usuario='A'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaUsuarios.add(new Usuario(resultado.getString("cod_cpf"),
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate()));
        }

        return listaUsuarios;
    }

    @Override
    public void postUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,CAST(? as date));"
                + "INSERT INTO \"Aluno\" "
                + "VALUES((SELECT cod_cpf FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + aluno.getCodCpf() + "'))";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getCodCpf());
        stmt.setString(2, aluno.getNomUsuario());
        stmt.setString(3, String.valueOf(aluno.getIdtTipoUsuario()));
        stmt.setString(4, aluno.getTxtSenha());
        stmt.setString(5, aluno.getDesEmail());
        stmt.setString(6, String.valueOf(aluno.getDatNascimento()));

        stmt.executeUpdate();

    }

    @Override
    public void putUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=CAST(? as date) "
                + "WHERE cod_cpf=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getNomUsuario());
        stmt.setString(2, String.valueOf(aluno.getIdtTipoUsuario()));
        stmt.setString(3, aluno.getTxtSenha());
        stmt.setString(4, aluno.getDesEmail());
        stmt.setString(5, String.valueOf(aluno.getDatNascimento()));
        stmt.setString(6, aluno.getCodCpf());

        stmt.executeUpdate();

    }

    @Override
    public void deleteUsuario(String codCpf) {
        try {
            sql = "DELETE FROM \"Usuario\" "
                    + "WHERE cod_cpf='" + codCpf + "'";
            
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void fechaConexao(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
