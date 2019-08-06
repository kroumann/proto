package server.gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.*;
import java.net.*;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;

import server.Server;
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
    private List<Category>categories;

    private AbstractAction newCategory;
    private AbstractAction editCategory;
    private AbstractAction deleteCatory;


    public AdminPanel() {

        super(new GridLayout(1,2));


        leftPane = new JTabbedPane();
        rightPane = new JTabbedPane();

        leftPane.setBorder(BorderFactory.createTitledBorder("Marchandises"));
        rightPane.setBorder(BorderFactory.createTitledBorder("Comptes"));

        // left panel
        leftProductPane = new JPanel();
        leftCatPane = new JPanel();
        leftCatPane.setLayout(new BorderLayout());
        leftCatPane.setBorder(new EmptyBorder(10, 5, 10, 5));

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

        //! init categoryList
        categories = new ArrayList<Category>();

        Dimension panelMinimumSize = new Dimension(240 , 160);
        setMinimumSize(panelMinimumSize);

        add(leftPane, BorderLayout.CENTER);
        add(rightPane, BorderLayout.CENTER);
    }

    public void addNewAbstractAction(AbstractAction nAction) {
        newCategory =  nAction;
    }

    public void addEditAbstractAction(AbstractAction nAction) {
        editCategory = nAction;
    }

    public void addDeleteAbstractAction(AbstractAction nAction) {
        deleteCatory = nAction;
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

    public void addCategories(List<Category> categories) {

        for(Category cat : categories) {
            addNewCategoryPanel(cat);
        }
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
        }

        public void addItem(Category category) {

            if (!categories.contains(category)) {

                categories.add(category);

                JPanel catPanel = new CategoryItem(category); // new JPanel(new BorderLayout());
                //catPanel.setBackground(new Color(202, 204, 206));
               /* catPanel.setBorder(new EmptyBorder(10, 10, 10, 5));
                catPanel.setPreferredSize(new Dimension(960, 160));
                catPanel.setMaximumSize(new Dimension(960, 110));
                */
                JLabel catImage = new JLabel();

                try{
                    Image image = ImageIO.read(this.getClass().getClassLoader().getResource("images/giphy.gif")); //default image
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
                imagesPane.repaint();
                imagesPane.revalidate();
            }
        }

        public void showPanel() {
            JScrollPane scroll = new JScrollPane(imagesPane);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            leftCatPane.add(scroll, BorderLayout.CENTER);
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
                if (imageIcon.getIconWidth() == 180 && imageIcon.getIconHeight() == 160) {
                    imageLabel.setIcon(imageIcon);
                    leftPane.repaint();
                }
            }
        }

        class CategoryItem extends JPanel {
            Category category;
            private Color background;
            CategoryItem(Category category) {
                super(new BorderLayout());
                //catPanel.setBackground(new Color(202, 204, 206));
                setBorder(new EmptyBorder(10, 10, 10, 5));
                setPreferredSize(new Dimension(960, 160));
                setMaximumSize(new Dimension(960, 110));
                this.category = category;

                addMouseListener(new MouseAdapter() {
                    public void mouseEntered(MouseEvent e) {
                        background = getBackground();
                        setBackground(new Color(100,149,237));
                        repaint();
                    }
                });

                addMouseListener(new MouseAdapter() {
                    public void mouseExited(MouseEvent e) {
                        setBackground(background);
                        repaint();
                    }
                });

                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if (e.isPopupTrigger())
                            doPop(e);
                    }
                });
                addMouseListener(new MouseAdapter() {
                    public void mouseReleased(MouseEvent e) {
                        if (e.isPopupTrigger())
                            doPop(e);
                    }
                });
            }

            private void doPop(MouseEvent e) {
                PopUpMenu menu = new PopUpMenu();
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        class PopUpMenu extends JPopupMenu {
            JMenuItem newItem;
            JMenuItem editItem;
            JMenuItem deleteItem;

            public PopUpMenu() {
                newItem = new JMenuItem(newCategory);
                add(newItem);

                editItem = new JMenuItem(new AbstractAction("Modifier") {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                add(editItem);

                deleteItem = new JMenuItem(new AbstractAction("Supprimer") {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                add(deleteItem);
            }
        }


/*
        class Hover extends MouseAdapter {
            private Color background;

            private String lblStr = "";

            public Hover( String lblStr ) {
                this.lblStr = lblStr;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back
                JLabel lbl = (JLabel) e.getComponent();
                lbl.setForeground(new Color(255, 127, 80));
                lbl.setText( String.format( "<html><u>%s</u></html>", lblStr) );
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel lbl = (JLabel) e.getComponent();
                lbl.setText( String.format( "<html><u>%s</u><</html>", lblStr ) );
                lbl.setForeground( new Color(245, 245, 245) );
            }
        }
*/


    }
}
