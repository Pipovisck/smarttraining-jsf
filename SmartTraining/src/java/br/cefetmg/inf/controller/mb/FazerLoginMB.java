package br.cefetmg.inf.controller.mb;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "login")
@SessionScoped
public class FazerLoginMB {

    public String cpf;
    public String senha;
    Usuario aluno;
    Usuario instrutor;

    public String login() {
        String jsf;
        try {

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            aluno = manterAluno.pesquisarPorCpf(cpf);
            instrutor = manterInstrutor.pesquisarPorCpf(cpf);

            if (aluno != null && aluno.getTxtSenha().equals(senha)) {
                jsf = "TelaInicialAluno";
            } else if (instrutor != null && instrutor.getTxtSenha().equals(senha)) {
                jsf = "TelaInicialInstrutor.xhtml";
            } else if ((aluno != null && !aluno.getTxtSenha().equals(senha)) || (instrutor != null && !instrutor.getTxtSenha().equals(senha))) {
                throw new RuntimeException("CPF incorreto! **LoginUsuario");
            } else {
                throw new RuntimeException("CPF incorreto! **LoginUsuario");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fazer login! **LoginUsuario");
        }
        return jsf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }
}
