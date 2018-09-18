package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Atividade;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtividadeDao implements IAtividadeDao {

    private Atividade atividade;
    private ArrayList<Exercicio> listaExercicios;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final ExercicioDao exercicioDao;

    public AtividadeDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
        exercicioDao = new ExercicioDao();
    }

    @Override
    public Atividade getAtividade(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        sql = "SELECT qtd_peso, nro_series, nro_repeticoes "
                + "FROM \"TreinoExercicio\""
                + "WHERE cod_cpf='" + codCpf + "' AND nro_treino = '" + nroTreino + "'"
                + "AND cod_exercicio = '" + codExercicio + "'AND nro_aparelho='" + nroAparelho + "' "
                + "AND nro_ficha='" + nroFicha + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            atividade = new Atividade(exercicioDao.getAparelhoExercicio(codExercicio, nroAparelho),
                    codCpf,
                    nroFicha,
                    nroTreino,
                    resultado.getInt("qtd_peso"),
                    resultado.getInt("nro_series"),
                    resultado.getInt("nro_repeticoes"));
        } else {

            return null;
        }

        return atividade;
    }

    @Override
    public void postAtividade(Atividade atividade) throws SQLException {
        sql = "INSERT INTO \"TreinoExercicio\" VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "(SELECT cod_cpf FROM \"Treino\" WHERE cod_cpf='" + atividade.getCodCpf() + "')");
        stmt.setString(2, "(SELECT nro_treino FROM \"Treino\" WHERE nro_treino='" + atividade.getNroTreino() + "')");
        stmt.setString(3, String.valueOf(atividade.getAparelhoExercicio().getExercicio().getCodExercicio()));
        stmt.setString(4, String.valueOf(atividade.getAparelhoExercicio().getAparelho().getNroAparelho()));
        stmt.setString(5, "(SELECT nro_ficha FROM \"Treino\" WHERE nro_ficha='" + atividade.getNroFicha() + "')");
        stmt.setString(6, String.valueOf(atividade.getNroSeries()));
        stmt.setString(7, String.valueOf(atividade.getNroRepeticoes()));
        stmt.setString(8, String.valueOf(atividade.getQtdPeso()));

        stmt.executeQuery(sql);

    }

    @Override
    public void putAtividade(Atividade atividade) throws SQLException {
        sql = "UPDATE \"TreinoExercicio\" "
                + "SET nro_series=?, "
                + "nro_repeticoes=?, "
                + "qtd_peso=? "
                + "WHERE cod_cpf='" + atividade.getCodCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "' "
                + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getCodExercicio() + "' "
                + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNroAparelho() + "' "
                + "AND nro_ficha='" + atividade.getNroFicha() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(atividade.getNroSeries()));
        stmt.setString(2, String.valueOf(atividade.getNroRepeticoes()));
        stmt.setString(3, String.valueOf(atividade.getQtdPeso()));

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        sql = "DELETE FROM \"TreinoExercicio\" "
                + "WHERE cod_cpf='" + cpf + "' AND nro_treino = '" + nroTreino + "'"
                + "AND cod_exercicio = '" + codExercicio + "'AND nro_aparelho='" + nroAparelho + "' "
                + "AND nro_ficha='" + nroFicha + "'";

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
