<%-- 
    Document   : TelaInicialAluno
    Created on : 05/08/2018, 13:09:02
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <title>Instrutor Inicio</title>
</head>
<body>
    <div class="container">
        <a class="btn btn-primary" href="/servletweb?acao=ListarExercicios">
            Listar Exercicios
        </a><br>
        <a class="btn btn-primary" href="/servletweb?acao=TelaCadastrarExercicio">
            Cadastrar Exercicio
        </a><br>
        <a class="btn btn-primary" href="/servletweb?acao=TelaRemoverExercicio">
            Remover Exercicio
        </a><br>
        <a class="btn btn-primary" href="/servletweb?acao=ListarAlunos">
            Listar Alunos
        </a><br>
        <a class="btn btn-primary" href="/servletweb?acao=ListarInstrutores">
            Listar Instrutores
        </a><br>
        <a class="btn btn-primary" href="/servletweb?acao=TelaRemoverUsuario">
            Remover Usuario
        </a><br>
        <a class="btn btn-primary" href="/CadastrarAparelho.jsp">
            Cadastrar Aparelho
        </a>
    </div>
</body>
</html>
