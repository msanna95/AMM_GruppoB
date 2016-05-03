/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackage;

import java.util.ArrayList;

/**
 *
 * @author MARCO
 */
public class Utente_Factory {
    
    private static Utente_Factory singleton;
    public static Utente_Factory getInstance() {
        if (singleton == null) {
            singleton = new Utente_Factory();
        }
        return singleton;
    }
    
    /** Lista Clienti **/
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    /** Lista Venditori **/
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    
    private Utente_Factory()
    {   
        /** Riempimento lista clienti **/
        /** Cliente 1 **/
        Cliente cliente_1 = new Cliente();
        cliente_1.setUsername("cliente");
        cliente_1.setPassword("cliente");
        cliente_1.setId(1);
        listaClienti.add(cliente_1); 
        
        /** Cliente 2 **/
        Cliente cliente_2 = new Cliente();
        cliente_2.setUsername("cane89");
        cliente_2.setPassword("pollo12");
        cliente_2.setId(2);
        listaClienti.add(cliente_2);
        
        /** Cliente 3 **/
        Cliente cliente_3 = new Cliente();
        cliente_3.setUsername("genova34");
        cliente_3.setPassword("palla98");
        cliente_3.setId(3);
        listaClienti.add(cliente_3);
        
        /** Cliente 4 **/
        Cliente cliente_4 = new Cliente();
        cliente_4.setUsername("cera23");
        cliente_4.setPassword("volt76");
        cliente_4.setId(4);
        listaClienti.add(cliente_4);
        
        /** Cliente 5 **/
        Cliente cliente_5 = new Cliente();
        cliente_5.setUsername("riky78");
        cliente_5.setPassword("gelo76");
        cliente_5.setId(5);
        listaClienti.add(cliente_5);
        
        /** Riempimento lista venditori **/
        /** Venditore 1 **/
        Venditore venditore_1 = new Venditore();
        venditore_1.setUsername("msanna95");
        venditore_1.setPassword("prova00");
        venditore_1.setId(100);
        listaVenditori.add(venditore_1);
        
        
        /** Venditore 2 **/
        Venditore venditore_2 = new Venditore();
        venditore_2.setUsername("cane89");
        venditore_2.setPassword("pollo12");
        venditore_2.setId(102);
        listaVenditori.add(venditore_2);
        
        
        /** Venditore 3 **/
        Venditore venditore_3 = new Venditore();
        venditore_3.setUsername("venditore");
        venditore_3.setPassword("venditore");
        venditore_3.setId(103);
        listaVenditori.add(venditore_3);
        
        
        /** Venditore 4 **/
        Venditore venditore_4 = new Venditore();
        venditore_4.setUsername("cera23");
        venditore_4.setPassword("volt76");
        venditore_4.setId(104);
        listaVenditori.add(venditore_4);
        
        
        /** Venditore 5 **/
        Venditore venditore_5 = new Venditore();
        venditore_5.setUsername("riky78");
        venditore_5.setPassword("gelo76");
        venditore_5.setId(105);
        listaVenditori.add(venditore_5);
        
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
