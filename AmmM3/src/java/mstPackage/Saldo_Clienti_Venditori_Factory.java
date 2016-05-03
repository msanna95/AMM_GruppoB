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
public class Saldo_Clienti_Venditori_Factory {
    private static Saldo_Clienti_Venditori_Factory singleton;
    public static Saldo_Clienti_Venditori_Factory getInstance() {
        if (singleton == null) {
            singleton = new Saldo_Clienti_Venditori_Factory();
        }
        return singleton;
    }
    
    /** Lista saldi clienti e venditori **/
    private ArrayList<Saldo_Clienti_Venditori> listaSaldiClientiVenditori = new ArrayList<>();
    
    public Saldo_Clienti_Venditori_Factory(){
        
        /** Riempimento lista resoconto saldo **/
        /** Saldo 1 **/
        Saldo_Clienti_Venditori saldo_1 = new Saldo_Clienti_Venditori();
        saldo_1.setId(1);
        saldo_1.setSaldo(50);
        listaSaldiClientiVenditori.add(saldo_1);
        
        /** Saldo 2 **/
        Saldo_Clienti_Venditori saldo_2 = new Saldo_Clienti_Venditori();
        saldo_2.setId(2);
        saldo_2.setSaldo(30);
        listaSaldiClientiVenditori.add(saldo_2);
        
        /** Saldo 3 **/
        Saldo_Clienti_Venditori saldo_3 = new Saldo_Clienti_Venditori();
        saldo_3.setId(3);
        saldo_3.setSaldo(500);
        listaSaldiClientiVenditori.add(saldo_3);
        
        /** Saldo 4 **/
        Saldo_Clienti_Venditori saldo_4 = new Saldo_Clienti_Venditori();
        saldo_4.setId(4);
        saldo_4.setSaldo(10);
        listaSaldiClientiVenditori.add(saldo_4);
        
        /** Saldo 5 **/
        Saldo_Clienti_Venditori saldo_5 = new Saldo_Clienti_Venditori();
        saldo_5.setId(5);
        saldo_5.setSaldo(80);
        listaSaldiClientiVenditori.add(saldo_5);
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
