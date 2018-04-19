package GUI;

import Logika.GUI_Logic;
import Dane.Kategorie.ListaKategorii;
import Dane.Przepisy.ListaPrzepisow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * główne okno aplikacji
 */
public class Main extends javax.swing.JFrame implements ActionListener {
    
    Kategorie kategorie;
    private ListaKategorii lk = new ListaKategorii();
    private ListaPrzepisow lp = new ListaPrzepisow();
    GUI_Logic logika = new GUI_Logic();
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;  
    private DefaultListModel List1Model = new javax.swing.DefaultListModel();
    
    /**
     *
     */
    public Main(){
        initUI();
        setVisible(true);
    }
                   
    /**
     * inicjalizacja interfejsu graficznego
     */
    public void initUI() {

        
        lk.odczytZPliku();
        // ewentualne lk.wyswietlWszystko() , aby sprawdzic wczytane przepisy.
        lp.odczytZPliku();
        List1Model = logika.WczytajPrzepisy(lp.getLista());
        
        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(List1Model);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Książka kucharska");
        setBounds(new java.awt.Rectangle(0, 0, 732, 588));
        setResizable(false);
        setSize(795, 613);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        // korygowanie na starcie kategorii "Wszystkie".
        lk = logika.korygujListe(lk, lp);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setDividerSize(15);
        
        /*
        * listener odpowiedzialny za generowanie przepisu w polu tekstowym
        * po wybraniu przepisu na liście i ustawienie labaela przy tytule
        */
        jList1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                String w = jList1.getSelectedValue();
                if(w != null){
                    jTextArea1.setText(logika.generujPrzepis(w, lp.getLista()));
                    jLabel4.setText(w);
                }
            }
        });
        
        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Verdana", 0, 14));
        jScrollPane2.setViewportView(jTextArea1);

        jSplitPane1.setRightComponent(jScrollPane2);

        jPanel2.add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 730, 430));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel1.setText("Kategoria :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jComboBox1.setModel(logika.WczytajKategorieDlaComboBoxa(lk.getLista()));
        jComboBox1.addActionListener(this);
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 100, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel2.setText("Dostępne przepisy :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel3.setText("Tytuł :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 200, 20));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton2.setText("Kategorie...");
        jButton2.addActionListener(this);
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton3.setText("Dodaj/Edytuj przepisy...");
        jButton3.addActionListener(this);
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jButton4.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton4.setText("Szukaj...");
        jButton4.addActionListener(this);
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 770, 530));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton1.setText("Wyjdź");
        jButton1.addActionListener(this);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 550, -1, -1));
        setVisible(true);
    }
    
    /**
     * "odświeżanie" aplikacji po zmianach w przepisach i kategoriach
     */
    public void reset(){
        lk.odczytZPliku();
        lp.odczytZPliku();
        jComboBox1.setModel(logika.WczytajKategorieDlaComboBoxa(lk.getLista()));
    }
 
    /**
     * listener dla przycisków
     */
    public void actionPerformed(ActionEvent e) {
        Object akcja = e.getSource();
        
        if(akcja == jComboBox1){
            
            int w = jComboBox1.getSelectedIndex();
                if(w != -1){
                    List1Model = logika.PrzepisyDlaKategorii(w, lk.getLista());
                    jList1.setModel(List1Model);
                }
        }
        
        else if(akcja == jButton1){
            System.exit(0);
        }
        
        else if(akcja == jButton2){
            setEnabled(false);
            kategorie = new Kategorie(lk, lp);
            kategorie.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    reset();
                    setEnabled(true);
                    toFront();
                }
            });
        }
        
        else if(akcja == jButton3){
            logika.odpalEdytor();
        }
        
        else if(akcja == jButton4){
            List1Model = logika.wyszukajPrzepis(lp.getLista());
            jList1.setModel(List1Model);
        }
    }
}
