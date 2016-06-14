<%-- 
    Document   : jsonList
    Created on : 14-giu-2016, 12.07.15
    Author     : MARCO
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="name" value="${oggetto.getNomeOggetto()}"/>
            <json:property name="imgUrl" value="${oggetto.getUrlOggetto()}"/>
            <json:property name="price" value="${oggetto.getPrezzo()}"/>
            <json:property name="piece" value="${oggetto.getPezziDisponibili()}"/>
            <json:property name="id_oggetto" value="${oggetto.getId()}"/>
        </json:object>
    </c:forEach>
</json:array>
