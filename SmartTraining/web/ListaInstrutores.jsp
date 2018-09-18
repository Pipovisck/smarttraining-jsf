<%-- 
    Document   : ListaInstrutores
    Created on : 16/08/2018, 12:51:57
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        
        <title>Lista de instrutores</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Usuarios:</h2>
            <br>
            <ul>
                <%
                    List<Instrutor> listaUsuarios = (List) request.getAttribute("instrutores");
                    Instrutor instrutor = new Instrutor();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        instrutor = listaUsuarios.get(i);
                %>
                <li>
                    <h4><%= instrutor.getNomUsuario()%></h4>
                    <a href="/servletweb?acao=MostrarUsuario&codCpfUsuario=<%=instrutor.getCodCpf()%>" class="btn btn-primary"> 
                        Ver 
                    </a>
                    <br>
                </li>
                <%
                    }
                %>
            </ul>
            <button class="btn btn-primary voltar"> Voltar </button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
