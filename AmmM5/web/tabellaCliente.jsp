<%-- 
    Document   : tabella
    Created on : 28-apr-2016, 12.04.46
    Author     : MARCO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<!-- JSP TABELLA OGGETTI IN VENDITA -->
<!DOCTYPE html>


<table id="tableCliente">

    <c:forEach var="oggetto" items="${listaOggetti}">
        
        
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
                <form method="get" action="acquistoOggetto.html">
                    <input name = "name" type="hidden" value="${oggetto.getNomeOggetto()}"/>
                    <input name = "url" type="hidden" value="${oggetto.getUrlOggetto()}"/>
                    <input name = "piece" type="hidden" value="${oggetto.getPezziDisponibili()}"/>
                    <input name = "price" type="hidden" value="${oggetto.getPrezzo()}"/>
                    <input name = "id_oggetto" type="hidden" value="${oggetto.getId()}"/>
                    <input type="submit" value="Aggiungi" name="Submit"/>
                </form>
            </td>            
        </tr>
        
    </c:forEach>   

</table>

