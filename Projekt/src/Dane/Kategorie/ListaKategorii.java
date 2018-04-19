package Dane.Kategorie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class ListaKategorii implements Serializable {
    private ArrayList<Kategoria> l = new ArrayList<Kategoria>();
    
    /**
     *
     * tworzenie nowej kategorii o nazwie x
     */
    public void dodaj(String x){
        l.add(new Kategoria(x));
    }
    
    /**
     *
     * usuwanie kategorii 
     */
    public void usun(int x){
        l.remove(x);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Kategoria> getLista(){
        return l;
    }
    
    /**
     * pomocnicza metoda do sprawdzania aktualnej listy kategorii
     */
    public void wyswietlWszystko(){
        for(int i=0; i<l.size(); i++){
            System.out.println(l.get(i).getNazwa());
            for(int j=0; j<l.get(i).getPrzepisy().size(); j++){
                System.out.println(l.get(i).getPrzepisy().get(j));
            }
        }
    }
    
    /**
     *
     */
    public void odczytZPliku(){
        try{
            FileInputStream f = new FileInputStream("Kategorie.dat");
            ObjectInputStream o = new ObjectInputStream(f);
            l = (ArrayList<Kategoria>)o.readObject();
            f.close();
            o.close();
        }catch (IOException | ClassNotFoundException f) {
            System.out.println("Problem przy odczycie Kategorie.dat !");
        }
    }
    
    /**
     *
     */
    public void zapisDoPliku(){
        try{
            FileOutputStream f = new FileOutputStream("Kategorie.dat");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(l);
            f.close();
            o.close();
        }catch (IOException f) {
            System.out.println("Problem przy zapisie Kategorie.dat !");
        }
    }
}
