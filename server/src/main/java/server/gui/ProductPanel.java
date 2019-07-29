package server.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ProductPanel extends JPanel {
    private JPanel product;
    private String prName;
    private String prDescription;
    int qunatity;
    float prPrice;  
    private JButton increment;
    private JButton decrement;



    private void createStockItem() {
        this.product = new JPanel();

    }

    public JLabel prodImage(String imageLocation) {
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon(imageLocation));
		return image;
	}

/*
    private JPanel CreateJPanel(Product p,String img,User authUser)
    {
       JPanel panelProduct= new JPanel(new FlowLayout(FlowLayout.CENTER,7,8));
       panelProduct.setPreferredSize(new Dimension(200,250));
       ImageIcon icon = new ImageIcon("Images/"+img);
       JLabel label = new JLabel(p.getDescription());

       label.setVerticalTextPosition(JLabel.BOTTOM);
       label.setHorizontalTextPosition(JLabel.CENTER);
       label.setForeground(Color.BLACK);
       label.setIcon(icon);
       label.setForeground(Color.BLUE);
       label.setFont(new Font("Trebuchet", Font.BOLD, 12));
       label.setToolTipText("<HTml>"+p.getName()+"<br> "+p.getDescription());

       JLabel lblprice = new JLabel( "Rs. "+p.getPrice());
       lblprice.setVerticalTextPosition(JLabel.BOTTOM);
       lblprice.setHorizontalTextPosition(JLabel.CENTER);
       JCheckBox jchkBoxHpLap = new JCheckBox("Buy");

       JComboBox jcmbQty = new JComboBox(new Integer[]{1,2,3,4,5,6,7,8,9,10});
       p.setQuantity((Integer)jcmbQty.getSelectedItem());
       //jcmbQty.addActionListener(new ComboListener(p));

      // jchkBoxHpLap.addItemListener(new MyCheckBoxListener(p,authUser,productSel));

       panelProduct.add(label,BorderLayout.NORTH);
       panelProduct.add(lblprice,BorderLayout.CENTER);
       panelProduct.add(jchkBoxHpLap);
       panelProduct.add(jcmbQty);
       panelProduct.setBorder(new LineBorder(Color.cyan,1));

       return panelProduct;
    }
*/

    private  static void createAndShowGUI(String title) {
        //Create and set up the window.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setMinimumSize(new Dimension(960 , 640));

        JPanel product = new JPanel(new BorderLayout());
        //product.setName("Bananas");
        product.setBackground(new Color(235, 232, 217));
        product.setBorder(new EmptyBorder(10, 5, 10, 5));
        
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("img//" + "Bananas" + ".png"));
        image.setToolTipText("<HTml>"+"Bananas"+"<br> " + "This is a banana description in this field please make it loooonnnnggggggg </html>");
        
        product.add(image, BorderLayout.WEST);
        //product.add(new JLabel("Bananas"), BorderLayout.NORTH);
        
        JPanel productInfos = new JPanel(new BorderLayout());
        productInfos.setMinimumSize(new Dimension(80, 40));
        productInfos.setBackground(new Color(235, 232, 217));
        productInfos.setBorder(new EmptyBorder(10, 5, 10, 5));
        productInfos.add (new JLabel("<html><h1>Beetles</h1> Product short description lines for user view</html>"),  BorderLayout.NORTH);
        product.add(productInfos, BorderLayout.CENTER);

        JPanel checkout = new JPanel(new GridLayout(3, 1));
        JLabel checkoutInfo = new JLabel("<html><h1>Quantity / In Stock </h1></html>");
        JLabel checkoutValue = new JLabel("<html><h1> 2 | 250 </h1></html>", SwingConstants.CENTER);
        checkout.setBackground(new Color(235, 232, 217));
        QuantityPanel quantityPanel = new QuantityPanel();
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

    static class QuantityPanel extends JPanel {
        private JTextField textField;
        private JButton incrBtn;
        private JButton decrBtn;
        QuantityPanel() {
            setLayout(new BorderLayout());
            setMinimumSize(new Dimension(10, 1));
            textField = new JTextField("1", 3);
            textField.setHorizontalAlignment(JTextField.CENTER);
            incrBtn = new JButton(new ImageIcon("img//" + "plus2.png"));
            incrBtn.setMargin(new Insets(0, 0, 0, 0));
            incrBtn.setPreferredSize(new Dimension(60, 2));
            decrBtn = new JButton(new ImageIcon("img//" + "minus2.png"));
            decrBtn.setMargin(new Insets(0, 0, 0, 0));
            decrBtn.setPreferredSize(new Dimension(60, 2));
            add(decrBtn, BorderLayout.LINE_START);
            add(textField, BorderLayout.CENTER);
            add(incrBtn, BorderLayout.LINE_END);
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
