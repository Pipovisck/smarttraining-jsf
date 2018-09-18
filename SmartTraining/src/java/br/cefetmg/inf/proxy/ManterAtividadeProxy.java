/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class ManterAtividadeProxy implements IManterAtividade {

    Cliente cliente;

    public ManterAtividadeProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(nroTreino));
        dados.add(gson.toJson(codExercicio));
        dados.add(gson.toJson(nroAparelho));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_ATIVIDADE, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Atividade atividade = gson.fromJson(pacoteRecebido.getDados().get(0), Atividade.class);
        return atividade;
    }

    @Override
    public void cadastrar(Atividade atividade) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(atividade));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_ATIVIDADE, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Atividade atividade) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(atividade));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_ATIVIDADE, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(nroTreino));
        dados.add(gson.toJson(codExercicio));
        dados.add(gson.toJson(nroAparelho));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_ATIVIDADE, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
