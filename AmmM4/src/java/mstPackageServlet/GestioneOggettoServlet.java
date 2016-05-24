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

/**
 *
 * @author MARCO
 */
@WebServlet(name = "GestioneOggettoServlet", urlPatterns = {"/gestioneOggetto.html"})
public class GestioneOggettoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);         
        
        if(request.getParameter("Submit")!= null) {
            
            request.setAttribute("id_oggetto", Integer.parseInt(request.getParameter("id")));
            //request.setAttribute("oggetto", request.getParameter("oggetto"));
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("url", request.getParameter("url"));
            request.setAttribute("descr", request.getParameter("descr"));
            request.setAttribute("price", request.getParameter("price"));
            request.setAttribute("pezzi", request.getParameter("pezzi"));
            
            
            
            request.getRequestDispatcher("/gestioneOggetto.jsp").forward(request, response);
        }
        if(request.getParameter("Submit_2")!= null) {
            
            //int id_oggetto = Integer.parseInt((String) request.getAttribute("id"));
            String nomeOggetto = request.getParameter("name");
            String urlImmagine = request.getParameter("img");
            String descrImmagine = request.getParameter("descr");
            double prezzoOggetto = Double.parseDouble(request.getParameter("price"));
            int quantOggetti = Integer.parseInt(request.getParameter("qnt"));
            int id_oggetto = Integer.parseInt(request.getParameter("id"));
            
            Oggetti_Vendita_Factory.getInstance().editOggetto(id_oggetto, nomeOggetto, urlImmagine, 
                    descrImmagine, quantOggetti, prezzoOggetto);
            
            try {
            Oggetti_Vendita_Factory.getInstance().inizializzaOggetti();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.getRequestDispatcher("/venditore.html").forward(request, response);
            
        }
        
        if(request.getParameter("Submit_3")!= null) {
            
            int id_oggetto = Integer.parseInt(request.getParameter("id"));
            Oggetti_Vendita_Factory.getInstance().deleteOggetto(id_oggetto);
            request.getRequestDispatcher("/venditore.html").forward(request, response);
        }
        
        
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
            Logger.getLogger(GestioneOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(GestioneOggettoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
