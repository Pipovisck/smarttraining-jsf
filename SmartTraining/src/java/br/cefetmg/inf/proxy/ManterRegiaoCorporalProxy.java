/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
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
public class ManterRegiaoCorporalProxy implements IManterRegiaoCorporal {

Cliente cliente;

    public ManterRegiaoCorporalProxy() {
        try {
            this.cliente = Cliente.getInstancia();
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codRegiao));
        pacoteEnviado = new Pacote(TipoOperacao.PESQ_REGCORP, dados);

        pacoteRecebido = cliente.requisicao(pacoteEnviado);
        RegiaoCorporal regCorp = gson.fromJson(pacoteRecebido.getDados().get(0), RegiaoCorporal.class);
        return regCorp;
    }

    @Override
    public void cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(regiaoCorporal));
        dados.add(gson.toJson(codMusculo));
        pacoteEnviado = new Pacote(TipoOperacao.CAD_REGCORP, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void alterar(RegiaoCorporal regiaoCorporal) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(regiaoCorporal));
        pacoteEnviado = new Pacote(TipoOperacao.ALTERA_REGCORP, dados);

        cliente.requisicao(pacoteEnviado);
    }

    @Override
    public void excluir(int codRegiao) throws SQLException {
        Pacote pacoteEnviado;
        Pacote pacoteRecebido;

        Gson gson = new Gson();

        ArrayList<String> dados = new ArrayList<>();
        
        dados.add(gson.toJson(codRegiao));
        pacoteEnviado = new Pacote(TipoOperacao.EXCLUI_REGCORP, dados);

        cliente.requisicao(pacoteEnviado);
    }

}
