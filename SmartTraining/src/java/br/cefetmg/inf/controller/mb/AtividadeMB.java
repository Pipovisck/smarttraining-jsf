package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import br.cefetmg.inf.proxy.ManterAtividadeProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
@Named("atividade")
public class AtividadeMB {
  
    private Atividade atividade;
    private ArrayList<Atividade> listaAtividades;

    public String cadastrar() {
        String jsf = "";
        try {
            IManterAtividade manterAtividade = new ManterAtividadeProxy();
            manterAtividade.cadastrar(atividade);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar atividade!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "";
        try {
            IManterAtividade manterAtividade = new ManterAtividadeProxy();
            atividade = manterAtividade.pesquisar(atividade.getCodCpf(), atividade.getNroTreino(), 
                                        atividade.getAparelhoExercicio().getExercicio().getCodExercicio(), 
                                        atividade.getAparelhoExercicio().getAparelho().getNroAparelho(), atividade.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar atividade!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "";
        try {
            IManterAtividade manterAtividade = new ManterAtividadeProxy();
            manterAtividade.alterar(atividade);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar atividade!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "";
        try {
            IManterAtividade manterAtividade = new ManterAtividadeProxy();
            manterAtividade.excluir(atividade.getCodCpf(), atividade.getNroTreino(), 
                                        atividade.getAparelhoExercicio().getExercicio().getCodExercicio(), 
                                        atividade.getAparelhoExercicio().getAparelho().getNroAparelho(), atividade.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir atividade!");
        }
        return jsf;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public ArrayList<Atividade> getListaAtividades() {
        return listaAtividades;
    }

    public void setListaAtividades(ArrayList<Atividade> listaAtividades) {
        this.listaAtividades = listaAtividades;
    }

}
