/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
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
public class ManterFichaProxy implements IManterFicha {

    Cliente cliente;

    public ManterFichaProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_FICHA, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        Ficha ficha = gson.fromJson(pacoteRecebido.getDados().get(0), Ficha.class);
        return ficha;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        pacoteEnviado = new Pacote(TipoOperacao.LISTA_FICHA_ALUNO, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        ArrayList<Ficha> listaFichas = gson.fromJson(pacoteRecebido.getDados().get(0), 
                new TypeToken<ArrayList<Ficha>>() {}.getType());
        return listaFichas;
    }

    @Override
    public void cadastrar(Ficha ficha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(ficha));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_FICHA, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(Ficha ficha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(ficha));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_FICHA, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(String codCpf, int nroFicha) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codCpf));
        dados.add(gson.toJson(nroFicha));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_FICHA, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
