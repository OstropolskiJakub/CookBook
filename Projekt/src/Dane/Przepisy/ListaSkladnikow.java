package Dane.Przepisy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kuba
 */
public class ListaSkladnikow implements Serializable {
    private ArrayList<Skladnik> lista = new ArrayList<Skladnik>();
    
    /**
     *
     * Dodawanie x skladników od i-tego miejsca w liscie - edytor przepisow 
     */
    public void dodaj(int i, int x){
        Scanner in = new Scanner(System.in);
        String y;
        for(; i<x; i++){
            System.out.println("Podaj rodzaj skladnika : (" + (i+1) + ")");
            y =  in.nextLine();
            y = y.toLowerCase();
            switch(y){
                case "warzywo":
                    lista.add(i,new Warzywo_lub_Owoc());
                    lista.get(i).set();
                    break;
                case "owoc":
                    lista.add(i,new Warzywo_lub_Owoc());
                    lista.get(i).set();
                    break;
                case "mieso":
                    lista.add(i,new Mieso());
                    lista.get(i).set();
                    break;
                case "pieczywo":
                    lista.add(i,new Pieczywo());
                    lista.get(i).set();
                    break;
                case "nabial":
                    lista.add(i,new Nabiał());
                    lista.get(i).set();
                    break;
                case "przyprawa":
                    lista.add(i,new Przyprawa());
                    lista.get(i).set();
                    break;
                case "inny":
                    lista.add(i,new Inny());
                    lista.get(i).set();
                    break;
                default:
                    System.out.println("Nie ma takiego rodzaju !");
                    i --;
                    break;
            }
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Skladnik> getLista(){
        return lista;
    }
    
    /**
     * wyswietlanie listy - edytor przepisow
     */
    public void wyswietl(){
        for(int i=0; i<lista.size(); i++){
            System.out.println((i+1) + " :");
            lista.get(i).printSkladnik();
        }
        System.out.println("=========");
    }
    
    /**
     * edycja skladnika - edytor przepisów
     */
    public void edytuj(){
        try{
            Scanner in = new Scanner(System.in);
            wyswietl();
            System.out.println("Ktory skladnik chcesz edytowac ? : ");
            int w = in.nextInt();
            lista.remove((w-1));
            dodaj((w-1),w);
        }catch(Exception e){
            System.out.println("Podano nieprawidlowa opcje !");
            edytuj();
        }
    }
}
