package Dane.Przepisy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ListaPrzepisow implements Serializable {
    ArrayList<Przepis> p = new ArrayList<Przepis>();
    
    public void dodaj(){
        p.add(new Przepis());
        p.get(p.size() - 1).tworz();
        zapisDoPliku();
        menu();
    }
    
    public ArrayList<Przepis> getLista(){
        return p;
    }
    
    public void wyswietl(){
        for(int i=0; i<p.size(); i++){
            System.out.println((i+1) + " :");
            p.get(i).wyswietl();
        }
        menu();
    }
    
    public void edytuj(){
        try{
            if(p.isEmpty())
                throw new Exception();
            Scanner in = new Scanner(System.in);
            System.out.println("Ktory przepis edytowac ? : ");
            int w = in.nextInt();
            p.get(w-1).edytuj();
            zapisDoPliku();
            menu();
        }catch(InputMismatchException | ArrayIndexOutOfBoundsException e){
            System.out.println("Podano bledna opcje !");
            edytuj();
        }catch(Exception e){
            System.out.println("Brak przepisow !");
            menu();
        }
    }
    
    public void usun(){
        try{
            if(p.isEmpty())
                throw new Exception();
            Scanner in = new Scanner(System.in);
            System.out.println("Ktory przepis usunac ? : ");
            int w = in.nextInt();
            System.out.println("Na pewno ? (Wpisz 'TAK' aby potwierdzic.) : ");
            in.nextLine();
            String val = in.nextLine();
            if("TAK".equals(val)){
                p.remove(w-1);
                System.out.println("Usunieto !");
                zapisDoPliku();
                menu();
            } 
            else
                menu();
        }catch(InputMismatchException e){
            System.out.println("Podano bledna opcje !");
            usun();
        }catch(Exception f){
            System.out.println("Brak przepisow !");
            menu();
        }
    }
    
    public void odczytZPliku(){
        try{
            FileInputStream f = new FileInputStream("listaPrzepisow.dat");
            ObjectInputStream o = new ObjectInputStream(f);
            
            p = (ArrayList<Przepis>)o.readObject();
            f.close();
            o.close();
        }catch (IOException | ClassNotFoundException f) {
            System.out.println("Problem przy odczycie !");
        }
    }
    
    public void zapisDoPliku(){
        try{
            FileOutputStream f = new FileOutputStream("listaPrzepisow.dat");
            ObjectOutputStream o = new ObjectOutputStream(f);
            
            o.writeObject(p);
            f.close();
            o.close();
        }catch (IOException f) {
            System.out.println("Problem przy zapisie !");
            menu();
        }
    }
    
    public void menu(){
        try{
            odczytZPliku();
            Scanner in = new Scanner(System.in);
            System.out.println("Co chcesz zrobic ? (1 - dodaj przepis 2 - wyswietl przepisy 3 - edytuj przepis 4 - usun przepis 5 - wyjdz) :");
            int w = in.nextInt();
            switch(w){
                case 1:
                    dodaj();
                    break;
                case 2:
                    wyswietl();
                    break;
                case 3:
                    edytuj();
                case 4:
                    usun();
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Nie ma takiej opcji!");
                    menu();
                    break;
            }
        }catch(Exception e){
            System.out.println("Podano bledna opcje !");
            menu();
        }
    }
}
