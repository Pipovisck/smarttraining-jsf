package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstrutorDao implements IUsuarioDao {

    private Instrutor instrutor;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public InstrutorDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Usuario getUsuario(String cpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\""
                + "JOIN \"Instrutor\""
                + "USING(cod_cpf) "
                + "GROUP BY cod_cpf, nro_cref "
                + "HAVING cod_cpf='" + cpf + "' AND idt_tipo_usuario = 'I'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            instrutor = new Instrutor(resultado.getString("nro_cref"),
                    cpf,
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return instrutor;
    }
    
    @Override
    public Usuario getUsuarioPeloNome(String nome) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\""
                + "JOIN \"Instrutor\""
                + "USING(cod_cpf) "
                + "GROUP BY cod_cpf, nro_cref "
                + "HAVING nom_usuario='" + nome + "' AND idt_tipo_usuario = 'I'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            instrutor = new Instrutor(resultado.getString("nro_cref"),
                    nome,
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return instrutor;
    }
    
    @Override
    public ArrayList<Usuario> getListaUsuarios() throws SQLException {
        ArrayList <Usuario> listaUsuarios = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "JOIN \"Instrutor\" USING(cod_cpf) "
                + "WHERE idt_tipo_usuario='I'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaUsuarios.add(new Instrutor(resultado.getString("nro_cref"),
                    resultado.getString("cod_cpf"),
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate()));
        }

        return listaUsuarios;
    }

    @Override
    public void postUsuario(Usuario instrutor) throws SQLException {
        this.instrutor = (Instrutor)instrutor;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,CAST(? as date)); "
                + "INSERT INTO \"Instrutor\" "
                + "VALUES((SELECT cod_cpf FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + instrutor.getCodCpf() + "'), '" + this.instrutor.getCodCREF() + "')";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, instrutor.getCodCpf());
        stmt.setString(2, instrutor.getNomUsuario());
        stmt.setString(3, String.valueOf(instrutor.getIdtTipoUsuario()));
        stmt.setString(4, instrutor.getTxtSenha());
        stmt.setString(5, instrutor.getDesEmail());
        stmt.setString(6, String.valueOf(instrutor.getDatNascimento()));

        stmt.executeUpdate();

    }

    @Override
    public void putUsuario(Usuario instrutor) throws SQLException {
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=CAST(? as date) "
                + "WHERE cod_cpf=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, instrutor.getNomUsuario());
        stmt.setString(2, String.valueOf(instrutor.getIdtTipoUsuario()));
        stmt.setString(3, instrutor.getTxtSenha());
        stmt.setString(4, instrutor.getDesEmail());
        stmt.setString(5, String.valueOf(instrutor.getDatNascimento()));
        stmt.setString(6, instrutor.getCodCpf());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteUsuario(String cpf) throws SQLException {
        sql = "DELETE FROM \"Usuario\" "
                + "WHERE cod_cpf='" + cpf + "'";

        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);

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
