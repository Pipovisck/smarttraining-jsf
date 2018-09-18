/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
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
public class ManterObjetivoProxy implements IManterObjetivo {

    Cliente cliente;

    public ManterObjetivoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codObjetivo));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_OBJETIVO_COD, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Objetivo objetivo = gson.fromJson(pacoteRecebido.getDados().get(0), Objetivo.class);
        return objetivo;
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(nome));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_OBJETIVO_NOME, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Objetivo objetivo = gson.fromJson(pacoteRecebido.getDados().get(0), Objetivo.class);
        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(dataAvaliacao));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_OBJETIVO_AVALIACAO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Objetivo> listaObjetivos = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Objetivo>>() {}.getType());
        return listaObjetivos;
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_OBJETIVO, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Objetivo> listaObjetivos = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Objetivo>>() {}.getType());
        return listaObjetivos;
    }

    @Override
    public void cadastrar(Objetivo objetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(objetivo));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_OBJETIVO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Objetivo objetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(objetivo));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_OBJETIVO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(int codObjetivo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codObjetivo));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_OBJETIVO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
