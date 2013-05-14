<%-- 
    Document   : login
    Created on : 25/04/2013, 19:53:53
    Author     : josimar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
        <link href="css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <form class="form-horizontal" action="LoginManager" method="post">
             <c:if test="${param.mensagem_ok!=null}">
                    <h3 class="alert-success"> <c:out value="${param.mensagem_ok}" /></h3>
            </c:if>
            <c:if test="${param.mensagem_erro!=null}">
                    <h3 class="alert-danger"> <c:out value="${param.mensagem_erro}" /></h3>
            </c:if>
            <h3>Login</h3>
            <div class="control-group">
                <label class="control-label" for="inputEmail">Login</label>
                <div class="controls">
                    <input type="text" name="login" id="inputEmail" placeholder="Email ou RA">
                </div>
            </div>
            <div class="control-group">
                    <label class="control-label" for="inputPassword">Password</label>
                    <div class="controls">
                        <input type="password" id="inputPassword" placeholder="Password" name="senha">
                </div>
            </div>
            <div class="control-group">
                    <label class="control-label" for="professor"></label>
                    <div class="controls">
                       <label class="checkbox">
                           <input type="checkbox" name="professor" id="professor"> Sou um Professor.
                </label>
                </div>
            </div>
            
            <div class="control-group">
                <div class="controls">
                    <input type="hidden" value="login" name="ok"/>
                    <button type="submit" class="btn">Sign in</button>
                </div>
            </div>
        </form>
    </body>
</html>
