package server.gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.border.*;
import java.net.*;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

import server.gui.WrapLayout;
import server.models.Category;

import java.awt.*;
import java.awt.event.*;



public class AdminPanel extends JPanel {

    //private JPanel adminPanel;
    private JTabbedPane leftPane;   //product and category panes
    private JTabbedPane rightPane;  // users and employees panes

    JPanel leftProductPane;
    JPanel leftCatPane;
    private CategoryPanel imagesPanel;


    public AdminPanel() {

        super(new GridLayout(1,2));


        leftPane = new JTabbedPane();
        rightPane = new JTabbedPane();

        leftPane.setBorder(BorderFactory.createTitledBorder("Marchandises"));
        rightPane.setBorder(BorderFactory.createTitledBorder("Comptes"));

        // left panel
        leftProductPane = new JPanel();
        leftCatPane = new JPanel();

        leftPane.addTab("Catégories", null,  leftCatPane,
        "Liste des catégories de produits disponibles");
        leftPane.addTab("Produits", null, leftProductPane,
        "Liste des produits disponible dans la BD");

        imagesPanel = new  CategoryPanel();

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

    public void addMarchandisesPaneListener(ChangeListener changeListener) {
        leftPane.addChangeListener(changeListener);
    }


    public void addComptesPaneListener(ChangeListener changeListener) {
        rightPane.addChangeListener(changeListener);
    }

    public int getMarchandisesPaneIndex() {
        return leftPane.getSelectedIndex();
    }

    public int getComptesPaneIndex() {
        return rightPane.getSelectedIndex();
    }

    public void addNewCategoryPanel(Category category) {
        imagesPanel.addItem(category);
    }

    public void showItems() {
        imagesPanel.showPanel();
    }


    class CategoryPanel extends JPanel{
        private JPanel imagesPane;
        private JScrollPane scrollPane;
        private int ybound = 0;
        CategoryPanel() {
            imagesPane = new  JPanel();
            imagesPane.setLayout(new WrapLayout());
            imagesPane.setBackground(new Color(255, 255, 255));
            imagesPane.setBounds(100, 100, 100, 100);

            // imagesPane.setLayout(new BoxLayout(imagesPane, BoxLayout.CENTER));
            // imagesPane.setAutoscrolls(true);

            // scrollPane = new JScrollPane(imagesPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            //                                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            // scrollPane.setBounds(50, 30, 930, 610);
            //imagesPanel.addMouseListener(new PopClickListener());
            //imagesPanel.setComponentPopupMenu(new PopUpMenu());
            //imagesPanel.setInheritsPopupMenu(true);
            //setSize(930, 610);
            //imagesPane.setLayout(null); //pas de layout
            //imagesPane.setPreferredSize(new Dimension(this.getWidth(), 50*25));

            //imagesPane.add(scrollPane);

        }

        public void addItem(Category category) {

            JPanel catPanel = new JPanel(new BorderLayout());
            //catPanel.setBackground(new Color(202, 204, 206));
            catPanel.setBorder(new EmptyBorder(10, 10, 10, 5));
            catPanel.setPreferredSize(new Dimension(960, 165));
            catPanel.setMaximumSize(new Dimension(960, 110));

            JLabel catImage = new JLabel();
          /*  try {
                URL url = new URL(category.getImageUrl());
                final BufferedImage image = resize(url, new Dimension(180, 160));
                catImage.setIcon(new ImageIcon(image));
                catPanel.add(catImage, BorderLayout.WEST);
            } catch (Exception e) {
                e.printStackTrace();
            } */
            
            try{
                URL url = getClass().getResource("resources/images/gliphy.gif"); //new URL(category.getImageUrl());
                Image image = Toolkit.getDefaultToolkit().getImage(url);
                Image newimg = image.getScaledInstance(180, 160,  java.awt.Image.SCALE_SMOOTH); // resize it
                catImage.setIcon(new ImageIcon(newimg));
                catPanel.add(catImage, BorderLayout.WEST);
                new ImageWorker(new URL(category.getImageUrl()), catImage).execute();
            }catch(Exception ex){
                ex.printStackTrace();
            }

            JPanel catInfos = new JPanel(new BorderLayout());
            catInfos.setPreferredSize(new Dimension(80, 40));
            //catInfos.setBackground(new Color(235, 232, 217));
            catInfos.setBorder(new EmptyBorder(10, 5, 10, 5));
            catInfos.add (new JLabel("<html><h1>" + category.getName() + "</h1>" + category.getDescription() + "</html>"),  BorderLayout.NORTH);
            catPanel.add(catInfos, BorderLayout.CENTER);

            imagesPane.add(catPanel, BorderLayout.CENTER);
        }

        public void showPanel() {
            leftCatPane.add(imagesPane, BorderLayout.CENTER);
        }


        class ImageWorker extends SwingWorker<ImageIcon, Void>{

            URL imageURL;
            ImageIcon imageIcon;
            JLabel imageLabel;
            
            public ImageWorker(URL imageURL, JLabel imageLabel){
                this.imageURL = imageURL;
                this.imageLabel = imageLabel;
            }
            
            @Override
            protected ImageIcon doInBackground() throws Exception {
                imageIcon = new ImageIcon(imageURL);
                Image rawimageIcon = imageIcon.getImage();
                Image newimg = rawimageIcon.getScaledInstance(180, 160,  java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                return imageIcon;
            }
            
            @Override
            protected void done() {
                // leave as default zagg shield icon if no brand icon is returned by api
                if (imageIcon.getIconWidth() == 32 && imageIcon.getIconHeight() == 32) {
                    imageLabel.setIcon(imageIcon);
                }
              }
            }
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


