package br.cefetmg.inf.controller;

import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.proxy.ManterMusculoProxy;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */
public class ListarExercicios implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;

        try {
            IManterMusculo manterMusculo = new ManterMusculoProxy();

            ArrayList<Musculo> listaMusculos = manterMusculo.pesquisarTodos();

            if (listaMusculos != null) {
                request.setAttribute("musculos", listaMusculos);
                jsp = "/ListaExercicios.jsp";
            } else {
                String erro = "Nao existem musculos registrados no banco de dados!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar exercicios!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
