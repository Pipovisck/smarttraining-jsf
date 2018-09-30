package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named("avaliacao")
public class AvaliacaoMB {

    Avaliacao avaliacao;
    ArrayList<Avaliacao> listaAvaliacoes;

    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

            LocalDate dataAvaliacao = LocalDate.now();
            avaliacao.setDatAvaliacao(dataAvaliacao);

            manterAvaliacao.cadastrar(avaliacao);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar avaliacao!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarAvaliacao";
        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

            avaliacao = manterAvaliacao.pesquisar(avaliacao.getCodCpfAluno(), avaliacao.getDatAvaliacao());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar avaliacao!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

            manterAvaliacao.alterar(avaliacao);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar avaliacao!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

            manterAvaliacao.excluir(avaliacao.getCodCpfAluno(), avaliacao.getDatAvaliacao());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir avaliacao!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaAvaliacoes";
        try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

            listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(avaliacao.getCodCpfAluno());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar avaliacoes!");
        }
        return jsf;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ArrayList<Avaliacao> getListaAvaliacoes() {
        return listaAvaliacoes;
    }

    public void setListaAvaliacoes(ArrayList<Avaliacao> listaAvaliacoes) {
        this.listaAvaliacoes = listaAvaliacoes;
    }
}
