<%-- 
    Document   : venditaConfermata
    Created on : 18-mag-2016, 11.02.23
    Author     : MARCO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA DI CONFERMA PER LA VENDITA DI UN OGGETTO -->
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="MarcoSanna">
		<meta name="description" content="Area di log in per l'utente">
		<meta name="keywords" content="autoricambi, login, username, password">  
		<link href="./mystyle.css" rel="stylesheet" type="text/css">		
    </head>
    
        <body> 
        
		<div class="page">
			<!-- HEADER  -->
			<header> </header>
			<%@ include file="barra-navigazione.jsp" %>
		
			<!-- CONTENT -->
			<div class="content">
				<!-- CONTENITORE DEL CONTENUTO DI LOGIN -->
                                
				<div id="contenitore-contenuto-login">                                      
                                      
                                    <p> Oggetto inserito correttamente in vendita! </p>
                                    <button> <a href="venditore.html">Torna alla pagina venditore</a></button>
				</div>
			</div> 
                        
		</div>		
    </body>
</html>
