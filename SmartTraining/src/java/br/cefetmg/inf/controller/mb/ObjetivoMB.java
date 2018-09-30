package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.proxy.ManterObjetivoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("objetivo")
public class ObjetivoMB {
        
    private Objetivo objetivo;
    private Avaliacao avaliacao;
    private ArrayList<Objetivo> listaObjetivos;
   
    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            manterObjetivo.cadastrar(objetivo);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar objetivo!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarObjetivo";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            objetivo = manterObjetivo.pesquisarPorCodigo(objetivo.getCodObjetivo());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar objetivo!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            manterObjetivo.alterar(objetivo);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar objetivo!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            manterObjetivo.excluir(objetivo.getCodObjetivo());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir objetivo!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaObjetivos";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            listaObjetivos = manterObjetivo.pesquisarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar objetivos!");
        }
        return jsf;
    }
        public String listarPorAvaliacao() {
        String jsf = "ListaObjetivos";
        try {
            IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
            listaObjetivos = manterObjetivo.pesquisarPorAvaliacao(avaliacao.getCodCpfAluno(), avaliacao.getDatAvaliacao());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os objetivos da avaliação!");
        }
        return jsf;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ArrayList<Objetivo> getListaObjetivos() {
        return listaObjetivos;
    }

    public void setListaObjetivos(ArrayList<Objetivo> listaObjetivos) {
        this.listaObjetivos = listaObjetivos;
    }
}
