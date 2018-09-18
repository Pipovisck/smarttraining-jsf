package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;

public class FazerLogin implements Controller{

    @Override
    public  String execute(HttpServletRequest request) {
        String jsp;
        HttpSession sessao = request.getSession();
        try{

            String cpf =  request.getParameter("cpf").replaceAll("[^0-9]", "");
            String senha = request.getParameter("senha");

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();
            Usuario aluno = manterAluno.pesquisarPorCpf(cpf);
            Usuario instrutor = manterInstrutor.pesquisarPorCpf(cpf);
            
            if(aluno != null && aluno.getTxtSenha().equals(senha)){
                sessao.setAttribute("usuario", aluno);
                jsp="TelaInicialAluno.jsp";
            }
            else if(instrutor!= null && instrutor.getTxtSenha().equals(senha)){
                sessao.setAttribute("usuario", instrutor);
                jsp="TelaInicialInstrutor.jsp";
            }
            else if((aluno != null && !aluno.getTxtSenha().equals(senha)) || 
                    (instrutor!=null && !instrutor.getTxtSenha().equals(senha))){
                String erro = "Senha Incorreta";
                jsp="erro.jsp";
                request.setAttribute("erro", erro);
            }
            else{
                String erro="CPF incorreto";
                jsp="erro.jsp";
                request.setAttribute("erro", erro);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao fazer login!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
