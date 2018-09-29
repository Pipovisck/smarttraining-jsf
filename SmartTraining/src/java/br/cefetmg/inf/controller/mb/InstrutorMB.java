package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("instrutor")
public class InstrutorMB {

    private Usuario instrutor;
    private ArrayList<Usuario> listaInstrutores;

    public String cadastrar() {
        String jsf = "LoginUsuario";
        try {
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            manterInstrutor.cadastrar(instrutor);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário!");
        }
        return jsf;
    }

    public String pesquisar() {
        String jsf = "AlterarUsuario";
        try {
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            instrutor = manterInstrutor.pesquisarPorCpf(instrutor.getCodCpf());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar instrutor!");
        }
        return jsf;
    }

    public String alterar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            manterInstrutor.alterar(instrutor);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar instrutor!");
        }
        return jsf;
    }

    public String deletar() {
        String jsf = "TelaInicialInstrutor";
        try {
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            manterInstrutor.excluir(instrutor.getCodCpf());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir instrutor!");
        }
        return jsf;
    }

    public String listar() {
        String jsf = "ListaInstrutores";
        try {
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            listaInstrutores = manterInstrutor.pesquisarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar alunos!");
        }
        return jsf;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

    public ArrayList<Usuario> getListaInstrutores() {
        return listaInstrutores;
    }

    public void setListaInstrutores(ArrayList<Usuario> listaInstrutores) {
        this.listaInstrutores = listaInstrutores;
    }

}
