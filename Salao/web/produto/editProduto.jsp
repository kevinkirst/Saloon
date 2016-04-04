<%-- 
    Document   : editProduto
    Created on : 31/03/2016, 21:28:26
    Author     : Gustavo
--%>

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
            Produto p = (Produto) request.getAttribute("produto");
        %>
        <h1></h1>
        <form action="servlet" method="get" >
            <input type="hidden" name="acao" value="salvarProduto" />
            <input type="hidden" name="id" value="<%=p.getId()%>" />
            <input type="text" name="campoNome" value="<%=p.getNome()%>" />
            <br />
            <input type="text" name="campoFornecedor" value="<%=p.getFornecedor()%>" />    
            <br />
            <input type="text" name="campoQuantidade" value="<%=p.getQtde()%>" />    
            <br />
            <input type="text" name="campoDtCompra" value="<%=p.getDtCompra()%>" />    
            <br />
            <input type="text" name="campoValorCompra" value="<%=p.getValorCompra()%>" />    
            <br />
            <input type="text" name="campoValorVenda" value="<%=p.getValorVenda()%>" />    
            <br />            
            <input type="submit" value="Submeter" />
            <a href="../index.html">Página Inicial</a>
            </form>
    </body>
</html>
