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
public class Oggetti_Vendita_Factory {
    private static Oggetti_Vendita_Factory singleton;
    public static Oggetti_Vendita_Factory getInstance() {
        if (singleton == null) {
            singleton = new Oggetti_Vendita_Factory();
        }
        return singleton;
    }
    
    /** Lista Oggetti **/
    private ArrayList<Oggetti_Vendita> listaOggetti = new ArrayList<>();
    
    public Oggetti_Vendita_Factory(){
        /** Riempimento lista oggetti **/
        /** Oggetto 1 **/
        Oggetti_Vendita oggetto_1 = new Oggetti_Vendita();
        oggetto_1.setNomeOggetto("Paraurti anteriore Fiat 500");
        oggetto_1.setUrlOggetto("img/img_1.png");
        oggetto_1.setDescrOggetto("paraurti molto bello");
        oggetto_1.setPezziDisponibili(1);
        oggetto_1.setPrezzo(100);
        oggetto_1.setId(1);
        listaOggetti.add(oggetto_1);
        
        /** Oggetto 2 **/
        Oggetti_Vendita oggetto_2 = new Oggetti_Vendita();
        oggetto_2.setNomeOggetto("Cera per auto Arexons");
        oggetto_2.setUrlOggetto("img/img_2.png");
        oggetto_2.setDescrOggetto("cera molto bella");
        oggetto_2.setPezziDisponibili(10);
        oggetto_2.setPrezzo(22.50);
        oggetto_2.setId(2);
        listaOggetti.add(oggetto_2);
        
        /** Oggetto 3 **/
        Oggetti_Vendita oggetto_3 = new Oggetti_Vendita();
        oggetto_3.setNomeOggetto("Fanali anteriori Citroen C3");
        oggetto_3.setUrlOggetto("img/img_3.png");
        oggetto_3.setDescrOggetto("fanali molto belli");
        oggetto_3.setPezziDisponibili(2);
        oggetto_3.setPrezzo(200);
        oggetto_3.setId(3);
        listaOggetti.add(oggetto_3);
        
        /** Oggetto 4 **/
        Oggetti_Vendita oggetto_4 = new Oggetti_Vendita();
        oggetto_4.setNomeOggetto("Marmitta sportiva Giulietta");
        oggetto_4.setUrlOggetto("img/img_4.png");
        oggetto_4.setDescrOggetto("marmitta molto bella");
        oggetto_4.setPezziDisponibili(5);
        oggetto_4.setPrezzo(180);
        oggetto_4.setId(4);
        listaOggetti.add(oggetto_4);
        
        /** Oggetto 5 **/
        Oggetti_Vendita oggetto_5 = new Oggetti_Vendita();
        oggetto_5.setNomeOggetto("Fanali posteriori Golf 6");
        oggetto_5.setUrlOggetto("img/img_5.png");
        oggetto_5.setDescrOggetto("fanali molto belli");
        oggetto_5.setPezziDisponibili(2);
        oggetto_5.setPrezzo(280.00);
        oggetto_5.setId(5);
        listaOggetti.add(oggetto_5);
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
