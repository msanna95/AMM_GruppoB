/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mstPackage;

/**
 *
 * @author MARCO
 */
public class Oggetti_Vendita {
    
    /** Variabili generali oggetti in vendita **/
    private String nomeOggetto;
    private String urlOggetto;
    private String descrOggetto;
    private int pezziDisponibili;
    private double prezzo;
    private int id;
    
    public Oggetti_Vendita()
    {
        nomeOggetto = "";
        urlOggetto = "";
        descrOggetto = "";
        pezziDisponibili = 0;
        prezzo = 0;
        id = 0;
    }

    /**
     * @return the nomeOggetto
     */
    public String getNomeOggetto() {
        return nomeOggetto;
    }

    /**
     * @param nomeOggetto the nomeOggetto to set
     */
    public void setNomeOggetto(String nomeOggetto) {
        this.nomeOggetto = nomeOggetto;
    }

    /**
     * @return the pezziDisponibili
     */
    public int getPezziDisponibili() {
        return pezziDisponibili;
    }

    /**
     * @param pezziDisponibili the pezziDisponibili to set
     */
    public void setPezziDisponibili(int pezziDisponibili) {
        this.pezziDisponibili = pezziDisponibili;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the urlOggetto
     */
    public String getUrlOggetto() {
        return urlOggetto;
    }

    /**
     * @param urlOggetto the urlOggetto to set
     */
    public void setUrlOggetto(String urlOggetto) {
        this.urlOggetto = urlOggetto;
    }

    /**
     * @return the descrOggetto
     */
    public String getDescrOggetto() {
        return descrOggetto;
    }

    /**
     * @param descrOggetto the descrOggetto to set
     */
    public void setDescrOggetto(String descrOggetto) {
        this.descrOggetto = descrOggetto;
    }
    
    
}
