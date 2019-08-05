package server.gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;



public class AdminPanel extends JPanel {

    //private JPanel adminPanel;
    private JTabbedPane leftPane;   //product and category panes
    private JTabbedPane rightPane;  // users and employees panes
    private JPanel imagesPanel;


    public AdminPanel() {

        super(new GridLayout(1,2));
        
        
        leftPane = new JTabbedPane();
        rightPane = new JTabbedPane();

        leftPane.setBorder(BorderFactory.createTitledBorder("Marchandises"));
        rightPane.setBorder(BorderFactory.createTitledBorder("Comptes"));

        // left panel
        JPanel leftProductPane = new JPanel();
        JPanel leftCatPane = new JPanel();

        leftPane.addTab("Catégories", null,  leftCatPane,
        "Liste des catégories de produits disponibles");
        leftPane.addTab("Produits", null, leftProductPane,
        "Liste des produits disponible dans la BD");

        imagesPanel = new  JPanel();
        JScrollPane scroll = new JScrollPane(imagesPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
                                                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 0, 930, 610);
        //imagesPanel.addMouseListener(new PopClickListener());
        //imagesPanel.setComponentPopupMenu(new PopUpMenu());
        //imagesPanel.setInheritsPopupMenu(true);

        /*
        setSize(930, 610);
        imagesPanel.setLayout(null); //pas de layout
        for (int i = 0; i < 50; i++) {
            JButton b = new JButton("Button n°" + i);
            b.setBounds(0, i * 25, this.getWidth(), 25);
            b.addMouseListener(new PopClickListener());
            imagesPanel.add(b);
        }
        imagesPanel.setPreferredSize(new Dimension(this.getWidth(), 50*25));//je décide de la taille moi même !
        */
        leftCatPane.add(scroll);

        // right panel
        JPanel rightClientPane = new JPanel();
        JPanel rightEmplPane = new JPanel();

        rightPane.addTab("Clients", null,  rightClientPane,
        "Liste des comptes client");
        rightPane.addTab("Employés", null, rightEmplPane,
        "Liste des comptes employés");

        // adminPanel = new JPanel(false);
        // JLabel filler = new JLabel("System Administation Panel");
        // filler.setHorizontalAlignment(JLabel.CENTER);
        // adminPanel.setLayout(new GridLayout(1, 1));
        // adminPanel.add(filler);

        Dimension panelMinimumSize = new Dimension(240 , 160);

        setMinimumSize(panelMinimumSize);

        add(leftPane, BorderLayout.CENTER);
        add(rightPane, BorderLayout.CENTER);
    }

    public void addMarchandisesListener(ChangeListener changeListener) {
        leftPane.addChangeListener(changeListener);
     } 


     public void addComptesListener(ChangeListener changeListener) {
        rightPane.addChangeListener(changeListener);
        }

}



/*

tabbedPane.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
        }
    });

JPanel panEvent = new JPanel(); //Panel où on place tous les événements
        JScrollPane scroll = new JScrollPane(panEvent, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 0, 930, 610);
        this.add(scroll);//ajout du panel qui contient tous les panel/event
//on a donc un panel avec dedans des panels/event et une scrollbar sur la gauche
 
        setSize(930, 610);
        panEvent.setLayout(null); //pas de layout
        for (int i = 0; i < 50; i++) {
            JButton b = new JButton("Button n°" + i);
            b.setBounds(0, i * 25, this.getWidth(), 25);
            panEvent.add(b);
        }
        panEvent.setPreferredSize(new Dimension(this.getWidth(), 50*25));//je décide de la taille moi même !
        setVisible(true);

        */


