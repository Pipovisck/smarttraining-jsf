<%-- 
    Document   : CadastrarAparelho
    Created on : 19/08/2018, 13:33:49
    Author     : gabriel
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar Aparelho</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
            <br>
            <h2>SmartTraining - Cadastrar Aparelho</h2>
            <br>
            <form action="servletweb" method="post">
                <input type="hidden" name="acao" value="CadastrarAparelho" id="acao">

                <label for="numero">Numero do aparelho: </label>
                <input type="text" name="numero" class="form-control">
                <br>
                
                <label for="nome">Nome: </label>
                <input type="text" name="nome" class="form-control">
                <br>

                <input type="submit" name="Cadastrar" class="btn btn-primary" value="Cadastrar">
            </form>
            <button class="btn btn-primary voltar">Voltar</button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>