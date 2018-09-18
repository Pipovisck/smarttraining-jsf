<%-- 
    Document   : ListaUsuarios
    Created on : 30/07/2018, 14:16:31
    Author     : Matheus
--%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <style>
            ul{
                list-style-type: none;
            }
        </style>

        <title>Lista de Alunos</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Alunos:</h2>
            <br>
            <ul>
                <%
                    List<Usuario> listaUsuarios = (List) request.getAttribute("alunos");
                    Usuario aluno = new Usuario();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        aluno = listaUsuarios.get(i);
                %>
                <li>
                    <h4><%= aluno.getNomUsuario()%></h4>
                    <a href="/servletweb?acao=MostrarUsuario&codCpfUsuario=<%=aluno.getCodCpf()%>" class="btn btn-primary"> 
                        Ver 
                    </a>
                    <a href="/servletweb?acao=ListarAvaliacoes&codCpfAluno=<%= aluno.getCodCpf()%>" class="btn btn-primary">
                        Ver Avaliacoes
                    </a>
                    <a href="/servletweb?acao=ListarFichas&codCpfAluno=<%= aluno.getCodCpf()%>" class="btn btn-primary">
                        Ver Fichas
                    </a>
                    <a href="/servletweb?acao=TelaCadastrarAvaliacao&codCpfAluno=<%= aluno.getCodCpf()%>" class="btn btn-primary">
                        Cadastrar Avaliacao
                    </a>
                    <br><br>
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

