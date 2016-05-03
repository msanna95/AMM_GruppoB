<%-- 
    Document   : paginaErrore
    Created on : 1-mag-2016, 19.33.51
    Author     : MARCO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
					<h2>Errore: accesso pagina non autorizzato!</h2>
					
				</div>
			</div> 
                        
		</div>		
    </body>
</html>
