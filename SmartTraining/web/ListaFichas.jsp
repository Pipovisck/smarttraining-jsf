<%--
    Document   : ListaFichas
    Created on : 30/07/2018, 15:27:31
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha" %>
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
        
        <input type = "hidden" name = "codCpfAluno" value="
               <%= usuario.getCodCpf() %>" 
        />
        
        <title>Lista de Fichas</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Fichas</h2>
            <br>

            <ul class="list-group">
                <%
                    Ficha ficha = new Ficha();
                    List <Ficha> listaFichas = (List) request.getAttribute("fichas");

                    for(int i=0; i<listaFichas.size(); i++){
                        ficha = listaFichas.get(i);
                %>
                <li class="list-group-item">
                    <a href="/controller/servletweb?acao=MostrarFicha&nroFicha=<%= ficha.getNroFicha() %>"> 
                        Data: <%= ficha.getDataFicha() %> 
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
