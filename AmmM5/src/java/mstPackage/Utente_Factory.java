/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARCO
 */
public class Utente_Factory {
    
    private static String connectionString;
    public void setConnectionString(String s){
	connectionString = s;
    }
    public String getConnectionString(){
            return connectionString;
    } 
    
    private static Utente_Factory singleton;
    public static Utente_Factory getInstance() {
        if (singleton == null) {
            singleton = new Utente_Factory();
        }
        return singleton;
    }
    
   
    /** Lista Clienti **/
    private static ArrayList<Cliente> listaClienti = new ArrayList<>();
    /** Lista Venditori **/
    private static ArrayList<Venditore> listaVenditori = new ArrayList<>();
    
    private Utente_Factory()
    {           
    
    }

    /** Metodo che inizializza la lista di utenti con i dati del database **/
    public void InizializzaUtenti(){
        
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI CLIENTE **/
            String sql = "select * from utente join cliente on utente.id = cliente.id_utente";
            
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {                
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));              
                listaClienti.add(current);                
            }
            
            /** **/
            /** DATI VENDITORE **/
            
            sql = "select * from utente join venditore on utente.id = venditore.id_utente";
            set = stmt.executeQuery(sql);
            while (set.next()) {                
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                listaVenditori.add(current);                
            }
            stmt.close();
            /** **/
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Utente_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }
        
        
    }
    
    /** Metodo che restituisce l'id utente in base all'input: input id per id_venditore o id_cliente, 
     *  scelta per selezione cliente (1) o venditore altrimenti.
     * @param id
     * @param scelta
     * @return 
     */
    public int getIdUtenteByIdVC (int id, int scelta){
        
        int id_o = 0;
        
        try{
            String sql;
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            if(scelta == 1)            
                sql = "select utente.id from utente join cliente on utente.id = id_utente where cliente.id = " + String.valueOf(id);
            else
                sql = "select utente.id from utente join venditore on utente.id = id_utente where venditore.id = " + String.valueOf(id);
            ResultSet set = stmt.executeQuery(sql);
            
            while(set.next())
            {
                id_o = (set.getInt("id")); 
            }
            
            stmt.close();
            /** **/
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Utente_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }
        
        return id_o;
        
    }
    
    /** Restituisce l'id venditore associato ad un id utente
     * @param id
     * @return  **/
    public int getIdVenditoreByIdUtente(int id){
        
        int id_venditore = 0;
        
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI CLIENTE **/
            String sql = "select id from venditore where id_utente = " + String.valueOf(id);
            
            ResultSet set = stmt.executeQuery(sql);
            
            while(set.next())
            {
                id_venditore = (set.getInt("id")); 
            }
            
            stmt.close();
            /** **/
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Utente_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }
        
        return id_venditore;
        
    }
    /** Restituisce l'id cliente associato ad un id utente
     * @param id
     * @return  **/
    public int getIdClienteByIdUtente(int id){
        
        int id_cliente = 0;
        
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI CLIENTE **/
            String sql = "select id from cliente where id_utente = " + String.valueOf(id);
            
            ResultSet set = stmt.executeQuery(sql);
            
            while(set.next())
            {
                id_cliente = (set.getInt("id")); 
            }
            
            stmt.close();
            /** **/
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Utente_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }
        
        return id_cliente;
        
    }
    
    /**
     * @return the listaClienti
     */
    public ArrayList<Cliente> getListaClienti() {
        return listaClienti;
    }

    public Cliente getClienteById(int id){
        for(Cliente lista : listaClienti){
            if(lista.getId() == id)
                return lista;
        }
        return null;
    }

    /**
     * @return the listaVenditori
     */
    public ArrayList<Venditore> getListaVenditori() {
        return listaVenditori;
    }

    
    public Venditore getVenditoreById(int id){
        for(Venditore lista : listaVenditori){
            if(lista.getId() == id)
                return lista;
        }
        return null;
    }
    
    public ArrayList<Utente> getListaUtenti(){
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        
        return listaUtenti;
    }
    
    
    
    
}
