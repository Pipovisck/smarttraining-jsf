package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.proxy.ManterAlunoProxy;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;

public class ListarAvaliacoes implements Controller{
    
    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        
         try {
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();
            IManterUsuario manterUsuario = new ManterAlunoProxy();
            String codCpfAluno = request.getParameter("codCpfAluno").replaceAll("[^0-9]", "");
            Usuario aluno = manterUsuario.pesquisarPorCpf(codCpfAluno);
            ArrayList <Avaliacao> listaAvaliacoes = manterAvaliacao.pesquisarPorAluno(aluno.getCodCpf());
            
            if (!listaAvaliacoes.isEmpty()) {
                request.setAttribute("avaliacoes", listaAvaliacoes);
                request.setAttribute("aluno", aluno);
                jsp = "/ListaAvaliacoes.jsp";
            } else {
                String erro = "Nao existe registro de avaliacoes!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
                return jsp;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao listar avaliacoes!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
