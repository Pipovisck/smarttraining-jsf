<%-- 
    Document   : TelaInicialAluno
    Created on : 05/08/2018, 13:09:02
    Author     : mathe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <title>Aluno Inicio</title>
</head>
<body>
    <div class="container">
        <%String cpf = (String)((Usuario)request.getSession().getAttribute("usuario")).getCodCpf();%>
        <a href="/servletweb?acao=MostrarUsuario&codCpfUsuario=<%=cpf%>"
            class="btn btn-primary">Perfil</a><br>
            
        <a href="/servletweb?acao=TelaAlterarUsuario&codCpfUsuario=<%=cpf%>"
           class="btn btn-primary">Alterar dados</a><br>
        
        <a href="/servletweb?acao=ListarAvaliacoes&codCpfAluno=<%=cpf%>"
           class="btn btn-primary">Ver Avaliações</a><br>
        
        <a href="/servletweb?acao=ListarFichas&codCpfAluno=<%=cpf%>"
           class="btn btn-primary">Ver Fichas</a><br>
        
        <a href="/servletweb?acao=ListarExercicios" class="btn btn-primary">Ver exercícios</a>
    </div>
</body>
</html>
