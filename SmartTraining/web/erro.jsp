<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%!
String erro = "";
%>

<%
erro = (String)request.getAttribute("erro");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>SmartTraining</title>
    </head>
    <body>
        <h2><%=erro%></h2>
    </body>
</html>
