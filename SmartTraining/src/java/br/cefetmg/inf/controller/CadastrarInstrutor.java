package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;

public class CadastrarInstrutor implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/LoginUsuario.jsp";

        try {
            String cpf = request.getParameter("cpf").replaceAll("[^0-9]", "");
            String nome = request.getParameter("nome");
            char idtTipoUsuario = 'I';
            String senha = request.getParameter("senha");
            String email = request.getParameter("email");
            LocalDate dataNascimento = LocalDate.parse(request.getParameter("datNasc"));
            String cref = request.getParameter("cref");

            Instrutor instrutor = new Instrutor();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();

            instrutor.setCodCpf(cpf);
            instrutor.setNomUsuario(nome);
            instrutor.setIdtTipoUsuario(idtTipoUsuario);
            instrutor.setTxtSenha(senha);
            instrutor.setDesEmail(email);
            instrutor.setDatNascimento(dataNascimento);
            instrutor.setCodCREF(cref);

            manterInstrutor.cadastrar(instrutor);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar instrutor!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
