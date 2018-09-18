package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.proxy.ManterAparelhoProxy;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class CadastrarAparelho implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "TelaInicialInstrutor.jsp";
        try {
            String nome = request.getParameter("nome");
            int numero = Integer.parseInt(request.getParameter("numero"));

            IManterAparelho manterAparelho = new ManterAparelhoProxy();

            if (manterAparelho.pesquisar(numero) != null) {
                String erro = "Numero de aparelho ja registrado";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
                return jsp;
            }
            Aparelho aparelho = new Aparelho(numero, nome);
            manterAparelho.cadastrar(aparelho);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao cadastrar aparelho";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
            return jsp;
        }
        return jsp;
    }
}
