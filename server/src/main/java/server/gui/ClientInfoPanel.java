package server.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

// import app.models.*;


/**
* Client list model in panel with details information fields.
* @param args
*/
public class ClientInfoPanel extends JPanel implements ListSelectionListener {
    private JList<String> clientList;
    private DefaultListModel<String> listModel;
    private JTextField clientFirstName;
    private JTextField clientLastName;
    private JTextField clientEmailAddress;
    private JTextField clientPhoneNumber;

    public ClientInfoPanel() {
        super(new BorderLayout());
        listModel = new DefaultListModel<String>();
        //new DefaultListModel<String>();
        listModel.addElement("Mamady KOUROUMA");
        listModel.addElement("Sory KOUROUMA");
        //create list and put it in scroll pane.
        clientList = new JList<String>(listModel);
        clientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clientList.setSelectedIndex(0);
        clientList.addListSelectionListener(this);
        clientList.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(clientList);

        Border panelEdge = BorderFactory.createEmptyBorder(5,5,10,5);
        setBorder(panelEdge);

        TitledBorder titled;

        // Client list
        JPanel clientList = new JPanel();
        //new JPanel(new GridLayout(1, 1), false);
        clientList.setLayout(new BoxLayout(clientList, BoxLayout.PAGE_AXIS));
        titled = BorderFactory.createTitledBorder(" Liste des Clients");
        titled.setTitleJustification(TitledBorder.LEFT);
        titled.setTitlePosition(TitledBorder.DEFAULT_POSITION);

        clientList.setBorder(titled);

        add(Box.createRigidArea(new Dimension(0, 10)));

        clientList.add(listScrollPane, BorderLayout.CENTER);


        //Information client box
        JPanel infos =  new JPanel();
        infos.setLayout(new BoxLayout(infos, BoxLayout.PAGE_AXIS));

        // Prenom
        infos.add(new JLabel("Prenom: ",JLabel.LEFT));
        clientFirstName = new JTextField(15);
        clientFirstName.setEditable(false);
        infos.add(clientFirstName);

        // Nom
        infos.add(new JLabel("Nom: ",JLabel.LEFT));
        clientLastName = new JTextField(15);
        clientLastName.setEditable(false);
        infos.add(clientLastName);

        // Email
        infos.add(new JLabel("Email: ",JLabel.LEFT));
        clientEmailAddress = new JTextField(15);
        clientEmailAddress.setEditable(false);
        infos.add(clientEmailAddress);

        // Phone number
        infos.add(new JLabel("Phone: ",JLabel.LEFT));
        clientPhoneNumber = new JTextField(15);
        clientPhoneNumber.setEditable(false);
        infos.add(clientPhoneNumber);


        titled = BorderFactory.createTitledBorder("Information Client");
        titled.setTitleJustification(TitledBorder.LEFT);
        titled.setTitlePosition(TitledBorder.DEFAULT_POSITION);



        //JLabel label = new JLabel(null, JLabel.CENTER);
        //comp.add(label);
        infos.setBorder(titled);

        add(Box.createRigidArea(new Dimension(0, 10)));

        //add panels to main
        add(clientList, BorderLayout.CENTER);
        add(infos, BorderLayout.PAGE_END);
        
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (clientList.getSelectedIndex() == -1) {

            } else {
            //Selection, enable the fire button.

            }
        }
    }

    public static void main(String args[]){

        JFrame frame = new JFrame("User Infos");
        frame.setSize(new Dimension(200, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClientInfoPanel clientInfoPanel = new ClientInfoPanel();
        frame.add(clientInfoPanel);
        frame.setVisible(true);
    }

}
