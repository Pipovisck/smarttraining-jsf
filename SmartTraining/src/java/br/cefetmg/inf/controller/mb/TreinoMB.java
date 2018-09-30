package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import br.cefetmg.inf.proxy.ManterTreinoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("treino")
public class TreinoMB {

    private Treino treino;
    private ArrayList<Treino> listaTreinos;
    
    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterTreino manterTreino = new ManterTreinoProxy();
            manterTreino.cadastrar(treino);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar treino!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarTreino";
        try {
            IManterTreino manterTreino = new ManterTreinoProxy();
            treino = manterTreino.pesquisarTreino(treino.getCodCpfAluno(), treino.getNroFicha(), treino.getNroTreino());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar treino!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterTreino manterTreino = new ManterTreinoProxy();
            manterTreino.alterar(treino);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar treino!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterTreino manterTreino = new ManterTreinoProxy();
            manterTreino.excluir(treino.getCodCpfAluno(), treino.getNroTreino(), treino.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir treino!");
        }
        return jsf;
    }

    public String listarPorFicha() {
        String jsf = "ListaTreinos";
        try {
            IManterTreino manterTreino = new ManterTreinoProxy();
            listaTreinos = manterTreino.pesquisarPorFicha(treino.getCodCpfAluno(), treino.getNroFicha());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar treinos da ficha!");
        }
        return jsf;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public ArrayList<Treino> getListaTreinos() {
        return listaTreinos;
    }

    public void setListaTreinos(ArrayList<Treino> listaTreinos) {
        this.listaTreinos = listaTreinos;
    }
    
}
