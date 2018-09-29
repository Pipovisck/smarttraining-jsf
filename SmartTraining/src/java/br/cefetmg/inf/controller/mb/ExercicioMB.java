package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("exercicio")
public class ExercicioMB {

    private Exercicio exercicio;
    private AparelhoExercicio aparelhoExercicio;
    private ArrayList<Exercicio> listaExercicios;
    private String[] codMusculos;
    private String[] codAparelhos;

    public String cadastrar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            manterExercicio.cadastrar(exercicio, codMusculos);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar exercício!");
        }
        return jsf;
    }
    
    public String cadastrarAparelhoExercicio() {
        String jsf = "";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            manterExercicio.cadastrarAparelhoExercicio(exercicio.getCodExercicio(), 
                            aparelhoExercicio.getAparelho().getNroAparelho(), aparelhoExercicio.getCaminhoImagem());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar aparelhoExercício!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarExercicio";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            exercicio = manterExercicio.pesquisarPorCodigo(exercicio.getCodExercicio());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar exercício!");
        }
        return jsf;
    }
    
    public String pesquisarAparelhoExercicio() {
        String jsf = "";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            aparelhoExercicio = manterExercicio.pesquisarAparelhoExercicio(exercicio.getCodExercicio(), 
                                                aparelhoExercicio.getAparelho().getNroAparelho());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar aparelhoExercício!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            manterExercicio.alterar(exercicio);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar exercício!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            manterExercicio.excluir(exercicio.getCodExercicio());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir exercício!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaExercicios";
        try {
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            listaExercicios = manterExercicio.pesquisarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exercícios!");
        }
        return jsf;
    }
    
//    public String listarPorMusculo() {
//        String jsf = "";
//        try {
//            IManterExercicio manterExercicio = new ManterExercicioProxy();
//            listaExercicios = manterExercicio.pesquisarPorMusculo();
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao listar exercícios!");
//        }
//        return jsf;
//    }
    
//    public String listarPorRegiao() {
//        String jsf = "";
//        try {
//            IManterExercicio manterExercicio = new ManterExercicioProxy();
//            listaExercicios = manterExercicio.pesquisarPorRegiao();
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao listar exercícios!");
//        }
//        return jsf;
//    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public AparelhoExercicio getAparelhoExercicio() {
        return aparelhoExercicio;
    }

    public void setAparelhoExercicio(AparelhoExercicio aparelhoExercicio) {
        this.aparelhoExercicio = aparelhoExercicio;
    }

    public ArrayList<Exercicio> getListaExercicios() {
        return listaExercicios;
    }

    public void setListaExercicios(ArrayList<Exercicio> listaExercicios) {
        this.listaExercicios = listaExercicios;
    }

    public String[] getCodMusculos() {
        return codMusculos;
    }

    public void setCodMusculos(String[] codMusculos) {
        this.codMusculos = codMusculos;
    }

    public String[] getCodAparelhos() {
        return codAparelhos;
    }

    public void setCodAparelhos(String[] codAparelhos) {
        this.codAparelhos = codAparelhos;
    }
    
}
