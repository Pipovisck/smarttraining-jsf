<%--
    Document   : ListaAvaliacoes
    Created on : 28/07/2018, 23:42:46
    Author     : Felipe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <style>
            ul{
                list-style-type: none;
            }
        </style>
        
        <%
            Usuario usuario = (Usuario) request.getAttribute("aluno");
        %>
        
        <title>Lista de Avaliacoes</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Avaliações:</h2>
            <br>

            <ul class="list-group">
                <%
                    ArrayList <Avaliacao> listaAvaliacoes = (ArrayList) request.getAttribute("avaliacoes");
                    Avaliacao avaliacao = new Avaliacao();

                    for (int i = 0; i < listaAvaliacoes.size(); i++) {
                        avaliacao = listaAvaliacoes.get(i);
                %>
                <li class="list-group-item">
                    <%=avaliacao.getDatAvaliacao()%>
                    <a href="servletweb?acao=MostrarAvaliacao&dataAvaliacao=<%= avaliacao.getDatAvaliacao() %>&codCpfAluno=<%=usuario.getCodCpf()%>" class="btn btn-primary"> 
                        Ver avaliação
                    </a>
                    <a href="servletweb?acao=TelaAlterarAvaliacao&dataAvaliacao=<%= avaliacao.getDatAvaliacao() %>&codCpfAluno=<%=usuario.getCodCpf()%>" class="btn btn-primary">
                        Alterar avaliação
                    </a>
                </li>
                <%
                    }
                %>
            </ul>
            <button class="btn btn-primary voltar">Voltar</button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
