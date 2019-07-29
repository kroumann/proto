package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  


public class StocksPanel extends JPanel {
    private JPanel stocksPanel;
    
    public StocksPanel() {

        setLayout(new BorderLayout());

        stocksPanel = new JPanel(false);
        JLabel filler = new JLabel("Store Stocks Panel");
        filler.setHorizontalAlignment(JLabel.CENTER);
        stocksPanel.setLayout(new GridLayout(1, 1));
        stocksPanel.add(filler);

        Dimension panelMinimumSize = new Dimension(240 , 160);
        
        stocksPanel.setMinimumSize(panelMinimumSize);

        // add splitted panels to main panel
        add(stocksPanel, BorderLayout.CENTER);
    }

}
