/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackageServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mstPackage.*;

/**
 *
 * @author MARCO
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_CLEAN_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Utente_Factory.getInstance().setConnectionString(dbConnection);  
        Oggetti_Vendita_Factory.getInstance().setConnectionString(dbConnection);
        Saldo_Clienti_Venditori_Factory.getInstance().setConnectionString(dbConnection);
        
        Utente_Factory.getInstance().InizializzaUtenti();
        try {
            Oggetti_Vendita_Factory.getInstance().inizializzaOggetti();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Saldo_Clienti_Venditori_Factory.getInstance().inizializzaSaldo();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        
        
        
        HttpSession session = request.getSession(true);          
            
            
                
                if(request.getParameter("Submit")!= null){
                    
                    session.setAttribute("loggedIn", false);
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    
                    
                    
                    ArrayList<Utente> listaUtenti = Utente_Factory.getInstance().getListaUtenti();
                    
                    for(Utente utente: listaUtenti){
                        
                        if(utente.getUsername().equals(username) && 
                                utente.getPassword().equals(password)){
                            
                           session.setAttribute("loggedIn", true);
                           session.setAttribute("id", utente.getId());
                           session.setAttribute("username", utente.getUsername());
                           
                            if(utente instanceof Cliente){
                                session.setAttribute("loggedInCliente", true);
                                session.setAttribute("cliente", 1);
                                request.setAttribute("utente", utente);                                
                                request.getRequestDispatcher("cliente.html").forward(request, response);
                            } else {
                                session.setAttribute("loggedInVenditore", true);
                                session.setAttribute("venditore", 1);
                                //request.setAttribute("utente", utente);
                                request.getRequestDispatcher("venditore.html").forward(request, response);
                            }
                        }      
                    }
                    request.setAttribute("errore", true);   
                }
                //session.invalidate();
                request.getRequestDispatcher("/login.jsp").forward(request, response); 
            
        
        
        
        /*    HttpSession session = request.getSession(true);
              

            if(request.getParameter("Submit")!= null){
                session.setAttribute("logged_in", null);
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                ArrayList<Utente> listaUtenti = Utente_Factory.getInstance().getListaUtenti();
                //ArrayList<Oggetti_Vendita> listaOggetti = Oggetti_Vendita_Factory.getInstance().getListaOggetti();

                for(Utente utente: listaUtenti){
                    if(utente.getUsername().equals(username) && utente.getPassword().equals(password)){
                       session.setAttribute("logged_in", 1);
                       session.setAttribute("id", utente.getId());
                       session.setAttribute("username", utente.getUsername());
                       //session.setAttribute("password", utente.getPassword());
                        if(utente instanceof Cliente){
                            session.setAttribute("cliente", 1);
                            //request.setAttribute("utente", utente);
                            //request.setAttribute("oggettiVendita", listaOggetti);
                            request.getRequestDispatcher("cliente.html").forward(request, response);
                        } else {
                            session.setAttribute("venditore", 1);
                            //request.setAttribute("utente", utente);
                            request.getRequestDispatcher("venditore.jsp").forward(request, response);
                        }
                    }      
                }

                request.setAttribute("errore", 1);   
            }

            request.getRequestDispatcher("/login.jsp").forward(request, response); */
        
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
