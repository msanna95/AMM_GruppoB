<%-- 
    Document   : venditore
    Created on : 28-apr-2016, 11.59.11
    Author     : MARCO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
					<h2>Vendi un articolo:</h2>
						<form method="get" action="confermaOggetto.html" id="form-vendita">
					
							<ul id="campi-input-vendita">
								<li> <label for="name">Inserire il nome dell'articolo:   </label> 
								<input name="name" id="name" type="text"/> </li>

								<li> <label for="img">Inserire la Url dell'immagine dell'articolo:   </label>
								<input name="img" id="img" type="text"/>  </li>

								<li> <label for="descr">Inserire una breve descrizione dell'articolo:    </label>
								<textarea name="descr" id="descr" > </textarea>  </li>

								<li> <label for="price">Inserire il prezzo dell'articolo:    </label> 
								<input name="price" id="price" type="number" min="0" value="0"/>  </li>

								<li> <label for="qnt">Inserire la quantità di articoli:    </label> 
								<input name="qnt" id="qnt" type="number" min="0" value="0"/>  </li>  
								
								
							</ul> 
							<label></label>
							<!--<button type="submit"> Aggiungi</button>-->
                                                        <input type="submit" value="Aggiungi" name="Submit"/>        
						</form>
				</div>
			</div>
		</div>
    </body>
</html>
