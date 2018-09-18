package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAvaliacaoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.time.LocalDate;
import br.cefetmg.inf.model.domain.Avaliacao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvaliacaoDao implements IAvaliacaoDao {

    private Avaliacao avaliacao;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final ObjetivoDao objetivoDao;

    public AvaliacaoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
        objetivoDao = new ObjetivoDao();
    }
    
    @Override
    public Avaliacao getAvaliacao(String cpf, LocalDate data) throws SQLException {
               sql = "SELECT * "
                + "FROM \"Avaliacao\" "
                + "WHERE cod_cpf = '" + cpf + "' AND dat_avaliacao = '" + data + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            avaliacao = new Avaliacao(cpf,
                    data,
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getBoolean("idt_recencia"),
                    Double.parseDouble(resultado.getString("qtd_peso")),
                    Double.parseDouble(resultado.getString("qtd_percGordura")),
                    Double.parseDouble(resultado.getString("tam_pescoco")),
                    Double.parseDouble(resultado.getString("tam_ombro")),
                    Double.parseDouble(resultado.getString("tam_torax")),
                    Double.parseDouble(resultado.getString("tam_abdomen")),
                    Double.parseDouble(resultado.getString("tam_cintura")),
                    Double.parseDouble(resultado.getString("tam_quadril")),
                    Double.parseDouble(resultado.getString("qtd_massaGorda")),
                    Double.parseDouble(resultado.getString("tam_bracoEsq")),
                    Double.parseDouble(resultado.getString("tam_bracoDir")),
                    Double.parseDouble(resultado.getString("tam_antebracoEsq")),
                    Double.parseDouble(resultado.getString("tam_antebracoDir")),
                    Double.parseDouble(resultado.getString("tam_coxaEsq")),
                    Double.parseDouble(resultado.getString("tam_coxaDir")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaEsq")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaDir")),
                    objetivoDao.getAvaliacaoObjetivos(cpf, resultado.getDate("dat_avaliacao").toLocalDate()));
        } else {

            return null;
        }

        return avaliacao; 
    }

    @Override
    public ArrayList<Avaliacao> getListaAvaliacao(String codCpf) throws SQLException {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Avaliacao\" "
                + "WHERE cod_cpf = '" + codCpf + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            avaliacao = new Avaliacao(codCpf,
                    resultado.getDate("dat_avaliacao").toLocalDate(),
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getBoolean("idt_recencia"),
                    Double.parseDouble(resultado.getString("qtd_peso")),
                    Double.parseDouble(resultado.getString("qtd_percGordura")),
                    Double.parseDouble(resultado.getString("tam_pescoco")),
                    Double.parseDouble(resultado.getString("tam_ombro")),
                    Double.parseDouble(resultado.getString("tam_torax")),
                    Double.parseDouble(resultado.getString("tam_abdomen")),
                    Double.parseDouble(resultado.getString("tam_cintura")),
                    Double.parseDouble(resultado.getString("tam_quadril")),
                    Double.parseDouble(resultado.getString("qtd_massaGorda")),
                    Double.parseDouble(resultado.getString("tam_bracoEsq")),
                    Double.parseDouble(resultado.getString("tam_bracoDir")),
                    Double.parseDouble(resultado.getString("tam_antebracoEsq")),
                    Double.parseDouble(resultado.getString("tam_antebracoDir")),
                    Double.parseDouble(resultado.getString("tam_coxaEsq")),
                    Double.parseDouble(resultado.getString("tam_coxaDir")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaEsq")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaDir")),
                    objetivoDao.getAvaliacaoObjetivos(codCpf, resultado.getDate("dat_avaliacao").toLocalDate()));
            listaAvaliacao.add(avaliacao);
        }


        return listaAvaliacao;
    }

    @Override
    public void postAvaliacao(Avaliacao avaliacao) throws SQLException {
        sql = "INSERT INTO \"Avaliacao\" VALUES ("
                + "(SELECT \"cod_cpf\" FROM \"Aluno\" WHERE \"cod_cpf\"='" + avaliacao.getCodCpfAluno() + "'),"
                + "CAST(? as date),"
                + "(SELECT \"cod_cpf\" FROM \"Instrutor\" WHERE \"cod_cpf\"='" + avaliacao.getCodCpfInstrutor() + "'),"
                + "CAST(? as boolean),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric),"
                + "CAST(? as numeric))";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, avaliacao.getDatAvaliacao().toString());
        stmt.setString(2, String.valueOf(avaliacao.getIdtRecencia()));
        stmt.setString(3, String.valueOf(avaliacao.getPeso()));
        stmt.setString(4, String.valueOf(avaliacao.getMassaGorda()));
        stmt.setString(5, String.valueOf(avaliacao.getPercentualGordura()));
        stmt.setString(6, String.valueOf(avaliacao.getTamanhoPescoco()));
        stmt.setString(7, String.valueOf(avaliacao.getTamanhoOmbro()));
        stmt.setString(8, String.valueOf(avaliacao.getTamanhoTorax()));
        stmt.setString(9, String.valueOf(avaliacao.getTamanhoAbdomen()));
        stmt.setString(10, String.valueOf(avaliacao.getTamanhoCintura()));
        stmt.setString(11, String.valueOf(avaliacao.getTamanhoQuadril()));
        stmt.setString(12, String.valueOf(avaliacao.getTamanhoBracoEsquerdo()));
        stmt.setString(13, String.valueOf(avaliacao.getTamanhoBracoDireito()));
        stmt.setString(14, String.valueOf(avaliacao.getTamanhoAntebracoEsquerdo()));
        stmt.setString(15, String.valueOf(avaliacao.getTamanhoAntebracoDireito()));
        stmt.setString(16, String.valueOf(avaliacao.getTamanhoCoxaEsquerda()));
        stmt.setString(17, String.valueOf(avaliacao.getTamanhoCoxaDireita()));
        stmt.setString(18, String.valueOf(avaliacao.getTamanhoPanturrilhaEsquerda()));
        stmt.setString(19, String.valueOf(avaliacao.getTamanhoPanturrilhaDireita()));
        stmt.executeUpdate();

        for (int i = 0; i < avaliacao.getListaObjetivos().size(); i++) {
            sql = "INSERT INTO \"ObjetivoAvaliacao\" VALUES ("
                + "CAST((SELECT dat_avaliacao FROM \"Avaliacao\" "
                    + "WHERE cod_cpf='" + avaliacao.getCodCpfAluno() + "' "
                    + "AND dat_avaliacao=CAST('" + avaliacao.getDatAvaliacao().toString() + "' as date)) as date),"
                + " (SELECT cod_cpf FROM \"Avaliacao\" "
                    + "WHERE cod_cpf='" + avaliacao.getCodCpfAluno() + "' "
                    + "AND dat_avaliacao=CAST('" + avaliacao.getDatAvaliacao().toString() + "' as date)), "
                + "CAST((SELECT cod_objetivo FROM \"Objetivo\" "
                    + "WHERE cod_objetivo='" + avaliacao.getListaObjetivos().get(i).getCodObjetivo() + "') as bigint))";
            
            stmt = conn.prepareStatement(sql);
            stmt.execute();
        }

    }

    @Override
    public void putAvaliacao(Avaliacao avaliacao) throws SQLException {
        sql = "UPDATE \"Avaliacao\" "
                + "SET cod_cpf_instrutor=?, "
                + "idt_recencia= CAST(? as boolean), "
                + "qtd_peso= CAST(? as numeric), "
                + "\"qtd_massaGorda\"=CAST(? as numeric), "
                + "\"qtd_percGordura\"=CAST(? as numeric), "
                + "tam_pescoco=CAST(? as numeric), "
                + "tam_ombro=CAST(? as numeric), "
                + "tam_torax=CAST(? as numeric), "
                + "tam_abdomen=CAST(? as numeric), "
                + "tam_cintura=CAST(? as numeric), "
                + "tam_quadril=CAST(? as numeric), "
                + "\"tam_bracoEsq\"=CAST(? as numeric), "
                + "\"tam_bracoDir\"=CAST(? as numeric), "
                + "\"tam_antebracoEsq\"=CAST(? as numeric), "
                + "\"tam_antebracoDir\"=CAST(? as numeric), "
                + "\"tam_coxaEsq\"=CAST(? as numeric), "
                + "\"tam_coxaDir\"=CAST(? as numeric), "
                + "\"tam_panturrilhaEsq\"=CAST(? as numeric), "
                + "\"tam_panturrilhaDir\"=CAST(? as numeric) "
                + "WHERE cod_cpf=? "
                + "AND dat_avaliacao= CAST(? as date)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, avaliacao.getCodCpfInstrutor());
        stmt.setString(2, String.valueOf(avaliacao.getIdtRecencia()));
        stmt.setString(3, String.valueOf(avaliacao.getPeso()));
        stmt.setString(4, String.valueOf(avaliacao.getMassaGorda()));
        stmt.setString(5, String.valueOf(avaliacao.getPercentualGordura()));
        stmt.setString(6, String.valueOf(avaliacao.getTamanhoPescoco()));
        stmt.setString(7, String.valueOf(avaliacao.getTamanhoOmbro()));
        stmt.setString(8, String.valueOf(avaliacao.getTamanhoTorax()));
        stmt.setString(9, String.valueOf(avaliacao.getTamanhoAbdomen()));
        stmt.setString(10, String.valueOf(avaliacao.getTamanhoCintura()));
        stmt.setString(11, String.valueOf(avaliacao.getTamanhoQuadril()));
        stmt.setString(12, String.valueOf(avaliacao.getTamanhoBracoEsquerdo()));
        stmt.setString(13, String.valueOf(avaliacao.getTamanhoBracoDireito()));
        stmt.setString(14, String.valueOf(avaliacao.getTamanhoAntebracoEsquerdo()));
        stmt.setString(15, String.valueOf(avaliacao.getTamanhoAntebracoDireito()));
        stmt.setString(16, String.valueOf(avaliacao.getTamanhoCoxaEsquerda()));
        stmt.setString(17, String.valueOf(avaliacao.getTamanhoCoxaDireita()));
        stmt.setString(18, String.valueOf(avaliacao.getTamanhoPanturrilhaEsquerda()));
        stmt.setString(19, String.valueOf(avaliacao.getTamanhoPanturrilhaDireita()));
        stmt.setString(20, avaliacao.getCodCpfAluno().trim());
        stmt.setString(21, avaliacao.getDatAvaliacao().toString().trim());

        stmt.executeUpdate();

    }

    @Override
    public void deleteAvaliacao(String cpf, LocalDate datAvaliacao) throws SQLException {
        sql = "DELETE FROM \"Avaliacao\" "
                + "WHERE cod_cpf='" + cpf + "' AND dat_avaliacao='" + datAvaliacao.toString() + "';";

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
