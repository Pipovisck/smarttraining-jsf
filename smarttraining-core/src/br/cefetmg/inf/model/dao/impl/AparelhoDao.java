package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AparelhoDao implements IAparelhoDao {

    private ArrayList<Aparelho> listaAparelhos;
    private Aparelho aparelho;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AparelhoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Aparelho getAparelho(int nroAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nro_aparelho = '" + nroAparelho + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            aparelho = new Aparelho(nroAparelho,
                    resultado.getString("nom_aparelho"));
        } else {

            return null;
        }

        return aparelho;
    }

    @Override
    public Aparelho getAparelho(String nomAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nom_aparelho = '" + nomAparelho + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            aparelho = new Aparelho(resultado.getInt("nro_aparelho"), nomAparelho);
        } else {
            return null;
        }

        return aparelho;
    }
                   
    @Override
    public ArrayList<Aparelho> getListaAparelhos() throws SQLException {
        listaAparelhos = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Aparelho\" ";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaAparelhos.add(new Aparelho(resultado.getInt("nro_aparelho"),
                    resultado.getString("nom_aparelho")));
        }

        return listaAparelhos;
    }

    @Override
    public ArrayList<Exercicio> getListaExercicios(int nroAparelho) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();

        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"AparelhoExercicio\" WHERE nro_aparelho = '" + nroAparelho + "')";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaExercicios.add(new Exercicio(resultado.getInt("cod_exercicio"), 
                    resultado.getString("nom_exercicio"), 
                    resultado.getString("des_exercicio")));
        }
        if (listaExercicios.isEmpty()) {

            return null;
        }

        return listaExercicios;
    }

    @Override
    public void postAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "INSERT INTO \"Aparelho\" VALUES (CAST(? as smallint),?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(aparelho.getNroAparelho()));
        stmt.setString(2, aparelho.getNomAparelho());

        stmt.executeUpdate();

    }

    @Override
    public void putAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "UPDATE \"Aparelho\" "
                + "SET nom_usuario='" + aparelho.getNomAparelho() + "'"
                + "WHERE nro_aparelho='" + aparelho.getNroAparelho() + "'";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }

    @Override
    public void deleteAparelho(int nroAparelho) throws SQLException {
        sql = "DELETE FROM \"Aparelho\" "
                + "WHERE nro_aparelho='" + nroAparelho + "'";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

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
