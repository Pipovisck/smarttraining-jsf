<%--
    Document   : MostrarFicha
    Created on : 30/07/2018, 16:39:43
    Author     : Felipe/Matheus
--%>

<%@page import="br.cefetmg.inf.model.domain.Atividade"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha" %>
<%@page import="br.cefetmg.inf.model.domain.Treino" %>
<%@page import="br.cefetmg.inf.model.domain.Exercicio" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Ficha</title>
    </head>
    <body>
        <div>
            <br>
            <h2>Ficha</h2>
            <br>

            <%
                Ficha ficha = new Ficha();

                ficha =(Ficha) request.getAttribute("ficha");

                for (Treino treino : ficha.getListaTreino()) {
            %>

            <h3>Treino <%= treino.getNroTreino() %> </h3>

            <table class="table table-hover">
                <tr>
                    <th>Aparelho</th>
                    <th>Exercício</th>
                    <th>Séries</th>
                    <th>Repetições</th>
                    <th>Peso</th>
                </tr>

            <%
                    for (Atividade atividade : treino.getAtividades()) {
            %>
                <tr>
                    <td> <%= atividade.getAparelhoExercicio() %> </td>
                    <td> <%= atividade.getAparelhoExercicio().getExercicio() %> </td>
                    <td> <%= atividade.getNroSeries() %></td>
                    <td> <%= atividade.getNroRepeticoes() %></td>
                    <td> <%= atividade.getQtdPeso() %></td>
                </tr>
            <%
                   }
                }
            %>
            </table>
            <button class="btn btn-primary voltar">Voltar</button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
