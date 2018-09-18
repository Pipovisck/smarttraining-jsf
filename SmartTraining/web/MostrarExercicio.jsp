<%-- 
    Document   : MostrarExercicio
    Created on : 05/08/2018, 20:31:02
    Author     : mathe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Exercicio</title>
    </head>
    <body>
        <div class="container">
            <br>
            <%
                Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
            %>
            Nome: <%= exercicio.getNomeExercicio()%><br>
            Descrição: <%= exercicio.getDescricaoExercicio()%><br>
            
            <button class="btn btn-primary voltar">Voltar</button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
