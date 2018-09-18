package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegiaoCorporalDao implements IRegiaoCorporalDao {

    private RegiaoCorporal regiao;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public RegiaoCorporalDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public RegiaoCorporal getRegiaoCorporal(int codRegiao) throws SQLException {
        ArrayList<Musculo> listaMusculos = new ArrayList<>();
        sql = "SELECT * FROM \"RegiaoCorporal\" "
                + "JOIN \"Musculo\" USING(\"cod_regCorp\") "
                + "GROUP BY \"cod_regCorp\", cod_musculo "
                + "HAVING \"cod_regCorp\"='" + codRegiao + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaMusculos.add(new Musculo(resultado.getInt("cod_musculo"), resultado.getInt("cod_regCorp"), resultado.getString("nom_musculo"), resultado.getString("img_musculo"), null));
            regiao = new RegiaoCorporal(codRegiao, resultado.getString("nom_regCorp"), listaMusculos);
        }

        return regiao;
    }

    @Override
    public void postRegiaoCorporal(RegiaoCorporal regiao, int codMusculo) throws SQLException {
        this.regiao = regiao;
        sql = "INSERT INTO \"RegiaoCorporal\" (nom_regiao) VALUES (?);";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, regiao.getNomeRegiao());

        stmt.executeQuery(sql);

    }

    @Override
    public void putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException {
        this.regiao = regiao;
        sql = "UPDATE \"RegiaoCorporal\" "
                + "SET nom_regiao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, regiao.getNomeRegiao());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteRegiaoCorporal(int cod_regiao) throws SQLException {
        sql = "DELETE FROM \"RegiaoCorporal\" "
                + "WHERE cod_regiao=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(cod_regiao));

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
