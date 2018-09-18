<%-- 
    Document   : AlterarUsuario
    Created on : 07/08/2018, 15:56:20
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Alterar usuário</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>SmartTraining - Alterar dados</h2>
            <br>
            <form action="servletweb" method="post">
                <input type="hidden" name="acao" value="AlterarUsuario">
                
                <%
                    Usuario usuario = (Usuario) request.getAttribute("usuario");
                %>

                <label for="nome">Nome: </label>
                <input type="text" name="nome" class="form-control" value="<%= usuario.getNomUsuario() %>">
                <br>

                <label for="senha">Senha:</label>
                <input type="password" name="senha" class="form-control">
                <br>

                <label for="senhaRepetida">Repita a senha:</label>
                <input type="password" name="senhaRepetida" class="form-control">
                <br>

                <label for="cpf">CPF: </label>
                <input type="text" name="cpf" maxlength="14"  value="<%= usuario.getCodCpf() %>" OnKeyPress="formatar('###.###.###-##', this)" class="form-control">
                <br>

                <label for="email">Email: </label>
                <input type="email" name="email" class="form-control" value="<%= usuario.getDesEmail() %>">
                <br>

                <label for="datNasc">Data de Nascimento: </label>
                <input type="date" name="datNasc" class="form-control" value="<%=usuario.getDatNascimento()%>">
                <br>

                <input type="submit" name="Alterar" class="btn btn-primary" value="Alterar">
            </form>
            <button class="btn btn-primary voltar">Voltar</button>
	</div>
                
        <script>
		function formatar(mascara, documento){
		  var i = documento.value.length;
		  var saida = mascara.substring(0,1);
		  var texto = mascara.substring(i)
		  
		  if (texto.substring(0,1) != saida){
		            documento.value += texto.substring(0,1);
		  }
		  
		}
	</script>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
