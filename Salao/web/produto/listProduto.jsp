<%-- 
    Document   : listProduto
    Created on : 31/03/2016, 21:38:47
    Author     : Gustavo
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Produto> lProduto;
            lProduto = (List<Produto>) request.getAttribute("lista");
            for (Produto umProduto : lProduto) {
        %>
        <%=umProduto.getNome()%> - <a href="servlet?acao=editarProduto&id=<%=umProduto.getId()%>">Editar</a> - <a href="servlet?acao=excluirProduto&id=<%=umProduto.getId()%>">Excluir</a>
        <br />
        <%}%>
        <br />
        <a href="servlet?acao=novoProduto"> Novo Produto </a>
    </body>
</html>