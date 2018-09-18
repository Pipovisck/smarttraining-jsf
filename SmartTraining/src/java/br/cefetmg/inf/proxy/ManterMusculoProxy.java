/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.util.Pacote;
import br.cefetmg.inf.util.TipoOperacao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
public class ManterMusculoProxy implements IManterMusculo {

    Cliente cliente;

    public ManterMusculoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codMusculo));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_MUSCULO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Musculo musculo = gson.fromJson(pacoteRecebido.getDados().get(0), Musculo.class);
        return musculo;
    }

    @Override
    public ArrayList<Musculo> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_MUSCULO, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Musculo> listaMusculos = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Musculo>>() {}.getType());
        return listaMusculos;
    }

    @Override
    public void cadastrar(Musculo musculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(musculo));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_MUSCULO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Musculo musculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(musculo));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_MUSCULO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codMusculo));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_MUSCULO, dados);

        cliente.requisicao(pacoteEnviado);
    }
}
