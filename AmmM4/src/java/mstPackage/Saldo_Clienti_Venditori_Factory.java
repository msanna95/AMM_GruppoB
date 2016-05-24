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
public class Saldo_Clienti_Venditori_Factory {
    
    private static String connectionString;
    public void setConnectionString(String s){
	connectionString = s;
    }
    public String getConnectionString(){
            return connectionString;
    } 
    
    private static Saldo_Clienti_Venditori_Factory singleton;
    public static Saldo_Clienti_Venditori_Factory getInstance() {
        if (singleton == null) {
            singleton = new Saldo_Clienti_Venditori_Factory();
        }
        return singleton;
    }
    
    
    /** Lista saldi clienti e venditori **/
    private static ArrayList<Saldo_Clienti_Venditori> listaSaldiClientiVenditori = new ArrayList<>();
    
    public Saldo_Clienti_Venditori_Factory(){
        
        
    }

    /** Metodo che inizializza le liste recuperando i dati dal database **/
    public void inizializzaSaldo(){
        
        listaSaldiClientiVenditori = new ArrayList<>();
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            /** DATI SALDO **/
            String sql = "select id, saldo from utente";
            ResultSet set = stmt.executeQuery(sql);
            while (set.next()) {
                Saldo_Clienti_Venditori current = new Saldo_Clienti_Venditori();
                current.setId(set.getInt("id"));
                current.setSaldo(set.getDouble("saldo"));                
                listaSaldiClientiVenditori.add(current);                
            }
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Saldo_Clienti_Venditori_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
    }
    
    
    /* Restituisce il saldo di un cliente o di un venditore in base all'id specifico e alla scelta:
       1 per venditore, qualsiasi per cliente    */
    public double getSaldoByIdVC(int id, int scelta){
        
        double saldo = 0;
        
        try{
            
            Connection conn;
            Statement stmt;
            conn = DriverManager.getConnection(connectionString, "prova", "prova");            
            stmt = conn.createStatement();
            String sql;
            if(scelta == 1)
                //VENDITORE
                sql = "select saldo from utente join venditore on utente.id = id_utente where venditore.id = " +
                        String.valueOf(id);
            else
                //CLIENTE
                sql = "select saldo from utente join cliente on utente.id = id_utente where cliente.id = " +
                        String.valueOf(id);
                      
            
            ResultSet set = stmt.executeQuery(sql);
            
            while(set.next())
            {
                saldo = set.getDouble("saldo");   
            }
            
                         
                
            stmt.close();
            /** **/            
            conn.close();            
            
        } catch (SQLException ex) {
            // nel caso la query fallisca (p.e. errori di sintassi)
            // viene sollevata una SQLException
            Logger.getLogger(Saldo_Clienti_Venditori_Factory.class.getName()).
            log(Level.SEVERE, null, ex);
       }   
        
        return saldo;
    }
    
    
    /**
     * @return the listaSaldiClientiVenditori
     */
    public ArrayList<Saldo_Clienti_Venditori> getListaSaldiClientiVenditori() {
        return listaSaldiClientiVenditori;
    }
    
    public Saldo_Clienti_Venditori getSaldoById(int id){
        for(Saldo_Clienti_Venditori saldo : listaSaldiClientiVenditori){
            if(saldo.getId() == id)
                return saldo;
        }
        return null;
    }
    
}
