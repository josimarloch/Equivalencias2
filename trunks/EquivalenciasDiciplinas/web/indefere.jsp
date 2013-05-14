<%-- 
    Document   : indefere
    Created on : 14/05/2013, 19:05:36
    Author     : josimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form class="form-horizontal" action="EquivalenciaManager" method="post" accept-charset="ISO-8859-1" >
            <c:if test="${param.mensagem_ok!=null}">
                    <h3 class="alert-success"> <c:out value="${param.mensagem_ok}" /></h3>
            </c:if>
            <c:if test="${param.mensagem_erro!=null}">
                    <h3 class="alert-danger"> <c:out value="${param.mensagem_erro}" /></h3>
            </c:if>
            <h3>Indeferir pedido de equivalencia</h3>
           
            <div class="control-group">
                <label class="control-label" for="ementa" >Motivo do Indeferimento.</label>
                <div class="controls">
                    <textarea rows="4" name="ementa" id="ementa"></textarea>
                    <input type="hidden" name="pedido_id" value="${param.pedido_id}"/>
                    <input type="hidden" name="ok" value="indeferir"/>
                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="ok" value="cadastra_disciplina"/>
                    <button type="submit" class="btn-warning">Indeferir</button>
                </div>
            </div>
        </form>
    </body>
</html>
