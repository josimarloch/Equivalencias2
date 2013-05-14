<%-- 
    Document   : index
    Created on : 27/02/2013, 21:52:18
    Author     : josimar
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Equivalência de Disciplinas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="js/instrucao.js" type="text/javascript">

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
        <link href="css/principal.css" rel="stylesheet">
        <script language="javascript" src="js/ajax.js"></script>  
        <script language="javascript" src="js/instrucao.js"></script>

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="../assets/js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="http://twitter.github.io/bootstrap/assets/ico/favicon.png">
    </head>

    <body >

        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="#">Equivalência de Disciplinas</a>
                    <div class="nav-collapse collapse">
                        <p class="navbar-text pull-right">
                            Logged in as <a href="#" class="navbar-link"></a>  
                            <c:if test="${usuario!=null}">
                                <c:out value="${usuario.nome}"/>
                                <a href="LoginManager?ok=logout" title="Sair" > Logout</a> 
                            </c:if>

                        </p>
                        <ul class="nav">
                            <li class="active"><a href="index.jsp">Home</a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3">
                    <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                            <c:if test="${usuario!=null}">
                                <li class="nav-header">Menu</li>
                                <li ><a href="#" onclick="abrirPag('lista_cursos.jsp')">Pedir Equivalencia</a></li>
                                <li ><a href="#" onclick="abrirPag('lista_pedidos.jsp')">Meus Pedidos</a></li>
                               


                            <li class="nav-header">Menu Do Professor</li>
                             <li ><a href="#" onclick="abrirPag('lista_pedidos_professor.jsp')">Pedidos Enviados a mim</a></li>
                              
                            </c:if>

                        </ul>




                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9" id="conteudo"><!--
                  <div class="hero-unit">
                    <h1>Hello, world!</h1>
                    <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
                    <p><a href="#" class="btn btn-primary btn-large">Learn more »</a></p>
                  </div> -->

                </div><!--/span-->
            </div><!--/row-->

            <hr>

            <footer>
                <p>© Company 2013</p>
            </footer>

        </div><!--/.fluid-container-->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap-transition.js"></script>
        <script src="js/bootstrap-alert.js"></script>
        <script src="js/bootstrap-modal.js"></script>
        <script src="js/bootstrap-dropdown.js"></script>
        <script src="js/bootstrap-scrollspy.js"></script>
        <script src="js/bootstrap-tab.js"></script>
        <script src="js/bootstrap-tooltip.js"></script>
        <script src="js/bootstrap-popover.js"></script>
        <script src="js/bootstrap-button.js"></script>
        <script src="js/bootstrap-collapse.js"></script>
        <script src="js/bootstrap-carousel.js"></script>
        <script src="js/bootstrap-typeahead.js"></script>
        <script src="js/ajax.js"></script>  
        <script src="js/instrucao.js"></script> 
        <c:if test="${param.onload!=null}">
            <script>abrirPag('${param.onload}')</script>
        </c:if>
            <c:if test="${usuario == null}">
                <script>abrirPag('login.jsp')</script>
            </c:if>






    </body></html>
