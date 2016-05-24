<%-- 
    Document   : login
    Created on : 28-apr-2016, 11.01.39
    Author     : MARCO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA LOGIN -->
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
        
            <c:if test="${loggedInCliente == true}"> 
                <c:redirect url="cliente.html"/>
            </c:if> 
            <c:if test="${loggedInVenditore == true}"> 
                <c:redirect url="venditore.html"/>
            </c:if> 
		<div class="page">
			<!-- HEADER  -->
			<header> </header>
			<%@ include file="barra-navigazione.jsp" %>
		
			<!-- CONTENT -->
			<div class="content">
				<!-- CONTENITORE DEL CONTENUTO DI LOGIN -->
                                
				<div id="contenitore-contenuto-login">
                                    <c:if test="${errore}">
                                        <p> Errore nelle credenziali </p>
                                    </c:if>  
					<h2>Login</h2>
					<form method="post" action="login.html">
						<label for="username">Username</label>
						<input name="username" id="username" type="text"/> 
						<label for="password">Password</label>
						<input name="password" id="password" type="password"/>										
						
						<label></label> <!-- LASCIO UN LABEL VUOTO PER MANDARE A CAPO IL PULSANTE INPUT -->
					
						<input type="submit" value="Login" name="Submit"/>
					</form>
				</div>
			</div>  
                        
		</div>		
    </body>
</html>
