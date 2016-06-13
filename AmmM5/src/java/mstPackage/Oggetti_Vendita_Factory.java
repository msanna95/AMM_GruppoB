/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Oggetti_Vendita_Factory {
    
    private static String connectionString;
    public void setConnectionString(String s){
	connectionString = s;
    }
    public String getConnectionString(){
            return connectionString;
    } 
    
    private static Oggetti_Vendita_Factory singleton;
    public static Oggetti_Vendita_Factory getInstance() {
        if (singleton == null) {
            singleton = new Oggetti_Vendita_Factory();
        }
        return singleton;
    }
    
  
    /** Lista Oggetti **/
    private static ArrayList<Oggetti_Vendita> listaOggetti = new ArrayList<>();
    
    
    public Oggetti_Vendita_Factory(){
        
    }

    /** Metodo per inizializzare la lista degli oggetti con i dati del database **/
    public void inizializzaOggetti() throws SQLException{
        
        listaOggetti = new ArrayList<>();
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI OGGETTO **/
            String sql = "select * from oggetto";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Oggetti_Vendita current = new Oggetti_Vendita();
                current.setId(set.getInt("id"));
                current.setNomeOggetto(set.getString("nome"));
                current.setUrlOggetto(set.getString("url"));
                current.setDescrOggetto(set.getString("descrizione"));
                current.setPezziDisponibili(set.getInt("pezzi"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setId_venditore(set.getInt("id_venditore"));
                listaOggetti.add(current);
            }
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
    }
    
    /** Metodo che restituisce la lista degli oggetti in vendita di un determinato venditore in base all'id
     * @param id
     * @return 
     * @throws java.sql.SQLException **/
    public ArrayList<Oggetti_Vendita> getListaOggettiByIdVenditore(int id) throws SQLException{
        
        ArrayList<Oggetti_Vendita> listaOggettiSingoloVenditore = new ArrayList<>();
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI OGGETTO **/            
            String sql = "select * from oggetto where id_venditore = " + String.valueOf(id);
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Oggetti_Vendita current = new Oggetti_Vendita();
                current.setId(set.getInt("id"));
                current.setNomeOggetto(set.getString("nome"));
                current.setUrlOggetto(set.getString("url"));
                current.setDescrOggetto(set.getString("descrizione"));
                current.setPezziDisponibili(set.getInt("pezzi"));
                current.setPrezzo(set.getDouble("prezzo"));
                current.setId_venditore(set.getInt("id_venditore"));
                listaOggettiSingoloVenditore.add(current);
            }
            stmt.close();
            /** **/            
            conn.close(); 
            
            //return listaOggettiSingoloVenditore;
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
        
        return listaOggettiSingoloVenditore;
        
    }
    
    /** Metodo che aggiunge un oggetto nel database: restituisce 1 se ha aggiunto la riga nel database, 0 altrimenti.
     * @param nome
     * @param url
     * @param descrizione
     * @param pezzi
     * @param id_venditore
     * @param prezzo
     * @return  **/
    public int aggiungiOggetto(String nome, String url, String descrizione, int pezzi, double prezzo, int id_venditore)
        {
        
        int rows = 0;
        
        try{
            
            Connection conn;
            PreparedStatement stmt;
            
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            
            String sql = "INSERT INTO oggetto " + "(nome, url, descrizione, pezzi, prezzo, id_venditore)"
                    + " VALUES "
                    + "(?,?,?,?,?,?)";
          
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nome);
            stmt.setString(2, url);
            stmt.setString(3, descrizione);
            stmt.setInt(4, pezzi);
            stmt.setDouble(5, prezzo);
            stmt.setInt(6, id_venditore);
            
            
            rows = stmt.executeUpdate();
            
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
        
        return rows;
        
    }
    
    /** Metodo per la modifica di un oggetto del database: gli attributi dell'oggetto sono in input
     * @param id
     * @param nome
     * @param url
     * @param descrizione
     * @param pezzi
     * @param prezzo
     * @throws java.sql.SQLException **/
    public void editOggetto(int id, String nome, String url, String descrizione, int pezzi, double prezzo) throws SQLException{
        
        try{
            
            Connection conn;
            PreparedStatement stmt;             
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            
            String sql = "UPDATE oggetto SET nome = ?, url = ?, descrizione = ?, "
                    + "pezzi = ?, prezzo = ? WHERE id = ?";
    
            stmt = conn.prepareStatement(sql);
          
            stmt.setString(1, nome);
            stmt.setString(2, url);
            stmt.setString(3, descrizione);
            stmt.setInt(4, pezzi);
            stmt.setDouble(5, prezzo);
            stmt.setInt(6, id);
            
            stmt.executeUpdate();
            
            
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
        
    }
    
    /** Metodo per l'eliminazione di un oggetto dal database: l'id oggetto in inout
     * @param id **/
    public void deleteOggetto(int id){
        
        try{
            
            Connection conn;
            PreparedStatement stmt;             
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            
            String sql = "DELETE FROM oggetto WHERE id = ?";
    
            stmt = conn.prepareStatement(sql);
          
            stmt.setInt(1,id);            
            stmt.executeUpdate();            
            
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
        
    }
    
    
    /** Metodo che restituisce l'id_venditore associato ad un dato oggetto: input id_oggetto
     * @param id_oggetto
     * @return  **/
    public int getIdVenditoreByIdOggetto(int id_oggetto){
        
        int id_venditore = 0;
        
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI OGGETTO **/            
            String sql = "select id_venditore from oggetto where id = " +  String.valueOf(id_oggetto);
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                id_venditore = set.getInt("id_venditore");
            }
            stmt.close();
            /** **/            
            conn.close(); 
            
            //return listaOggettiSingoloVenditore;
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }
        
        return id_venditore;
    }
    
    /** Metodo per la gestione di vendita di un oggetto
     * @param id_oggetto
     * @param id_cliente
     * @param prezzo_oggetto
     * @return
     * @throws java.sql.SQLException  **/
    public int sellOggetto(int id_oggetto, int id_cliente, double prezzo_oggetto) throws SQLException{
        
        Connection conn = null;
        int flag = 0;
        try{
            
            
            PreparedStatement stmt;  
            int id_venditore = Oggetti_Vendita_Factory.getInstance().getIdVenditoreByIdOggetto(id_oggetto);
            int id_utente_cliente = Utente_Factory.getInstance().getIdUtenteByIdVC(id_cliente, 1);
            int id_utente_venditore = Utente_Factory.getInstance().getIdUtenteByIdVC(id_venditore, 2);
            conn = DriverManager.getConnection(connectionString, "prova", "prova");
            double saldo_cliente = Saldo_Clienti_Venditori_Factory.getInstance().getSaldoByIdVC(id_cliente, 2);
            conn.setAutoCommit(false); 
            if(prezzo_oggetto <= saldo_cliente){
                
                String sql = "UPDATE utente SET saldo = (saldo + ?) WHERE id = ?";    
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, prezzo_oggetto);
                stmt.setInt(2, id_utente_venditore);
                stmt.executeUpdate();
                
                sql = "UPDATE utente SET saldo = (saldo - ?) WHERE id = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, prezzo_oggetto);
                stmt.setInt(2, id_utente_cliente);
                stmt.executeUpdate();
                
                conn.commit();
                conn.setAutoCommit(true);
                
                stmt.close();
                /** **/            
                conn.close();   

                deleteOggetto(id_oggetto);
                flag++;
                
            } else {
                conn.rollback();
            }
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException  
            conn.rollback();
            Logger.getLogger(Oggetti_Vendita_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }  
        
        
        return flag;
    }
    
    /**
     * @return the listaOggetti
     */
    public ArrayList<Oggetti_Vendita> getListaOggetti() {
        return listaOggetti;
    }
    
    public Oggetti_Vendita getOggettoById(int id){
        for(Oggetti_Vendita lista : listaOggetti){
            if(lista.getId() == id)
                return lista;
        }
        return null;
    }
}
