/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
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
public class ManterInstrutorProxy implements IManterUsuario {

    Cliente cliente;

    public ManterInstrutorProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_INSTRUTOR_CPF, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Instrutor instrutor = gson.fromJson(pacoteRecebido.getDados().get(0), Instrutor.class);
        return instrutor;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(nome));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_INSTRUTOR_NOME, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Instrutor instrutor = gson.fromJson(pacoteRecebido.getDados().get(0), Instrutor.class);
        return instrutor;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_INSTRUTOR, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Usuario> listaInstrutores = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Instrutor>>() {}.getType());
        return listaInstrutores;
    }

    @Override
    public void cadastrar(Usuario instrutor) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(instrutor));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_INSTRUTOR, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Usuario instrutor) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(instrutor));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_INSTRUTOR, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_INSTRUTOR, dados);

        cliente.requisicao(pacoteEnviado);
    }
}
