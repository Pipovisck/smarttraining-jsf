package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.proxy.ManterFichaProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("ficha")
public class FichaMB {
    private Ficha ficha;
    private ArrayList<Ficha> listaFichas;

    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterFicha manterFicha = new ManterFichaProxy();
            manterFicha.cadastrar(ficha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar ficha!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarFicha";
        try {
            IManterFicha manterFicha = new ManterFichaProxy();
            ficha = manterFicha.pesquisarPorCodigo(ficha.getCodCpfAluno(), ficha.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar ficha!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterFicha manterFicha = new ManterFichaProxy();
            manterFicha.alterar(ficha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar ficha!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterFicha manterFicha = new ManterFichaProxy();
            manterFicha.excluir(ficha.getCodCpfAluno(), ficha.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir ficha!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaFichas";
        try {
            IManterFicha manterFicha = new ManterFichaProxy();
            manterFicha.pesquisarPorAluno(ficha.getCodCpfAluno());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar fichas!");
        }
        return jsf;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }
    
}
