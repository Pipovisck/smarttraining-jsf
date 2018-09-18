package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ITreinoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Atividade;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Treino;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreinoDao implements ITreinoDao {

    private Treino treino;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final AparelhoDao aparelhoDao;
    private final ExercicioDao exercicioDao;

    public TreinoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
        aparelhoDao = new AparelhoDao();
        exercicioDao = new ExercicioDao();
    }

    @Override
    public Treino getTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        ArrayList<Atividade> listaAtividade = new ArrayList<>();
        AparelhoExercicio aparelhoExercicio;

        sql = "SELECT * FROM \"Treino\" "
                + "JOIN \"TreinoExercicio\" USING(cod_cpf, nro_ficha, nro_treino) "
                + "GROUP BY cod_cpf, nro_ficha, nro_treino, cod_exercicio, nro_aparelho, nro_series, qtd_peso, nro_repeticoes "
                + "HAVING cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            do {
                aparelhoExercicio = exercicioDao.getAparelhoExercicio(resultado.getInt("cod_exercicio"), resultado.getInt("nro_aparelho"));
                listaAtividade.add(new Atividade(aparelhoExercicio,
                        resultado.getString("cod_cpf"),
                        resultado.getInt("nro_ficha"),
                        resultado.getInt("nro_treino"),
                        resultado.getInt("qtd_peso"),
                        resultado.getInt("nro_series"),
                        resultado.getInt("nro_repeticoes")));
            } while (resultado.next());
        } else {

            return null;
        }

        treino = new Treino(cpf, nroFicha, nroTreino, resultado.getString("des_treino"), listaAtividade);
        return treino;
    }

    @Override
    public ArrayList<Treino> getFichaTreinos(String cpf, int nroFicha) throws SQLException {
        ArrayList<Treino> listaTreino = new ArrayList<>();
        int nroTreino = 1;
        while (true) {
            ArrayList<Atividade> listaAtividade = new ArrayList<>();
            AparelhoExercicio aparelhoExercicio;

            sql = "SELECT * FROM \"Treino\" "
                    + "JOIN \"TreinoExercicio\" USING(cod_cpf, nro_ficha, nro_treino) "
                    + "GROUP BY cod_cpf, nro_ficha, nro_treino, cod_exercicio, nro_aparelho, nro_series, qtd_peso, nro_repeticoes "
                    + "HAVING cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            if (resultado.next()) {
                do {
                    aparelhoExercicio = exercicioDao.getAparelhoExercicio(resultado.getInt("cod_exercicio"), resultado.getInt("nro_aparelho"));
                    listaAtividade.add(new Atividade(aparelhoExercicio,
                            resultado.getString("cod_cpf"),
                            resultado.getInt("nro_ficha"),
                            resultado.getInt("nro_treino"),
                            resultado.getInt("qtd_peso"),
                            resultado.getInt("nro_series"),
                            resultado.getInt("nro_repeticoes")));
                } while (resultado.next());
            } else {
                break;
            }
            treino = new Treino(cpf, nroFicha, nroTreino, resultado.getString("des_treino"), listaAtividade);
            listaTreino.add(treino);
            nroTreino++;
        }
        return listaTreino;
    }

    @Override
    public void postTreino(Treino treino) throws SQLException {
        sql = "INSERT INTO \"Treino\" VALUES (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "SELECT \"cod_cpf\" FROM \"Ficha\" WHERE \"cod_cpf\"='" + treino.getCodCpfAluno() + "'");
        stmt.setString(2, "SELECT \"nro_ficha\" FROM \"Ficha\" WHERE \"nro_ficha\"='" + treino.getNroFicha() + "'");
        stmt.setString(3, String.valueOf(treino.getNroTreino()));
        stmt.setString(4, treino.getDescricaoTreino());

        stmt.executeQuery(sql);

    }

    @Override
    public void putTreino(Treino treino) throws SQLException {
        sql = "UPDATE \"Treino\" "
                + "SET des_treino=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, treino.getDescricaoTreino());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        sql = "DELETE FROM \"Treino\" "
                + "WHERE cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

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
