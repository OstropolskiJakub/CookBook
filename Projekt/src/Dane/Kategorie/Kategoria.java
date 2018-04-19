package Dane.Kategorie;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * Podastawowa klasa dla kategorii
 */
public class Kategoria implements Serializable {
    private String nazwa;
    private ArrayList<String> nazwyPrzepisow = new ArrayList<>();
    
    /**
     *
     * konstruktor
     */
    public Kategoria(String x){
        nazwa = x;
    }
    
    /**
     *
     * @return
     */
    public String getNazwa(){
        return nazwa;
    }
    
    /**
     *
     * dodawanie nazwy przepisów do ArrayListy - przyporządkowanie przepisów
     */
    public void dodajPrzepis(String x){
        nazwyPrzepisow.add(x);
    }
    
    /**
     *
     * usuwanie przypisanych przepisów na podstawie przekazanej nazwy
     */
    public void usunPrzepis(String x){
        for(int i=0; i<nazwyPrzepisow.size(); i++){
            if(nazwyPrzepisow.get(i).equals(x))
                nazwyPrzepisow.remove(i);
        }
        
    }
    
    /**
     *
     * @return
     */
    public ArrayList<String> getPrzepisy(){
        return nazwyPrzepisow;
    }
}
