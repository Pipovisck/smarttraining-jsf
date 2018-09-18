/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class ManterAvaliacaoProxy implements IManterAvaliacao {

    Cliente cliente;

    public ManterAvaliacaoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_AVALIACAO_ALUNO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Avaliacao> listaAvaliacoes = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Avaliacao>>() {}.getType());
        return listaAvaliacoes;
    }

    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(data));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_AVALIACAO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Avaliacao avaliacao = gson.fromJson(pacoteRecebido.getDados().get(0), Avaliacao.class);
        return avaliacao;
    }

    @Override
    public void cadastrar(Avaliacao avaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(avaliacao));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_AVALIACAO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Avaliacao avaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(avaliacao));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_AVALIACAO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, LocalDate datAvaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();
        
        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(datAvaliacao));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_AVALIACAO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
