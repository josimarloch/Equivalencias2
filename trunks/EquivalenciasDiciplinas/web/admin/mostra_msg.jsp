<%-- 
    Document   : mostra_msg
    Created on : 14/05/2013, 00:24:46
    Author     : josimar
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4>Mensagem do sistema:</h4>
         <c:if test="${param.mensagem_ok!=null}">
                    <h3 class="alert-success"> <c:out value="${param.mensagem_ok}" /></h3>
            </c:if>
            <c:if test="${param.mensagem_erro!=null}">
                    <h3 class="alert-danger"> <c:out value="${param.mensagem_erro}" /></h3>
            </c:if>
    </body>
</html>
