package server.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/*
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
*/

public class ProductPanel extends JPanel {
    private JPanel product;
    private String prName;
    private String fullDescription;
    private String shortDescription;
    private String imagePath;
    int quantity;
    float prPrice;

    private JButton increment;
    private JButton decrement;
    private JButton editBtn;
    private JButton saveBtn;
    private JTextField priceField;
    private JTextField quantityField;

    public enum ProductType {
        COMMAND,
        STOCK
    }


    public ProductPanel(String name, String imagePath, String shortDesc, String fullDesc, float price, int quantity, ProductType type) {
        product = new JPanel();
        this.prName = name;
        this.imagePath = imagePath;
        this.shortDescription = shortDesc;
        this.fullDescription = fullDesc;
        this.prPrice = price;
        this.quantity = quantity;

        product.setBackground(new Color(202, 204, 206));
        product.setBorder(new EmptyBorder(10, 5, 10, 5));
        product.setPreferredSize(new Dimension(960, 80));
        product.setMaximumSize(new Dimension(960, 110));

        if (type == ProductType.COMMAND) {
            createCommandItem();
        } else if (type == ProductType.STOCK) {
            createStockItem();
        }
    }

    void createStockItem() {

        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(imagePath));
        image.setToolTipText("<HTml>"+ prName +"<br> " + fullDescription +"</html>");
        product.add(image, BorderLayout.WEST);
        // infos panels
        JPanel productInfos = new JPanel(new BorderLayout());
        productInfos.setPreferredSize(new Dimension(80, 40));
        productInfos.setBackground(new Color(235, 232, 217));
        productInfos.setBorder(new EmptyBorder(10, 5, 10, 5));
        productInfos.add (new JLabel("<html><h1>" + prName + "</h1>" + shortDescription + "</html>"),  BorderLayout.NORTH);
        product.add(productInfos, BorderLayout.CENTER);

        JPanel checkout = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0 ;
        gbc.insets = new Insets(4, 4, 4, 4);

        editBtn = new JButton("Edit");
        saveBtn =  new JButton("Save");
        priceField = new JTextField(String.valueOf(prPrice));
        quantityField = new JTextField(String.valueOf(quantity));
        priceField.setEnabled(false);
        quantityField.setEnabled(false);

        checkout.add(new JLabel("<html><h3> Stock: </h3></html>", SwingConstants.CENTER), gbc);
        gbc.gridx++;
        checkout.add(quantityField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        checkout.add(new JLabel("<html><h3> Price (GNF): </h3></html>", SwingConstants.CENTER), gbc);
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        add(priceField, gbc);

        checkout.setBackground(new Color(235, 232, 217));
        checkout.setPreferredSize(new Dimension(160, 10));

        product.add(checkout, BorderLayout.EAST);
    }

    void createCommandItem() {

    }
    public JLabel prodImage(String imageLocation) {
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(imageLocation));
		return image;
    }

    private  static void createAndShowGUI(String title) {
        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setMinimumSize(new Dimension(960 , 640));

        JPanel product = new JPanel(new BorderLayout());
        //product.setName("Bananas");
        product.setBackground(new Color(202, 204, 206));
        product.setBorder(new EmptyBorder(10, 5, 10, 5));
        product.setPreferredSize(new Dimension(960, 80));
        product.setMaximumSize(new Dimension(960, 110));

        JLabel image = new JLabel();
        //image.setIcon(new ImageIcon("img//" + "Bananas" + ".png"));
        image.setToolTipText("<HTml>"+"Bananas"+"<br> " + "This is a banana description in this field please make it loooonnnnggggggg </html>");

        product.add(image, BorderLayout.WEST);
        //product.add(new JLabel("Bananas"), BorderLayout.NORTH);

        JPanel productInfos = new JPanel(new BorderLayout());
        productInfos.setPreferredSize(new Dimension(80, 40));
        productInfos.setBackground(new Color(235, 232, 217));
        productInfos.setBorder(new EmptyBorder(10, 5, 10, 5));
        productInfos.add (new JLabel("<html><h1>Beetles</h1> Product short description lines for user view</html>"),  BorderLayout.NORTH);
        product.add(productInfos, BorderLayout.CENTER);

        JPanel checkout = new JPanel(new GridLayout(3, 1));
        JLabel checkoutInfo = new JLabel("<html><h3> In Stock </h3></html>", SwingConstants.CENTER);
        JLabel checkoutValue = new JLabel("<html><h2> 250 </h2></html>", SwingConstants.CENTER);
        checkout.setBackground(new Color(235, 232, 217));
        QuantityPanel quantityPanel = new QuantityPanel();
        checkout.setPreferredSize(new Dimension(160, 10));
        checkout.add(checkoutInfo);
        checkout.add(checkoutValue);
        checkout.add(quantityPanel);


       /* JPanel checkout = new JPanel(new BorderLayout());
		JPanel checkoutButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel checkoutInfo = new JPanel(new FlowLayout());
        checkoutInfo.add(new JLabel("$" + "250"));
        checkoutInfo.add(new JLabel("Amount: " + "25"));*/
		/*if (Quantity == 0) {
			checkoutInfo.add(new JLabel("REMOVE?"));
		} else {
			checkoutInfo.add(new JLabel("Amount: " + Quantity));
		}
		checkoutButtons.add(incrementCartButton(StockIncrementListener));
		checkoutButtons.add(decrementCartButton(StockDecrementListener));*/
		//checkout.add(checkoutInfo, BorderLayout.NORTH);
		//checkout.add(checkoutButtons, BorderLayout.SOUTH);
		//product.setBackground(new Color(235, 232, 217));
		product.add(checkout, BorderLayout.EAST);


        //Add content to the window.
        frame.add(product, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return product;
    }

    static class QuantityPanel extends JPanel {
        private JTextField textField;
        private UserButton incrBtn;
        private UserButton decrBtn;

        QuantityPanel() {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(120, 10));
            textField = new JTextField("1", 3);
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setPreferredSize(new Dimension(60, 10));

            textField.addKeyListener(new KeyAdapter() {
                public void keyReleased(KeyEvent ev) {
                    try {
                        long number = Long.parseLong(textField.getText());
                        if (number > 100)
                        {
                            number = 100;
                            textField.setText(String.valueOf(number));
                        }
                        revalidate();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(getRootPane(), "Only Numbers Allowed");
                        textField.setText("1");
                    }
                }
            });

            incrBtn = new UserButton("+", new Color(0, 153, 0), new Color(0, 255, 0));
            incrBtn.setMargin(new Insets(0, 0, 0, 0));
            incrBtn.setPreferredSize(new Dimension(40, 10));
            incrBtn.setFont(new Font("Arial", Font.BOLD, 32));
            incrBtn.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ev) {
                    try {
                        int number = Integer.parseInt(textField.getText());
                        if (number < 100)
                        {
                            number ++;
                            textField.setText(String.valueOf(number));
                        }
                        revalidate();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(getRootPane(), "Product values: 1 - 99");
                        textField.setText("1");
                    }
                }
            });

            decrBtn = new UserButton("-", new Color(204, 204, 0), new Color(255, 255, 0));
            decrBtn.setMargin(new Insets(0, 0, 0, 0));
            decrBtn.setPreferredSize(new Dimension(40, 10));
            decrBtn.setFont(new Font("Arial", Font.BOLD, 45));
            decrBtn.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent ev) {
                    try {
                        int number = Integer.parseInt(textField.getText());
                        if (number > 1)
                        {
                            number --;
                            textField.setText(String.valueOf(number));
                        }
                        revalidate();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(getRootPane(), "Product values: 1 - 99");
                        textField.setText("1");
                    }
                }
            });

            add(decrBtn, BorderLayout.LINE_START);
            add(textField, BorderLayout.CENTER);
            add(incrBtn, BorderLayout.LINE_END);
        }

        int getQuantity() {
            return Integer.parseInt(textField.getText());
        }
    }



    static class UserButton extends JButton {

        private Color hoverBackgroundColor;
        private Color pressedBackgroundColor;

        public UserButton() {
            super();
        }

        public UserButton(String text, Color bgColor, Color clickedColor) {
            super(text);
            super.setContentAreaFilled(false);
            this.setBackground(bgColor);
            this.hoverBackgroundColor = bgColor.brighter();
            this.pressedBackgroundColor = clickedColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }

        public Color getHoverBackgroundColor() {
            return hoverBackgroundColor;
        }

        public void setHoverBackgroundColor(Color hoverBackgroundColor) {
            this.hoverBackgroundColor = hoverBackgroundColor;
        }

        public Color getPressedBackgroundColor() {
            return pressedBackgroundColor;
        }

        public void setPressedBackgroundColor(Color pressedBackgroundColor) {
            this.pressedBackgroundColor = pressedBackgroundColor;
        }
    }


    public void runServerUI(String sName) {
                //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI(sName);
            }
        });
    }


    public static void main(String args[]){

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI("Serveur");
            }
        });
    }
}
