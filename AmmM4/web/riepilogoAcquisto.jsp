<%-- 
    Document   : riepilogoAcquisto
    Created on : 2-mag-2016, 15.50.06
    Author     : MARCO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA RIEPILOGO ACQUISTO OGGETTO -->
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
					<h2>Hai deciso di acquistare il seguente prodotto: </h2>
                                        <table>
                                            <tr>
                                                <th> Nome Oggetto </th>
                                                <td> ${nomeOggetto}</td>
                                            </tr>
                                            <tr>
                                                <th> Url Oggetto </th>
                                                <td> ${urlOggetto} </td>
                                            </tr>                                            
                                            <tr>
                                                <th> Prezzo Oggetto </th>
                                                <td> ${prezzoOggetto} </td>
                                            </tr>
                                            <tr>
                                                <th> Disponibilità Oggetto </th>
                                                <td> ${pezziDispOggetto} </td>
                                            </tr>
                                            
                                        </table>
                                            <form method="get" action="acquistoOggetto.html">
                                                <input name = "prezzoOggetto" type="hidden" value="${prezzoOggetto}"/>
                                                <input name = "id_oggetto" type="hidden" value="${id_oggetto}"/>                                                
                                                <input type="submit" value="Continua" name="Submit_2"/>
                                            </form>
                                            
					<button> <a href="cliente.html">Annulla</a></button>
				</div>
			</div> 
                        
		</div>		
    </body>
</html>

