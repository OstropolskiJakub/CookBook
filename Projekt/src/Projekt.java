import GUI.Main;

public class Projekt {
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
                   public void run() {
                       Main main = new Main();
                   }
               }); 
    }
}
