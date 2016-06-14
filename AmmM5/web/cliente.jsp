<%-- 
    Document   : cliente
    Created on : 28-apr-2016, 11.26.25
    Author     : MARCO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<!DOCTYPE html>

<!-- JSP PAGINA INIZIALE CLIENTE -->
<html>
    <head>
        <title>Pagina Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="MarcoSanna">
		<meta name="description" content="Area clienti per gli acquisti">
		<meta name="keywords" content="autoricambi, acquisto articoli">
		<link href="./mystyle.css" rel="stylesheet" type="text/css" media="screen" />
                <script type="text/javascript" src="./js/jquery-2.2.4.min.js"></script>
                <script type="text/javascript" src="./js/filter.js"></script>
    </head>
    
    <body>
         
        <!-- PAGE -->
        <div class="page">
            <!-- HEADER -->
            <header> </header>
            <%@ include file="barra-navigazione.jsp" %>

            <div class="content">
                <div id="contenitore-contenuto-acquisti">

                    <p> Bentornato ${username} </p>
                    <p> Saldo: ${saldoCliente.getSaldo()}
                    <h2> Articoli in vendita </h2>
                    
                    <input type="search" placeholder="Filtra" name="filtra" id="filtra" />

                    <%@ include file="tabellaCliente.jsp" %>                                  

                </div>
            </div>
        </div>
    </body>
</html>
