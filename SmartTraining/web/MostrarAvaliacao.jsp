<%--
    Document   : MostarAvaliacao
    Created on : 29/07/2018, 00:24:47
    Author     : Felipe
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Objetivo"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Avaliação</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Avaliação</h2>
            <br>

            <table class="table table-hover">
                <%
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao = (Avaliacao) request.getAttribute("avaliacao");
                %>

                <tr>
                    <td>Peso:</td>
                    <td> <%=avaliacao.getPeso()%> </td>
                </tr>
                <tr>
                    <td>Percentual de gordura:</td>
                    <td> <%=avaliacao.getPercentualGordura()%> </td>
                </tr>
                <tr>
                    <td>Massa gorda:</td>
                    <td> <%=avaliacao.getMassaGorda()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do pescoço:</td>
                    <td> <%=avaliacao.getTamanhoPescoco()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do ombro:</td>
                    <td> <%=avaliacao.getTamanhoOmbro()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do torax:</td>
                    <td> <%=avaliacao.getTamanhoTorax()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do abdômen:</td>
                    <td> <%=avaliacao.getTamanhoAbdomen()%> </td>
                </tr>
                <tr>
                    <td>Tamanho da cintura:</td>
                    <td> <%=avaliacao.getTamanhoCintura()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do quadril:</td>
                    <td> <%=avaliacao.getTamanhoQuadril()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do braço esquerdo:</td>
                    <td> <%=avaliacao.getTamanhoBracoEsquerdo()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do braço direito:</td>
                    <td> <%=avaliacao.getTamanhoBracoDireito()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do antebraço esquerdo:</td>
                    <td> <%=avaliacao.getTamanhoAntebracoEsquerdo()%> </td>
                </tr>
                <tr>
                    <td>Tamanho do antebraço direito:</td>
                    <td> <%=avaliacao.getTamanhoAntebracoDireito()%> </td>
                </tr>
                <tr>
                    <td>Tamanho da coxa esquerda:</td>
                    <td> <%=avaliacao.getTamanhoCoxaEsquerda()%> </td>
                </tr>
                <tr>
                    <td>Tamanho da coxa direita:</td>
                    <td> <%=avaliacao.getTamanhoCoxaDireita()%> </td>
                </tr>
                <tr>
                    <td>Tamanho da panturrilha esquerda:</td>
                    <td> <%=avaliacao.getTamanhoPanturrilhaEsquerda()%> </td>
                </tr>
                <tr>
                    <td>Tamanho da panturrilha direita:</td>
                    <td> <%=avaliacao.getTamanhoPanturrilhaDireita()%> </td>
                </tr>
                <tr>
                    <td>Objetivos</td>
                    <td>
                            <%
                                ArrayList<Objetivo> listaObjetivos = avaliacao.getListaObjetivos();
                                Objetivo objetivo = new Objetivo();

                                for (int i = 0; i < listaObjetivos.size(); i++) {
                                    objetivo = listaObjetivos.get(i);
                            %>
                            <label><%=objetivo.getNomObjetivo()%></label>
                            <br>
                            <%
                                }
                            %>
                    </td>
                </tr>
            </table>
            <button class="btn btn-primary voltar">Voltar</button>
        </div>
        <script src="/JavaScript/Voltar.js"></script>
    </body>
</html>
