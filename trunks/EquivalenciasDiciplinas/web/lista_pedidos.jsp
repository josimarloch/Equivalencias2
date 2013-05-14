<%-- 
    Document   : lista_pedidos
    Created on : 14/05/2013, 00:41:47
    Author     : josimar
--%>

<%@page import="Daos.RequisicaoEquivalenciaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dao" class="Daos.RequisicaoEquivalenciaDao"  scope="request" /><%// session.setAttribute("pedidos", new RequisicaoEquivalenciaDao().listaPorLogin(login)); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Os meu pedidos de equivalencia</h4>
        <table class="table table-striped">
            <tr> 
                <th>Disciplina</th>
                <th>Status Atual</th>
                <th>#</th>
            </tr>
            <c:forEach items="${dao.listaPorLogin(usuario.nome)}" var="p" varStatus="status">
                <tr>
                    <td>
                        <c:out value="${p.diciplinaRequerida.nome}" />               
                    </td>

                    <td>
                        <c:out value="${p.status}" />               
                    </td>
                   
                    <td>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
