package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.proxy.ManterExercicioProxy;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class CadastrarExercicio implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "TelaInicialInstrutor.jsp";

        try {
            String nomeExercicio = request.getParameter("nomeExercicio");
            String descricaoExercicio = request.getParameter("descExercicio");

            Exercicio exercicio = new Exercicio(0, nomeExercicio, descricaoExercicio);

            String[] codAparelhos = request.getParameterValues("aparelhos");
            String[] codMusculos = request.getParameterValues("musculos");

            IManterExercicio manterExercicio = new ManterExercicioProxy();

            manterExercicio.cadastrar(exercicio, codMusculos);

            exercicio = manterExercicio.pesquisarPorNome(nomeExercicio);

            for (String codAparelho : codAparelhos) {
                manterExercicio.cadastrarAparelhoExercicio(exercicio.getCodExercicio(), Integer.parseInt(codAparelho), "");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar exercicio!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}