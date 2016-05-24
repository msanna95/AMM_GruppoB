<%-- 
    Document   : gestioneOggetto
    Created on : 23-mag-2016, 9.44.18
    Author     : MARCO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- JSP PAGINA GESTIONE OGGETTO -->
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Venditore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="MarcoSanna">
		<meta name="description" content="Area venditori per le vendite">
		<meta name="keywords" content="autoricambi, venditore, articoli, vendi, sell"> 
        <link href="./mystyle.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    
    <body>
        
        <!-- PAGE -->
        <div class="page">
            <!-- HEADER -->
            <header> </header>
            <%@ include file="barra-navigazione.jsp" %>		

            <div class="content"> 
                
                <div id="contenitore-contenuto-vendite">
                    <h2>Modifica i dati del tuo articolo:</h2>
                        <form method="get" action="gestioneOggetto.html" id="form-vendita">

                            <ul id="campi-input-vendita">
                                
                                <li> <label for="name">Nome articolo:   </label> 
                                <input name="name" id="name" type="text" value="${name}"/> </li>

                                <li> <label for="img">Url immagine articolo:   </label>
                                <input name="img" id="img" type="text" value="${url}"/>  </li>

                                <li> <label for="descr">Descrizione articolo:    </label>
                                <textarea name="descr" id="descr" > ${descr} </textarea>  </li>

                                <li> <label for="price">Prezzo articolo:    </label> 
                                <input name="price" id="price" type="text" value="${price}"/>  </li>

                                <li> <label for="qnt">Quantità articoli:    </label> 
                                <input name="qnt" id="qnt" type="text" value="${pezzi}"/>  </li>  
                                
                                

                            </ul> 
                            <label></label>
                            <input name = "id" type="hidden" value="${id_oggetto}"/>
                            <input type="submit" value="Modifica" name="Submit_2"/>
                            <input type="submit" value="Cancella Oggetto" name="Submit_3"/>
                            <button> <a href="venditore.html">Annulla</a></button>
                            
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
