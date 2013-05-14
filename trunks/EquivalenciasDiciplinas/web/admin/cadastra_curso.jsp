<%-- 
    Document   : cadastra_curso
    Created on : 03/05/2013, 19:50:55
    Author     : carlos
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
        <form class="form-horizontal" action="PersistenceManager" method="post" accept-charset="UTF-8">
              <c:if test="${param.mensagem_ok!=null}">
                    <h3 class="alert-success"> <c:out value="${param.mensagem_ok}" /></h3>
            </c:if>
            <c:if test="${param.mensagem_erro!=null}">
                    <h3 class="alert-danger"> <c:out value="${param.mensagem_erro}" /></h3>
            </c:if>
            <h3>Cadastro de Curso</h3>
            <div class="control-group">
                <label class="control-label" for="Nome" >Nome</label>
                <div class="controls">
                    <input type="text" id="Nome" name="nome" placeholder="Nome">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="Codigo">Codigo</label>
                <div class="controls">
                    <input type="text" id="Codigo" name="codigo" placeholder="Codigo">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="ok" value="cadastra_curso"/>
                    <button type="submit" class="btn">Cadastrar</button>
                </div>
            </div>
        </form>
    </body>
</html>