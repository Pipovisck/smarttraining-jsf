package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterInstrutorProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverUsuario implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "RemoverUsuario.jsp";

            IManterUsuario manterAluno = new ManterAlunoProxy();
            IManterUsuario manterInstrutor = new ManterInstrutorProxy();

            ArrayList<Usuario> listaAlunos = manterAluno.pesquisarTodos();
            ArrayList<Usuario> listaInstrutores = manterInstrutor.pesquisarTodos();
            ArrayList<Usuario> listaUsuarios = new ArrayList<>();

            listaUsuarios.addAll(listaAlunos);
            listaUsuarios.addAll(listaInstrutores);
            
            request.setAttribute("usuarios", listaUsuarios);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover usuario!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
