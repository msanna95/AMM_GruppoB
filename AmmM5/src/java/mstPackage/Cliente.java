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
public class Cliente extends Utente {
    
    /** Lista oggetti comprati **/
    private ArrayList<Oggetti_Vendita> oggettiComprati = new ArrayList<>();
    
    /** Costruttore cliente **/
    public Cliente ()
    {
        super();
    }   

    /**
     * @return the oggettiComprati
     */
    public ArrayList<Oggetti_Vendita> getOggettiComprati() {
        return oggettiComprati;
    }

    /**
     * @param oggettiComprati the oggettiComprati to set
     */
    public void setOggettiComprati(ArrayList<Oggetti_Vendita> oggettiComprati) {
        this.oggettiComprati = oggettiComprati;
    }

    
    
}
