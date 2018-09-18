/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
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
public class ManterTreinoProxy implements IManterTreino {

    Cliente cliente;

    public ManterTreinoProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(cpf));
        dados.add(gson.toJson(nroFicha));
        dados.add(gson.toJson(nroTreino));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_TREINO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Treino treino = gson.fromJson(pacoteRecebido.getDados().get(0), Treino.class);
        return treino;
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(cpf));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_TREINO_FICHA, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Treino> listaTreinos = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Treino>>() {}.getType());
        return listaTreinos;
    }

    @Override
    public void cadastrar(Treino treino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(treino));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_TREINO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Treino treino) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(treino));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_TREINO, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String cpf, int nroTreino, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(cpf));
        dados.add(gson.toJson(nroTreino));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_TREINO, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
