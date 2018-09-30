package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("musculo")
public class MusculoMB {

    private Musculo musculo;
    private ArrayList<Musculo> listaMusculos;

    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            manterMusculo.cadastrar(musculo);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar músculo!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarMusculo";
        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            musculo = manterMusculo.pesquisarPorCodigo(musculo.getCodMusculo());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar músculo!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            manterMusculo.alterar(musculo);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar músculo!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            manterMusculo.excluir(musculo.getCodMusculo());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir músculo!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaMusculos";
        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();
            listaMusculos = manterMusculo.pesquisarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os músculos!");
        }
        return jsf;
    }

    public Musculo getMusculo() {
        return musculo;
    }

    public void setMusculo(Musculo musculo) {
        this.musculo = musculo;
    }

    public ArrayList<Musculo> getListaMusculos() {
        return listaMusculos;
    }

    public void setListaMusculos(ArrayList<Musculo> listaMusculos) {
        this.listaMusculos = listaMusculos;
    }
}
