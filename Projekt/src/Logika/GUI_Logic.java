package Logika;

import Dane.Kategorie.Kategoria;
import Dane.Kategorie.ListaKategorii;
import Dane.Przepisy.ListaPrzepisow;
import Dane.Przepisy.Przepis;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * logika aplikacji
 */
public class GUI_Logic extends JDialog{

    /**
     *
     * wstępne dodanie kategorii w formie dialogu pytającego
     */
    public String dodajKategorie(){
        String kat = null;
        if("".equals(kat = JOptionPane.showInputDialog("Podaj nazwe kategorii :"))){
            JOptionPane.showMessageDialog(this, "Nie podałeś niczego !");
        }
        return kat;
    }

    /**
     *
     * metoda przypisująca nazwy przepisów do kategorii na pozycji x w liście
     */
    public DefaultListModel PrzepisyDlaKategorii(int x, ArrayList<Kategoria> k){
        DefaultListModel d = new DefaultListModel();
        for(int j=0; j<k.get(x).getPrzepisy().size(); j++){
            d.addElement(k.get(x).getPrzepisy().get(j));
        }
        return d;
    }
    
    /**
     * metoda wczytująca nazwy przepisów do JListy przepisów w głównym oknie oraz w oknie kategorii
     */
    public DefaultListModel WczytajPrzepisy(ArrayList<Przepis> p){
        DefaultListModel d = new DefaultListModel();
        for(int i=0; i<p.size(); i++){
            d.addElement(p.get(i).getOpis());
        }
        return d;
    }
    
    /**
     * metoda wczytująca nazwy kategorii do JListy w oknie kategorii
     */
    public DefaultListModel WczytajKategorie(ArrayList<Kategoria> k){
        DefaultListModel d = new DefaultListModel();
        for(int i=0; i<k.size(); i++){
            d.addElement(k.get(i).getNazwa());
        }
        return d;
    }
    
    /**
     * metoda wczytująca do ComboBoxa w głównym oknie nazwy kategorii
     */
    public DefaultComboBoxModel WczytajKategorieDlaComboBoxa(ArrayList<Kategoria> k){
        DefaultComboBoxModel d = new DefaultComboBoxModel();
        for(int i=0; i<k.size(); i++){
            d.addElement(k.get(i).getNazwa());
        }
        return d;
    }
    
    /**
     * metoda generujaca przepis w formie tekstu na podstawie jego tytułu, nazwy składników
     * ich ewentualnych dodatkowych właściwości, ich ilości i receptury
     */
    public String generujPrzepis(String w, ArrayList<Przepis> p){
        String wynik = "";
        double kalorie = 0.0;
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<p.size(); i++){
            if(w.equals(p.get(i).getOpis())){
                kalorie = p.get(i).getKalorie();
                temp.add("Składniki :\n\n");
                for(int j=0; j<p.get(i).getLista().size(); j++){
                    temp.add("   " + p.get(i).getLista().get(j).generuj() + "\n\n");
                }
                temp.add("Średnia wartość kaloryczna - "+kalorie+" kCal\n\n");
                temp.add("Sposób przyrządzenia : \n"+p.get(i).getReceptura());
                break;
            }
        }
        for (String s : temp)
        {
            wynik += s;
        }
        return wynik;
    }
    
    /**
     * metoda wyszukująca przepisów w formie dialogu w zależności od wybranej opcji
     */
    public DefaultListModel wyszukajPrzepis(ArrayList<Przepis> p){
        DefaultListModel d = new DefaultListModel();

        String w = (String) JOptionPane.showInputDialog(null, "Po czym wyszukać przepisów ?", null, 3, null, new String[] {"po nazwie", "po składniku"}, null);
        if("po nazwie".equals(w)){
            w = JOptionPane.showInputDialog("Podaj nazwe przepisu :");
            w = w.toLowerCase();
            for(int i=0; i<p.size(); i++){
                if(w.equals(p.get(i).getOpis().toLowerCase())){
                    d.addElement(p.get(i).getOpis());
                }
            }
        }
            
        else if("po składniku".equals(w)){
            w = JOptionPane.showInputDialog("Podaj nazwe składnika :");
            w = w.toLowerCase();
            for(int i=0; i<p.size(); i++){
                for(int j=0; j<p.get(i).getLista().size(); j++){
                    if(w.equals(p.get(i).getLista().get(j).getNazwa().toLowerCase()))
                        d.addElement(p.get(i).getOpis());
                }
            }
        }
        if(d.isEmpty())
            JOptionPane.showMessageDialog(this, "Niczego nie znaleziono !");
        return d;
    }
    
    /**
     * metoda wprowadzająca poprawkę do pierwszej kategorii - "Wszystkie", zwłaszcza przy uruchomieniu aplikacji
     */
    public ListaKategorii korygujListe(ListaKategorii lk, ListaPrzepisow lp){
        try{
            if(lk.getLista().isEmpty()){
                throw new Exception();
            }
            lk.getLista().get(0).getPrzepisy().clear();
            for(int i=0; i<lp.getLista().size(); i++){
                lk.getLista().get(0).dodajPrzepis(lp.getLista().get(i).getOpis());
            }
        } catch (Exception ex) {
            lk.dodaj("Wszystkie");
            for(int i=0; i<lp.getLista().size(); i++){
                lk.getLista().get(0).dodajPrzepis(lp.getLista().get(i).getOpis());
            }
        }
        return lk;
    }

    /**
     * metoda uruchamiająca zewnętrzny plik wsadowy w konsoli systemu - a w kosekwencji - 
     * - uruchomienie edytora przepisów w konsoli
     */
    public void odpalEdytor(){
        try {
            Runtime.getRuntime().exec("cmd /c start Edytor.bat");
        } catch (IOException ex) {
            System.out.println("Problem przy uruchomieniu !!!");
        }
    }
    
}
