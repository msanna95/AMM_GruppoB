/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $( "#filtra" ).keyup(function()
    {  
        // Preleva il valore
        var text = $( "#filtra" ).val();
        //$("#tabella").hide();
        
        $.ajax(
        {
            url: "filter.json",
            data:{
              chiave: "q",
              valore: text 
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaProdotti(data);
            },
            error : function(data, state){
                console.error(state);
            }
        });
        
        function aggiornaListaProdotti(listaOggetti){
            
            $("#tabella").empty();
            
            
            if(listaOggetti.length > 0){
                for(var i in listaOggetti)
                {
                    var html = "<tr><td class=\"b-table-img\" rowspan=\"4\"><img title=\"" + listaOggetti[i].getNomeOggetto();
                    html += "\"alt=\"foto " + listaOggetti[i].getNomeOggetto() + "\" src=\"" + listaOggetti[i].getUrlOggetto() + "\" width=\"150\" height=\"150\"/></td>";
                    html += "<td> " + listaOggetti[i].getNomeOggetto() + "</td></tr>";
                    
                    html += "<tr><td> " + listaOggetti[i].getPezziDisponibili() + "x articoli disponibili </td><tr>";
                    html += "<td> " + listaOggetti[i].getPrezzo() + "</td></tr><tr><td>";
                    html += "<form method =\"get\" action=\"acquistoOggetto.html\">";
                    html += "<input name=\"name\" type=\"hidden\" value=\"" + listaOggetti[i].getNomeOggetto() + "\"/>";
                    html += "<input name=\"url\" type=\"hidden\" value=\"" + listaOggetti[i].getUrlOggetto() + "\"/>";
                    html += "<input name=\"piece\" type=\"hidden\" value=\"" + listaOggetti[i].getPezziDisponibili() + "\"/>";
                    html += "<input name=\"price\" type=\"hidden\" value=\"" + listaOggetti[i].getPrezzo() + "\"/>";
                    html += "<input name=\"id_oggetto\" type=\"hidden\" value=\"" + listaOggetti[i].getId() + "\"/>";
                    html += "<input type=\"submit\" value=\"Aggiungi\" name=\"Submit\"/></form></td></tr>";
                    
                    $("#tabella").append(html);
                }
            } else {
                $("#tabella").append("<div class=\"error-msg\">Nessun oggetto trovato</div>");
            }
            
            
            
        }

    

    });
});