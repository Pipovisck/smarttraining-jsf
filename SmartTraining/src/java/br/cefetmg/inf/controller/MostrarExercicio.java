package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class MostrarExercicio implements Controller{

    @Override
    public String execute(HttpServletRequest request) {
        String jsp="MostrarExercicio.jsp";
        try {
            int codExercicio = Integer.parseInt(request.getParameter("codExercicio"));
            IManterExercicio manterExercicio = new ManterExercicioProxy();
            Exercicio exercicio = manterExercicio.pesquisarPorCodigo(codExercicio);
            if(exercicio!=null){
                request.setAttribute("exercicio", exercicio);
            }
            else{
                String erro = "Erro ao carregar exercicio!";
                jsp = "erro.jsp";
                request.setAttribute("erro", erro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao carregar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
