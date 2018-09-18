package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class TelaRemoverExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        try {
            jsp = "RemoverExercicio.jsp";

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            ArrayList<Exercicio> listaExercicios = manterExercicio.pesquisarTodos();

            if (listaExercicios==null)
                jsp = "erro.jsp";
            
            request.setAttribute("exercicios", listaExercicios);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }

}
