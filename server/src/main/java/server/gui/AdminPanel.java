package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  


public class AdminPanel extends JPanel {

    private JPanel adminPanel;
    
    public AdminPanel() {

        setLayout(new BorderLayout());

        adminPanel = new JPanel(false);
        JLabel filler = new JLabel("System Administation Panel");
        filler.setHorizontalAlignment(JLabel.CENTER);
        adminPanel.setLayout(new GridLayout(1, 1));
        adminPanel.add(filler);

        Dimension panelMinimumSize = new Dimension(240 , 160);
        
        adminPanel.setMinimumSize(panelMinimumSize);

        // add splitted panels to main panel
        add(adminPanel, BorderLayout.CENTER);
    }

}
