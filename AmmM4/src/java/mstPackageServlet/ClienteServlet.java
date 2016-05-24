/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackageServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mstPackage.Cliente;
import mstPackage.Oggetti_Vendita;
import mstPackage.Oggetti_Vendita_Factory;
import mstPackage.Saldo_Clienti_Venditori;
import mstPackage.Saldo_Clienti_Venditori_Factory;
import mstPackage.Utente;

/**
 *
 * @author MARCO
 * SERVLET PER LA GESTIONE DELLA PAGINA CLIENTE
 */
@WebServlet(name = "clienteServlet", urlPatterns = {"/cliente.html"})
public class ClienteServlet extends HttpServlet {

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
        
        if(null == session.getAttribute("loggedIn") || null == session.getAttribute("loggedInCliente")){
            request.getRequestDispatcher("paginaErrore.jsp").forward(request, response);
        }
        else{
            
            Integer id = (Integer)session.getAttribute("id");
            if(id != null) {                
                
                request.setAttribute("listaOggetti", Oggetti_Vendita_Factory.getInstance().getListaOggetti());
                request.setAttribute("saldoCliente", Saldo_Clienti_Venditori_Factory.getInstance().getSaldoById(id));
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
            
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
