package Dane.Przepisy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Przepis implements Serializable {
    ListaSkladnikow ls = new ListaSkladnikow();
    private String opis;
    private double kalorie;
    private String receptura;
        
    public void tworz(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj tytul przepisu :");
            opis = in.nextLine();
            System.out.println("Podaj wartosc kaloryczna :");
            kalorie = in.nextDouble();
            in.nextLine();
            System.out.println("Ile skladnikow ma zawierac przepis ? :");
            int w = in.nextInt();
            ls.dodaj(0, w);
            in.nextLine();
            System.out.println("Podaj recepture :");
            receptura = in.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Podano bledne dane !");
            tworz();
        }
           
    }
    
    public String getOpis(){
        return opis;
    }
    
    public ArrayList<Skladnik> getLista(){
        return ls.getLista();
    }
    
    public String getReceptura(){
        return receptura;
    }
    
    public double getKalorie(){
        return kalorie;
    }
    
    public void edytuj(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Co chcesz edytowac ? (1-tytul 2-kalorie 3-skladniki 4-receptura) :");
            int w = in.nextInt();
            switch(w){
                case 1:
                    System.out.println("Podaj tytul przepisu :");
                    in.nextLine();
                    opis = in.nextLine();
                    break;
                case 2:
                    System.out.println("Podaj wartosc kaloryczna :");
                    kalorie = in.nextDouble();
                    break;
                case 3:
                    ls.edytuj();
                    break;
                case 4:
                    System.out.println("Podaj recepture :");
                    in.nextLine();
                    receptura = in.nextLine();
                    break;
                default:
                    System.out.println("Podano bledna opcje !");
                    edytuj();
                    break;
            }
        }catch(InputMismatchException e){
            System.out.println("Podano bledna opcje !");
            edytuj();
        }
    }
    
    public void wyswietl(){
        System.out.println("=========");
        System.out.println("Tytul przepisu - "+opis);
        System.out.println("Wartosc kaloryczna - "+kalorie+" kCal");
        System.out.println("Lista skladnikow : ");
        ls.wyswietl();
    }
}
