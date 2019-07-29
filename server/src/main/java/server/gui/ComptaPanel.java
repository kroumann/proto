package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  


public class ComptaPanel extends JPanel {
    private JPanel comptaPanel;
    
    public ComptaPanel() {

        setLayout(new BorderLayout());

        comptaPanel = new JPanel(false);
        JLabel filler = new JLabel("Store comptability Panel");
        filler.setHorizontalAlignment(JLabel.CENTER);
        comptaPanel.setLayout(new GridLayout(1, 1));
        comptaPanel.add(filler);

        Dimension panelMinimumSize = new Dimension(240 , 160);
        
        comptaPanel.setMinimumSize(panelMinimumSize);

        // add splitted panels to main panel
        add(comptaPanel, BorderLayout.CENTER);
    }

}
