/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
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
 * @author gabriel
 */
public class ManterAparelhoProxy implements IManterAparelho {

    Cliente cliente;

    public ManterAparelhoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAparelhoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(nroAparelho));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHO_NUM, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Aparelho aparelho = gson.fromJson(pacoteRecebido.getDados().get(0), Aparelho.class);
        return aparelho;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(nomAparelho));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_APARELHO_NOME, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Aparelho aparelho = gson.fromJson(pacoteRecebido.getDados().get(0), Aparelho.class);
        return aparelho;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        pacoteEnviado = new Pacote(TipoOperacao.LISTA_APARELHO, null);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        
        ArrayList<Aparelho> listaAparelhos = gson.fromJson(pacoteRecebido.getDados().get(0),
                new TypeToken<ArrayList<Aparelho>>() {
                }.getType());
        
        return listaAparelhos;
    }

    @Override
    public void cadastrar(Aparelho aparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(aparelho));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_APARELHO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Aparelho aparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(aparelho));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_APARELHO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(int nroAparelho) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();

        dados.add(gson.toJson(nroAparelho));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_APARELHO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
