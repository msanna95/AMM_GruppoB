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
import mstPackage.Utente_Factory;

/**
 *
 * @author MARCO
 */
@WebServlet(name = "VenditaOggetto", urlPatterns = {"/venditaOggetto.html"})
public class VenditaOggettoServlet extends HttpServlet {

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
        
        /** Servlet gestione vendita oggetto **/       
        HttpSession session = request.getSession(false);
        
        if(request.getParameter("Submit")!= null){
            
            if(request.getParameter("name") != null && request.getParameter("img") != null && 
                    request.getParameter("descr") != null && request.getParameter("price") != null &&
                    request.getParameter("qnt") != null ) {
                
                String name = request.getParameter("name");
                String imgUrl = request.getParameter("img");
                String descr = request.getParameter("descr");
                //int prezzo = Integer.parseInt(request.getParameter("price"));        
                double prezzo = Double.parseDouble(request.getParameter("price"));
                int pezziDisponibili = Integer.parseInt(request.getParameter("qnt"));
                
                if(name.length() > 0 && imgUrl.length() > 0 && descr.length() > 0 && prezzo > 0 &&
                        pezziDisponibili > 0) {
                    request.setAttribute("nomeOggetto", name);
                    request.setAttribute("urlOggetto", imgUrl);
                    request.setAttribute("descrOggetto", descr);
                    request.setAttribute("prezzoOggetto", prezzo);
                    request.setAttribute("pezziDispOggetto", pezziDisponibili);
                    request.getRequestDispatcher("/riepilogoVendita.jsp").forward(request, response);
                }               
                
            }    
            
        } 
        
        if(request.getParameter("Submit_2")!= null) {
            
            Integer id = (Integer)session.getAttribute("id");
            if(id != null) {
                
                if(request.getParameter("name") != null && request.getParameter("url") != null && 
                    request.getParameter("descr") != null && request.getParameter("price") != null &&
                    request.getParameter("piece") != null ) {
                
                    String name = request.getParameter("name");
                    String imgUrl = request.getParameter("url");
                    String descr = request.getParameter("descr");
                    //int prezzo = Integer.parseInt(request.getParameter("price"));        
                    double prezzo = Double.parseDouble(request.getParameter("price"));
                    int pezziDisponibili = Integer.parseInt(request.getParameter("piece"));

                
                    int id_venditore = Utente_Factory.getInstance().getIdVenditoreByIdUtente(id);
                    int rows = Oggetti_Vendita_Factory.getInstance().aggiungiOggetto(name, imgUrl, descr,
                            pezziDisponibili, prezzo, id_venditore);


                    if(rows != 0)
                        request.getRequestDispatcher("/venditaConfermata.jsp").forward(request, response);
                    else
                        request.getRequestDispatcher("/paginaErrore.jsp").forward(request, response);
                }
            }            
        }       
        
        request.getRequestDispatcher("/venditore.html").forward(request, response);
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
            Logger.getLogger(VenditaOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VenditaOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
