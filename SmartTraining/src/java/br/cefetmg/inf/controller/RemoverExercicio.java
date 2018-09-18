package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class RemoverExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        
        try {
            int codExercicio = Integer.parseInt(request.getParameter("exercicio").trim());

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            manterExercicio.excluir(codExercicio);
            
            jsp = new TelaRemoverExercicio().execute(request);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao remover exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
