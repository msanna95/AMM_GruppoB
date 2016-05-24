<%-- 
    Document   : tabella
    Created on : 28-apr-2016, 12.04.46
    Author     : MARCO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA TABELLA OGGETTI IN VENDITA DEL VENDITORE -->
<!DOCTYPE html>


    <table>
        
        <p>I tuoi oggetti in vendita: </p>
    <c:forEach var="oggetto" items="${listaOggettiVenditore}">
        
        
        <tr>
            <td class="b-table-img" rowspan="4"><img title="${oggetto.getNomeOggetto()}" alt="foto ${oggetto.getNomeOggetto()}" 
                                                 src="${oggetto.getUrlOggetto()}" width="150" height="150"/> </td>
            <td> ${oggetto.getNomeOggetto()} </td>
        </tr>
        <tr>
            <td> ${oggetto.getPezziDisponibili()}x articoli disponibili </td>
        </tr>
        <tr>
            <td> ${oggetto.getPrezzo()} € </td>
        </tr>
        
        <tr>    
            <td>
                <form method="get" action="gestioneOggetto.html">
                    <input name = "id" type="hidden" value="${oggetto.getId()}"/>
                    <input name= "name" type="hidden" value="${oggetto.getNomeOggetto()}"/>
                    <input name= "url" type="hidden" value="${oggetto.getUrlOggetto()}"/>
                    <input name="descr" type="hidden" value="${oggetto.getDescrOggetto()}"/>
                    <input name= "pezzi" type="hidden" value="${oggetto.getPezziDisponibili()}"/>
                    <input name= "price" type="hidden" value="${oggetto.getPrezzo()}"/>
                    <input type="submit" value="Gestione Oggetto" name="Submit"/>
                </form>
                
            </td>            
        </tr>
    </c:forEach>   

</table>

