<%--
    Document   : ListaExercicios
    Created on : 30/07/2018, 12:30:53
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Musculo" %>
<%@page import="br.cefetmg.inf.model.domain.Exercicio" %>
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

        <title>Exercícios</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Exercícios</h2>
            <br>

            <ul class="list-group">
                <%
                    Musculo musculo = new Musculo();
                    Exercicio exercicio = new Exercicio();
                    List<Musculo> listaMusculos = (List) request.getAttribute("musculos");

                    for (int i = 0; i < listaMusculos.size(); i++) {
                        musculo = listaMusculos.get(i);
                %>
                <li class="list-group-item"> <h3> <%= musculo.getNomMusculo()%> </h3> </li>
                <li>
                    <ul class="list-group">
                        <%
                            List<Exercicio> listaExercicios;
                            listaExercicios = musculo.getListaExercicios();

                            for (int j = 0; j < listaExercicios.size(); j++) {
                                exercicio = listaExercicios.get(j);
                        %>
                        <li class="list-group-item"> 
                            <h4><%= exercicio.getNomeExercicio()%></h4>
                            <a href="/servletweb?acao=MostrarExercicio&codExercicio=<%= exercicio.getCodExercicio()%>">
                                Ver 
                            </a>
                            <a href="/servletweb?acao=TelaAlterarExercicio&codExercicio=<%= exercicio.getCodExercicio()%>"> 
                                Alterar 
                            </a>
                        </li>
                        <%
                            }
                        %>
                    </ul>
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
