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
import mstPackage.Saldo_Clienti_Venditori;
import mstPackage.Saldo_Clienti_Venditori_Factory;

/**
 *
 * @author MARCO
 */
@WebServlet(name = "RiepilogoAcquisto", urlPatterns = {"/riepilogoAcquisto.html"})
public class RiepilogoAcquisto extends HttpServlet {

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
        
        
            
        
        HttpSession session = request.getSession(false);
        if(request.getParameter("Submit")!= null){
            
            if(request.getParameter("name") != null && request.getParameter("url") != null && 
                    request.getParameter("piece") != null && request.getParameter("price") != null) {
                
                double conto = 100000;
                Integer id = (Integer)session.getAttribute("id");
                if(id != null) {
                    Saldo_Clienti_Venditori saldo = Saldo_Clienti_Venditori_Factory.getInstance().getSaldoById(id);
                    conto = saldo.getSaldo();
                }
                
                
                
                String name = request.getParameter("name");
                String imgUrl = request.getParameter("url");
                String piece = request.getParameter("piece");
                double prezzo = Double.parseDouble(request.getParameter("price"));          
                
                request.setAttribute("nomeOggetto", name);
                request.setAttribute("urlOggetto", imgUrl);
                request.setAttribute("pezziDispOggetto", piece);
                request.setAttribute("prezzoOggetto", prezzo); 
                request.setAttribute("contoCliente", conto);
                request.getRequestDispatcher("/riepilogoAcquisto.jsp").forward(request, response);
            }
        }
        if(request.getParameter("Submit_2")!= null) {
            request.setAttribute("prezzoOggetto", Double.parseDouble(request.getParameter("prezzoOggetto")));
            request.setAttribute("contoCliente", Double.parseDouble(request.getParameter("contoCliente")));
            request.getRequestDispatcher("/acquistoConfermato.jsp").forward(request, response);
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
