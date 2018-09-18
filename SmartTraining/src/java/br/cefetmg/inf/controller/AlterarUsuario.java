package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;

public class AlterarUsuario implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            IManterUsuario manterUsuario;

            String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
            Usuario usuario = new Usuario();

            usuario.setCodCpf(cpf);
            usuario.setDatNascimento(LocalDate.parse(request.getParameter("datNasc")));
            usuario.setDesEmail(request.getParameter("email"));
            usuario.setIdtTipoUsuario(((Usuario) request.getSession().getAttribute("usuario")).getIdtTipoUsuario());
            usuario.setNomUsuario(request.getParameter("nome"));
            usuario.setTxtSenha(request.getParameter("senha"));

            if (usuario.getIdtTipoUsuario() == 'I') {
                manterUsuario = new ManterInstrutorProxy();
            } else {
                manterUsuario = new ManterAlunoProxy();
            }

            manterUsuario.alterar(usuario);
            jsp = "TelaInicialAluno.jsp";
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Ocorreu erro ao tentar alterar os dados do usuario!";
            request.setAttribute("erro", erro);
            jsp = "/erro.jsp";
        }
        return jsp;
    }
}
