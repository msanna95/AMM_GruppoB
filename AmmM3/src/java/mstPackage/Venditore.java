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
public class Venditore extends Utente {
    
    /** Lista oggetti venduti **/
    private ArrayList<Oggetti_Vendita> oggettiVendita = new ArrayList<>();
    
    /** Costruttore cliente **/
    public Venditore ()
    {
        super();
    }   

    /**
     * @return the oggettiVendita
     */
    public ArrayList<Oggetti_Vendita> getOggettiVendita() {
        return oggettiVendita;
    }

    /**
     * @param oggettiVendita the oggettiVendita to set
     */
    public void setOggettiVendita(ArrayList<Oggetti_Vendita> oggettiVendita) {
        this.oggettiVendita = oggettiVendita;
    }
}
