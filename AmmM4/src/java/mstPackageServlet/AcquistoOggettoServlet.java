/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mstPackage.Oggetti_Vendita_Factory;
import mstPackage.Saldo_Clienti_Venditori;
import mstPackage.Saldo_Clienti_Venditori_Factory;
import mstPackage.Utente_Factory;

/**
 *
 * @author MARCO
 * SERVLET PER LA GESTIONE DELLE PAGINE DI ACQUISTO DI UN OGGETTO
 */
@WebServlet(name = "AcquistoOggetto", urlPatterns = {"/acquistoOggetto.html"})
public class AcquistoOggettoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");    
        
        HttpSession session = request.getSession(false);
        if(request.getParameter("Submit")!= null){
            
            if(request.getParameter("name") != null && request.getParameter("url") != null && 
                    request.getParameter("piece") != null && request.getParameter("price") != null) {
                
                
                
                
                double conto = 0;
                Integer id = (Integer)session.getAttribute("id");
                if(id != null) {
                    Saldo_Clienti_Venditori saldo = Saldo_Clienti_Venditori_Factory.getInstance().getSaldoById(id);
                    conto = saldo.getSaldo();
                }
                
                
                
                String name = request.getParameter("name");
                String imgUrl = request.getParameter("url");
                String piece = request.getParameter("piece");
                double prezzo = Double.parseDouble(request.getParameter("price"));   
                int id_oggetto = Integer.parseInt(request.getParameter("id_oggetto"));
                
                request.setAttribute("nomeOggetto", name);
                request.setAttribute("urlOggetto", imgUrl);
                request.setAttribute("pezziDispOggetto", piece);
                request.setAttribute("prezzoOggetto", prezzo); 
                //request.setAttribute("contoCliente", conto);
                request.setAttribute("id_oggetto", id_oggetto);
                request.getRequestDispatcher("/riepilogoAcquisto.jsp").forward(request, response);
            }
        }
        if(request.getParameter("Submit_2")!= null) {
            
            Integer id_utente = (Integer)session.getAttribute("id");
            Integer id_cliente = Utente_Factory.getInstance().getIdClienteByIdUtente(id_utente);
            double prezzo_oggetto = Double.parseDouble(request.getParameter("prezzoOggetto"));
            Integer id_oggetto = Integer.parseInt(request.getParameter("id_oggetto"));
            
            /*request.setAttribute("id_cliente", id_cliente);
            request.setAttribute("prezzoOggetto", Double.parseDouble(request.getParameter("prezzoOggetto")));
            request.setAttribute("id_oggetto", Integer.parseInt(request.getParameter("id_oggetto")));*/
            
            Integer flag = Oggetti_Vendita_Factory.getInstance().sellOggetto(id_oggetto, id_cliente, prezzo_oggetto);
            Oggetti_Vendita_Factory.getInstance().inizializzaOggetti();
            Saldo_Clienti_Venditori_Factory.getInstance().inizializzaSaldo();
            request.setAttribute("flag", flag);
            //request.setAttribute("contoCliente", Double.parseDouble(request.getParameter("contoCliente")));
            request.getRequestDispatcher("/acquistoConfermato.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/paginaErrore.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AcquistoOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AcquistoOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
