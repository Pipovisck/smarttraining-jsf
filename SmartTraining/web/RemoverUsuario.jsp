<%-- 
    Document   : RemoverAluno
    Created on : 30/07/2018, 19:15:19
    Author     : Matheus
--%>

<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <title>Remover Usuario</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Remover usuario</h2>
            <form action="servletweb" method="delete">
                <input type="hidden" name="acao" value="RemoverUsuario">

                <h4>Selecione o usuário que deseja remover:</h4>
                <select name="usuario">
                    <%
                        Instrutor usuarioAtual = (Instrutor) request.getSession().getAttribute("usuario");
                        Usuario usuario = new Usuario();
                        List<Usuario> listaUsuarios = (List) request.getAttribute("usuarios");
                        for (int i = 0; i < listaUsuarios.size(); i++) {
                            usuario = listaUsuarios.get(i);
                            if (usuario.getCodCpf().equals(usuarioAtual.getCodCpf())) {
                                if (i == listaUsuarios.size() - 1) {
                                    break;
                                }
                                i++;
                                usuario = listaUsuarios.get(i);
                            }
                    %>

                    <option value=" <%= usuario.getCodCpf()%> "><%= usuario.getNomUsuario()%></option>

                    <%
                        }
                    %>
                </select>

                <input type="submit" class="btn btn-primary" value="Remover">
            </form>
            <button class="btn btn-primary voltar">Voltar</button>
        </div>

        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>