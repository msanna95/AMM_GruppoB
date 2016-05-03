/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MARCO
 */
@WebServlet(name = "ConfermaOggetto", urlPatterns = {"/confermaOggetto.html"})
public class ConfermaOggetto extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //HttpSession session = request.getSession(false);
        
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
                    request.getRequestDispatcher("/confermaOggetto.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
