package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "login")
@SessionScoped
public class FazerLoginMB {

    public String cpf;
    public String senha;
    public String erro;
    Usuario aluno;
    Usuario instrutor;

    public String execute() {
        String jsp;
        try {

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            Usuario aluno = manterAluno.pesquisarPorCpf(cpf);
            Usuario instrutor = manterInstrutor.pesquisarPorCpf(cpf);

            if (aluno != null && aluno.getTxtSenha().equals(senha)) {
                jsp = "TelaInicialAluno.jsp";
            } else if (instrutor != null && instrutor.getTxtSenha().equals(senha)) {
                jsp = "TelaInicialInstrutor.jsp";
            } else if ((aluno != null && !aluno.getTxtSenha().equals(senha))
                    || (instrutor != null && !instrutor.getTxtSenha().equals(senha))) {
                erro = "Senha Incorreta";
                jsp = "erro";
            } else {
                erro = "CPF incorreto";
                throw new RuntimeException("CPF incorreto! **LoginUsuario");
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            erro = "Erro ao fazer login!";
            jsp = "erro";
        }
        return jsp;
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

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
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
