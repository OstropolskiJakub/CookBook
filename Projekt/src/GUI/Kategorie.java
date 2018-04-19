package GUI;

import Logika.GUI_Logic;
import Dane.Kategorie.ListaKategorii;
import Dane.Przepisy.ListaPrzepisow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * poboczne okno aplikacji - dodawanie, usuwanie i przypisywanie przepisów do kategorii
 */
public class Kategorie extends javax.swing.JFrame implements ActionListener {

    private ListaKategorii lk = new ListaKategorii();
    private ListaPrzepisow lp = new ListaPrzepisow();
    GUI_Logic logika = new GUI_Logic();
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JOptionPane jOptionPane1;
    private DefaultListModel List1Model = new javax.swing.DefaultListModel();
    private DefaultListModel List2Model = new javax.swing.DefaultListModel();
    private DefaultListModel List3Model = new javax.swing.DefaultListModel();

    /**
     *
     * konstruktor z przekazaniem listy przepisow i listy kategorii
     */
    public Kategorie(ListaKategorii x, ListaPrzepisow y) {
        lk = x;
        lp = y;
        initUI();
        setVisible(true);
    }

    private void initUI() {

        List1Model = logika.WczytajPrzepisy(lp.getLista());
        List3Model = logika.WczytajKategorie(lk.getLista());
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>(List1Model);
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>(List2Model);
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>(List3Model);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kategorie");
        setSize(645, 387);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        /**
        * listener listy wykazujący dynamicznie przepisy dla wybranej kategorii
        */
        jList3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int w = jList3.getSelectedIndex();
                if(w != -1){
                    List2Model = logika.PrzepisyDlaKategorii(w, lk.getLista());
                    jList2.setModel(List2Model);
                }
            }
        });

        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 170, 220));

        jScrollPane2.setViewportView(jList2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 170, 220));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 14));
        jButton3.setText("<<");
        jButton3.addActionListener(this);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 60, -1));

        jScrollPane3.setViewportView(jList3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 220));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel1.setText("Kategoria :");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel2.setText("Przepisy w kategorii :");
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14));
        jLabel3.setText("Wszystkie przepisy :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jButton4.setFont(new java.awt.Font("Verdana", 0, 14));
        jButton4.setText("X");
        jButton4.addActionListener(this);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 620, 300));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton2.setText("OK");
        jButton2.addActionListener(this);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 320, -1, -1));

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton5.setText("Dodaj");
        jButton5.addActionListener(this);
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jButton6.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton6.setText("Usuń");
        jButton6.addActionListener(this);
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

    }

    /**
     *
     * Action listener nasłuchujący przycisków
     */
    public void actionPerformed(ActionEvent e) {
        Object akcja = e.getSource();

        if(akcja == jButton2){
            lk.zapisDoPliku();
            dispose();
        }

        else if(akcja == jButton3){
            if((jList1.getSelectedValue() != null) && (jList3.getSelectedIndex() != -1)){
                lk.getLista().get(jList3.getSelectedIndex()).dodajPrzepis(jList1.getSelectedValue());
                List2Model.addElement(jList1.getSelectedValue());
                jList2.setModel(List2Model);
            }
        }
        
        else if(akcja == jButton4){
            if(jList2.getSelectedIndex() != -1){
                lk.getLista().get(jList3.getSelectedIndex()).usunPrzepis(jList2.getSelectedValue());
                List2Model.removeElementAt(jList2.getSelectedIndex());
                jList2.setModel(List2Model);
                
            } 
        }
        
        else if(akcja == jButton5){
            String test = logika.dodajKategorie(); 
            if(test != null && !"".equals(test)){
                List3Model.addElement(test);
                jList3.setModel(List3Model);
                lk.dodaj(test);
            }    
        }
        
        else if(akcja == jButton6){
            if(List3Model.size() != 0){
                int wybor = jList3.getSelectedIndex();
                List3Model.removeElementAt(wybor);
                jList3.setModel(List3Model);
                lk.usun(wybor);
                List2Model.clear();
                jList2.setModel(List2Model);
            } 
        }

    }
}
