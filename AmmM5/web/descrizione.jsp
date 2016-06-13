<%-- 
    Document   : descrizione
    Created on : 27-apr-2016, 17.37.57
    Author     : MARCO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA DESCRIZIONE (INDEX PRINCIPALE) -->
<!DOCTYPE html>
<html>
    <head>	
        <title>Autoricambi Online</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="author" content="MarcoSanna">
            <meta name="description" content="Breve descrizione sito e funzionalità">
            <meta name="keywords" content="autoricambi, auto, ricambi, macchina, compravendita">		
            <link href="./mystyle.css" rel="stylesheet" type="text/css">
    </head>

    <body>
        <!-- PAGE -->
        <div class="page">
            <!-- HEADER -->
            <header> </header>
            <%@ include file="barra-navigazione.jsp" %> 	 
            <%@ include file="sidebar.jsp" %>
            <!-- CONTENT -->
            <div class="content"> 
                <!-- CONTENITORE DEL CONTENUTO TESTUALE -->
                <div id="contenitore-contenuto-testuale">
                    <h3 id="somm1"> Chi siamo </h3> 
                    <p> Autoricambi Online è un sito di compravendita di ricambi per automobili di ogni marchio (Fiat, Audi, Renault,...). 
                            Inizialmente nato in un piccolo negozio in provincia di Cagliari, dopo quasi un anno nasce Autoricambi Online come 
                            piattaforma di e-commerce sul web.</p> 

                    <h3 id="somm2"> Che cosa trattiamo </h3>
                    <p> Come già anticipato questo è un sito di compravendita di ricambi per auto, quindi trattiamo qualsiasi cosa
                            inerente alle auto come paraurti, fanali o prodotti per la cura dell'auto. Se hai qualcosa da vendere o 
                            ti serve qualcosa dai un'occhiata!</p>

                    <h3 id="somm3"> Area Cliente </h3>
                    <p> Nella vostra area cliente, dopo aver eseguito il login al vostro account, potrete
                            controllare la disponibilità e il prezzo dell'oggetto che state cercando e eventualmente
                            aggiungerlo al carrello. </p>

                    <h3 id="somm4"> Area Venditore </h3>
                    <p> Nella vostra area venditore potrete, attraverso il form apposito, inserire un oggetto in
                            vendita indicando il nome, una piccola descrizione dell'oggetto, il prezzo, la quantità
                            di oggetti disponibili e magari una foto dimostrativa.</p>
                </div>
            </div> 
        </div>
    </body>
</html>

