<%-- 
    Document   : barra-navigazione
    Created on : 27-apr-2016, 17.44.54
    Author     : MARCO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BARRA DI NAVIGAZIONE -->
<nav class="barra-navigazione">
    <!-- CONTENITORE DELLA BARRA DI NAVIGAZIONE -->
    <div class="contenitore-menu-navigazione">
        <!-- LOGO BARRA DI NAVIGAZIONE -->
        <a href="descrizione.jsp" class="logo-menu-navigazione">AUTORICAMBI ONLINE</a>
        <!-- MENU DI NAVIGAZIONE -->
        <ul class="menu-navigazione">
            
            
            <c:if test="${loggedInCliente == true || loggedInVenditore == true}"> 
                <li><a href="logout.html">Logout</a> 
            </c:if>           
            
            <c:if test="${loggedInVenditore != true && loggedInCliente != true}"> 
                <li><a href="login.html">Login</a> 
            </c:if>
                
            <li><a href="descrizione.jsp">Descrizione</a></li>
            <li><a href="cliente.html">Cliente</a></li>
            <li><a href="venditore.html">Venditore</a></li>
        </ul>  	
    </div>	
</nav>