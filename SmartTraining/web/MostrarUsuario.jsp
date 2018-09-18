<%-- 
    Document   : MostrarUsuario
    Created on : 05/08/2018, 19:57:38
    Author     : mathe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Perfil</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Perfil</h2>
            <br>
            
            <%
                Usuario usuario = (Usuario) request.getAttribute("usuario");

                String tipoUsuario;
                switch (usuario.getIdtTipoUsuario()) {
                    case 'A':
                        tipoUsuario = "Aluno";
                        break;
                    case 'I':
                        tipoUsuario = "Instrutor";
                        break;
                    default:
                        tipoUsuario = "Coordenador";
                }
            %>

            <table class="table table-hover">
                <tr>
                    <td>Nome:</td>
                    <td><%= usuario.getNomUsuario()%></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><%= usuario.getDesEmail()%></td>
                </tr>
                <tr>
                    <td>Data de nascimento:</td>
                    <td><%= usuario.getDatNascimento()%></td>
                </tr>
                <tr>
                    <td>Função:</td>
                    <td><%= tipoUsuario%></td>
                </tr>

            </table>
                
            <button class="btn btn-primary voltar">Voltar</button>
        
        </div>

        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
