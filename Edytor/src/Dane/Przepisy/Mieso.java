package Dane.Przepisy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mieso extends Skladnik{
    private String typ;
    
    public void set(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj nazwe : ");
            nazwa = in.nextLine();
            System.out.println("Podaj ilosc : ");
            ilosc = in.nextLine();
            System.out.println("Podaj typ miesa : ");
            typ = in.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Wprowadzono bledne dane !!!");
            set();
        }
    }
    
    public void printSkladnik(){
        ArrayList s = new ArrayList();
        s.add(nazwa); s.add(ilosc); s.add(typ);
        System.out.println("Nazwa - "+s.get(0));
        System.out.println("Ilosc - "+s.get(1));
        System.out.println("Typ miesa - "+s.get(2));
    }

    public String generuj(){
        return nazwa+" - "+ilosc+"\ntyp : "+typ;
    }
    
}
