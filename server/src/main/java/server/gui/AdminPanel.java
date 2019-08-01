package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class AdminPanel extends JPanel {

    //private JPanel adminPanel;
    private JTabbedPane leftPane;   //product and category panes
    private JTabbedPane rightPane;  // users and employees panes


    public AdminPanel() {

        super(new GridLayout(1,2));
        //setLayout(new BorderLayout());

        leftPane = new JTabbedPane();
        rightPane = new JTabbedPane();

        leftPane.setBorder(BorderFactory.createTitledBorder("Marchandises"));
        rightPane.setBorder(BorderFactory.createTitledBorder("Comptes"));


        JPanel leftProductPane = new JPanel();
        JPanel leftCatPane = new JPanel();

        leftPane.addTab("Catégories", null,  leftCatPane,
        "Liste des catégories de produits disponibles");
        leftPane.addTab("Produits", null, leftProductPane,
        "Liste des produits disponible dans la BD");

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


        // add splitted panels to main panel
        //add(adminPanel, BorderLayout.CENTER);
    }

}



/*

        // makeTextPanel("Panel #1");
        tabbedPane.addTab("Commande", null, panel1,
                "Informations commande client");
                tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Monitoring", null, panel2,
                "Informations serveur transactions et errors");
                tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);



        //! panneau de gauche pour les infos clients, droite pour les details
        JSplitPane splitPane =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, clientInfos, tabbedPane);
        Dimension panelMinimumSize = new Dimension(240 , 160);
        splitPane.setOneTouchExpandable(false);
        splitPane.setDividerLocation(180);
        clientInfos.setMinimumSize(panelMinimumSize);
        tabbedPane.setMinimumSize(panelMinimumSize);

        // add splitted panels to main panel
        add(splitPane);
        setMinimumSize(new Dimension(680 , 440));

        */
