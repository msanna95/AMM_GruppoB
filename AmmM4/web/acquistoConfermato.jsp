<%-- 
    Document   : acquistoConfermato
    Created on : 2-mag-2016, 19.21.28
    Author     : MARCO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acquisto Confermato</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="MarcoSanna">
		<meta name="description" content="Area di log in per l'utente">
		<meta name="keywords" content="autoricambi, acquisto, conferma">  
		<link href="./mystyle.css" rel="stylesheet" type="text/css">		
    </head>
    
    <!-- JSP PER LA CONFERMA O MENO DELL'AVVENUTO ACQUISTO -->
    <body> 
        <div class="page">
            <!-- HEADER  -->
            <header> </header>
            <%@ include file="barra-navigazione.jsp" %>

            <!-- CONTENT -->
            <div class="content">
                    <!-- CONTENITORE DEL CONTENUTO DI LOGIN -->

                    <div id="contenitore-contenuto-login">                                      
                        <c:if test="${flag == 1}"> Acquisto effettuato con successo!</c:if>
                        <c:if test="${flag == 0}"> <p>Saldo insufficiente!</p>
                        <p> Effettua una ricarica per aumentare il tuo saldo! </p> </c:if>  
                    </div>
            </div> 

        </div>		
    </body>
</html>