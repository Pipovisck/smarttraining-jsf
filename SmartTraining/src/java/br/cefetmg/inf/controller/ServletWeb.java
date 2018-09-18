package br.cefetmg.inf.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletWeb extends HttpServlet {

    private String jsp;
    private final HashMap<String, Controller> controllers;

    public ServletWeb() {
        controllers = new HashMap<>();
        controllers.put("Logar", new FazerLogin());
        controllers.put("AlterarAvaliacao", new AlterarAvaliacao());
        controllers.put("AlterarExercicio", new AlterarExercicio());
        controllers.put("AlterarUsuario", new AlterarUsuario());
        controllers.put("CadastrarAluno", new CadastrarAluno());
        controllers.put("CadastrarAparelho", new CadastrarAparelho());
        controllers.put("CadastrarInstrutor", new CadastrarInstrutor());
        controllers.put("CadastrarAvaliacao", new CadastrarAvaliacao());
        controllers.put("CadastrarExercicio", new CadastrarExercicio());
        controllers.put("ListarAvaliacoes", new ListarAvaliacoes());
        controllers.put("ListarExercicios", new ListarExercicios());
        controllers.put("ListarFichas", new ListarFichas());
        controllers.put("ListarAlunos", new ListarAlunos());
        controllers.put("ListarInstrutores", new ListarInstrutores());
        controllers.put("MostrarAvaliacao", new MostrarAvaliacao());
        controllers.put("MostrarExercicio", new MostrarExercicio());
        controllers.put("MostrarUsuario", new MostrarUsuario());
        controllers.put("RemoverExercicio", new RemoverExercicio());
        controllers.put("RemoverUsuario", new RemoverUsuario());
        controllers.put("TelaAlterarAvaliacao", new TelaAlterarAvaliacao());
        controllers.put("TelaAlterarExercicio", new TelaAlterarExercicio());
        controllers.put("TelaAlterarUsuario", new TelaAlterarUsuario());
        controllers.put("TelaCadastrarAvaliacao", new TelaCadastrarAvaliacao());
        controllers.put("TelaCadastrarExercicio", new TelaCadastrarExercicio());
        controllers.put("TelaRemoverExercicio", new TelaRemoverExercicio());
        controllers.put("TelaRemoverUsuario", new TelaRemoverUsuario());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        TipoView tipoView = negotiateContent(request);
        tipoView.visitaRequest(request);
        
        Controller controller = determinaController(request);
        jsp = controller.execute(request);

        //Redirecionando pagina
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }

    private Controller determinaController(HttpServletRequest request) {
        return controllers.get(request.getParameter("acao"));
    }

    private TipoView negotiateContent(HttpServletRequest request) {
        final String cabecalhoAceita = request.getHeader("Accept");

        if (cabecalhoAceita == null) {
            return TipoView.HTML;
        }

        final List<String> tiposAceitos = Arrays.asList(cabecalhoAceita.split(","));

        final int indiceJson = tiposAceitos.indexOf("text/json");
        final int indiceHtml = tiposAceitos.indexOf("text/html");

        if (indiceJson > indiceHtml) {
            return TipoView.JSON;
        }

        return TipoView.HTML;
    }
}
