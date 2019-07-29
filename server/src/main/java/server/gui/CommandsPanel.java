package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  


public class CommandsPanel extends JPanel {
    private ClientInfoPanel  clientInfoPanel;
    private JPanel productPanel;

    public CommandsPanel() {
        this.clientInfoPanel = new ClientInfoPanel();
        setLayout(new BorderLayout());

        productPanel = new JPanel(false);
        productPanel.setLayout(new FlowLayout());
               
        JLabel filler = new JLabel("Command Product Panel");
        filler.setHorizontalAlignment(JLabel.CENTER);
        //productPanel.setLayout(new GridLayout(1, 1));
        //productPanel.add(filler);
        productPanel.add(filler);
        JPanel panel = new JPanel();
        panel.add(new JLabel("PRODUCT PANEL"));

        addToListProduct(panel);

        //! panneau de gauche pour les infos clients, droite pour les details
        JSplitPane splitPane =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, clientInfoPanel, new JScrollPane(productPanel));
        Dimension panelMinimumSize = new Dimension(240 , 160);
        splitPane.setOneTouchExpandable(false);
        splitPane.setDividerLocation(180);
        clientInfoPanel.setMinimumSize(panelMinimumSize);
        productPanel.setMinimumSize(panelMinimumSize);

        // add splitted panels to main panel
        add(splitPane, BorderLayout.CENTER);
        
    }

    public void addToListProduct(JPanel prodPanel) {

        productPanel.add(prodPanel);
    }
}
