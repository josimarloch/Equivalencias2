<%-- 
    Document   : visualiza_pedido
    Created on : 14/05/2013, 14:44:17
    Author     : josimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="dao" class="Daos.RequisicaoEquivalenciaDao"  scope="request" />
<jsp:useBean id="df" class="controler.DateFormat" scope="request"/>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="pedido" value="${dao.obterPorId(param.pedido_id)}"/>
        <h4>Detalhes do pedido de equivalencia para a disciplina <c:out value="${pedido.diciplinaRequerida.nome}" /></h4>
        <dl>
            <dt>Detalhes de ementa e instituição da disciplina cursada: </dt>
            <dd><c:out value="${pedido.ementa}" /></dd>
        </dl>
        <dl>
            <dt>Status atual do pedido:</dt>
            <dd><c:out value="${pedido.status}" /></dd>
            <c:if test="${pedido.status eq 'ACEITO'}">
                
            <dd>Finalizado em: <c:out value="${df.format(pedido.dataFinal.time)}" /></dd>
            </c:if>
        </dl>
        <dl>
            <dt>RA do requisitante:</dt>
            <dd><c:out value="${pedido.alunoRa}" /></dd>
        </dl>
        <dl>
            <dt>histórico do pedido:</dt>
            <dd>Criado em: <c:out value="${df.format(pedido.dataInicio.time)}" /></dd>
            <dd>Alteracões de Status</dd>
            <dd><ul>
                    <c:forEach items="${pedido.historico}" var="historico" varStatus="status">
                        <li> 
                            <c:out value="${historico.status}" />               
                            <c:out value="${df.format(historico.dataModificacao.time)}" /> 
                        </li>              
                    </c:forEach>
                </ul>
            </dd>
        </dl>
        <br/>
        <c:if test="${pedido.status eq 'EM_ANDAMENTO'}">
        <a href="EquivalenciaManager?ok=deferir&pedido_id=${pedido.id}"><button class="btn btn-primary" >Deferir Pedido</button></a>
        <button class="btn btn-warning" onclick="abrirPag('indefere.jsp?pedido_id=${pedido.id}')">Indeferir Pedido</button>
        <a href="index.jsp"> <button class="btn btn-danger" >Cancelar e voltar para inicio</button></a>
        </c:if>
        <c:if test="${pedido.status != 'EM_ANDAMENTO'}">
            <h3 class="alert-success">Pedido de equivalencia já finalizado.</h3>
        </c:if>
    </body>
</html>

