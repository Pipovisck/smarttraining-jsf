package br.cefetmg.inf.controller.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
import java.sql.SQLException;
import java.util.ArrayList;

@RequestScoped
@Named("aparelho")
public class AparelhoMB {
    
    private Aparelho aparelho;
    private ArrayList<Aparelho> listaAparelhos;

    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterAparelho manterAparelho = new ManterAparelhoProxy();
            manterAparelho.cadastrar(aparelho);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aparelho!");
        }
        return jsf;
    }

//    public String pesquisar() {
//        String jsf = "";
//        try {
//            IManterAparelho manterAparelho = new ManterAparelhoProxy();
//            aparelho = manterAparelho.pesquisar(aparelho.getNroAparelho());
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao pesquisar aparelho!");
//        }
//        return jsf;
//    }
//
//    public String alterar() {
//        String jsf = "";
//        try {
//            IManterAparelho manterAparelho = new ManterAparelhoProxy();
//            manterAparelho.alterar(aparelho);
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao alterar aparelho!");
//        }
//        return jsf;
//    }
//
//    public String deletar() {
//        String jsf = "";
//        try {
//            IManterAparelho manterAparelho = new ManterAparelhoProxy();
//            manterAparelho.excluir(aparelho.getNroAparelho());
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao excluir aparelho!");
//        }
//        return jsf;
//    }
//
//    public String listar() {
//        String jsf = "";
//        try {
//            IManterAparelho manterAparelho = new ManterAparelhoProxy();
//            listaAparelhos = manterAparelho.pesquisarTodos();
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao listar avaliacoes!");
//        }
//        return jsf;
//    }
   
    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public ArrayList<Aparelho> getListaAparelhos() {
        return listaAparelhos;
    }

    public void setListaAparelhos(ArrayList<Aparelho> listaAparelhos) {
        this.listaAparelhos = listaAparelhos;
    }
       
}
