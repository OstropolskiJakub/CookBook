package Dane.Przepisy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Skladnik implements Serializable {
    protected String nazwa;
    protected String ilosc;
    
    public void set(){
        try{
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj nazwe : ");
            nazwa = in.nextLine();
            System.out.println("Podaj ilosc : ");
            ilosc = in.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Wprowadzono bledne dane !!!");
            set();
        } 
    }
    
    public void printSkladnik(){
        ArrayList s = new ArrayList();
        s.add(nazwa); s.add(ilosc);
        System.out.println("Nazwa - "+s.get(0));
        System.out.println("Ilosc - "+s.get(1));
    }
 
    public String generuj(){
        return nazwa+" - "+ilosc;
    }
    
    public String getNazwa(){
        return nazwa;
    }
}
