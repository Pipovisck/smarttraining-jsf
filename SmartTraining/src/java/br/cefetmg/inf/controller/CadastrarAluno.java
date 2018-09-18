package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;

public class CadastrarAluno implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/LoginUsuario.jsp";
        try {
            String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
            String nome = request.getParameter("nome");
            char idtTipoUsuario = 'A';
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            LocalDate nascimento = LocalDate.parse(request.getParameter("datNasc"));

            Usuario aluno = new Usuario();

            aluno.setCodCpf(cpf);
            aluno.setNomUsuario(nome);
            aluno.setIdtTipoUsuario(idtTipoUsuario);
            aluno.setTxtSenha(senha);
            aluno.setDesEmail(email);
            aluno.setDatNascimento(nascimento);

            IManterUsuario manterAluno = new ManterAlunoProxy();
            manterAluno.cadastrar(aluno);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar aluno!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
