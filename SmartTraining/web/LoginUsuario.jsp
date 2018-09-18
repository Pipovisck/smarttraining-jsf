<!DOCTYPE html>
<html>
<head>
	<title>Smart Training</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br>
		<h2>SmartTraining</h2>
		<br>
                <form action="servletweb" method="post" id="form">
                    <input type="hidden" name="acao" value="Logar" id="acao">
			<label for="codCpf" class="form">CPF: </label>
                        <input type="text" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" class="form-control">
			<br>

			<label for="senha" class="form">Senha:</label>
			<input type="password" name="senha" class="form-control">
			<br>

			<input type="submit" name="login" class="btn btn-primary" value="Login">
                        <a href="CadastrarUsuario.jsp" class="btn btn-primary">Cadastrar</a>
		</form>
	</div>
    <script>
        function formatar(mascara, documento){
            var i = documento.value.length;
            var saida = mascara.substring(0,1);
            var texto = mascara.substring(i);

            if (texto.substring(0,1) !== saida){
                      documento.value += texto.substring(0,1);
            }
		  
	}
    </script>
</body>
</html>