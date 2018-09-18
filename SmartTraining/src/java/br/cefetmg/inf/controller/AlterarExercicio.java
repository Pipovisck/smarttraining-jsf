package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class AlterarExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            int codExercicio = Integer.parseInt(request.getParameter("codExercicio"));
            String nomeExercicio = request.getParameter("nomeExercicio");
            String descricaoExercicio = request.getParameter("descExercicio");

            Exercicio exercicio = new Exercicio(codExercicio, nomeExercicio, descricaoExercicio);

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            manterExercicio.alterar(exercicio);
            jsp = new ListarExercicios().execute(request);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao alterar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
