package server.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

//import proto.models.*;


public class ServerUI extends JFrame {

    private JTabbedPane tabbedPane;
    private int keyEventCount;
    private int index;

    public ServerUI(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(960 , 640));

        // menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu( "File" );
        JMenu mnuHelp = new JMenu("Help");

        JMenuItem mnuExit = new JMenuItem( "Exit" );

        mnuFile.add(mnuExit);

        // add items to menu bar
        menuBar.add(mnuFile);
        menuBar.add(mnuHelp);

        setJMenuBar(menuBar);

        JPanel basePanel =  new JPanel(new GridLayout(1, 1));

        // panel edge init
        //! panel border definition
        // Border panelEdge = BorderFactory.createEmptyBorder(0,10,10,10);

        // ClientInfoPanel clientInfos = new ClientInfosPanel();
        // Order details and server monitoring panel
        tabbedPane = new JTabbedPane();
        keyEventCount = KeyEvent.VK_1;
        index = 0;

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

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
    }

    public void addTabbedPane(String title, JPanel pane, String description) {
        tabbedPane.addTab(title, null, pane, description);
        tabbedPane.setMnemonicAt(index++, keyEventCount++);
        getContentPane().removeAll();
        getContentPane().add(tabbedPane);
    }

    public void addPane(JPanel panel)
    {
        getContentPane().add(panel);
    }

    public void addLoginPanel(JFrame loginFrame) {
        getContentPane().add(loginFrame);
    }

    public void viewRefresh() {
        getContentPane().repaint();
        getContentPane().revalidate();
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public void showGUI() {
        pack();
        setVisible(true);
    }

}
