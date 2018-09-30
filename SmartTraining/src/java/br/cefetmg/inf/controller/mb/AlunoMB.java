package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("aluno")
public class AlunoMB {
    
    private Usuario aluno;
    private ArrayList<Usuario> listaAlunos;

    public String cadastrar() {
        String jsf = "LoginUsuario";
        try {
            IManterUsuario manterAluno = new ManterAlunoProxy();
            manterAluno.cadastrar(aluno);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarUsuario";
        try {
            IManterUsuario manterAluno = new ManterAlunoProxy();
            aluno = manterAluno.pesquisarPorCpf(aluno.getCodCpf());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar usuário!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialAluno";
        try {
            IManterUsuario manterAluno = new ManterAlunoProxy();
            manterAluno.alterar(aluno);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar usuário!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterUsuario manterAluno = new ManterAlunoProxy();
            manterAluno.excluir(aluno.getCodCpf());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaAlunos";
        try {
            IManterUsuario manterAluno = new ManterAlunoProxy();
            listaAlunos = manterAluno.pesquisarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos!");
        }
        return jsf;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public ArrayList<Usuario> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Usuario> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }


}
