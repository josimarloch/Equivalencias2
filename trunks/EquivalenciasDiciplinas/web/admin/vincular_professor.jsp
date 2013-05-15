<%-- 
    Document   : vincular_professor
    Created on : 07/05/2013, 19:14:14
    Author     : josimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="ddao" class="Daos.DisciplinaDao" scope="request" /> 
<jsp:useBean id="pdao" class="Daos.ProfessorDao" scope="request" /> 
 <c:set var="disciplina" value="${ddao.obterPorId(param.disciplina_id)}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-horizontal" action="PersistenceManager" method="post" accept-charset="ISO-8859-1" >
            <c:if test="${param.mensagem_ok!=null}">
                    <h3 class="alert-success"> <c:out value="${param.mensagem_ok}" /></h3>
            </c:if>
            <c:if test="${param.mensagem_erro!=null}">
                    <h3 class="alert-danger"> <c:out value="${param.mensagem_erro}" /></h3>
            </c:if>
                    <h3>Vincular a disciplina de <c:out value="${disciplina.nome}" /> com o Professor:</h3>
       
            <div class="control-group">
                <label class="control-label" for="professor" >Vincular com</label>
                <div class="controls">
                    <select id="professor" name="professor_id">
                        <option value="0">
                            Escolha o Professor            
                        </option>  
                        <c:forEach items="${pdao.listar()}" var="professor" varStatus="status">
                            <option value="  <c:out value="${professor.id}" />       ">
                                <c:out value="${professor.email}" />               
                            </option>  
                        </c:forEach>
                    </select>
                    <input type="hidden" name="ok" value="vincular_professor"/>
                    <input type="hidden" name="disciplina_id" value="${param.disciplina_id}"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" name="ok" value="cadastra_disciplina"/>
                    <button type="submit" class="btn">Vincular</button>
                </div>
            </div>
        </form>
    </body>
</html>
