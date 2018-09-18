<%-- 
    Document   : AlterarExercicio
    Created on : 07/08/2018, 15:50:02
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Musculo"%>
<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Aparelho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Alterar Exercício</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Alterar Exercicio</h2>
            <br>

            <%
                Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
            %>

            <form action="servletweb" method="post">
                <input type="hidden" name="acao" value="AlterarExercicio">
                <input type="hidden" name="codExercicio" value="<%=exercicio.getCodExercicio()%>">

                <label for="nomeExercicio">Nome do exercicio:</label><br>
                <input type="text" name="nomeExercicio" class="form-control" value="<%= exercicio.getNomeExercicio()%>"><br>

                <label for="descExercicio">Descrição do novo exercicio:</label><br>
                <textarea name="descExercicio" class="form-control"  rows="5"><%= exercicio.getDescricaoExercicio()%></textarea><br>

                <input type="submit" name="Alterar" class="btn btn-primary" value="Alterar">
            </form>

            <button class="btn btn-primary voltar">Voltar</button>
        </div>

        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
