package server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.*;

// local import
//import proto.*;
import server.gui.*;
import server.controls.*;



/**
 * This lightweight  server MVC provides a Swing UI for remote mobile app interaction
 * applications. Intended to illustrate receiving and parsing requests
 * and answering client
 *
 * @author sory.kourouma@gmail.com
 */

public class Server {
    private static ServerUI serverUI;
    private static ServerUIControls serverUIControls;
    //private static LoginPanel loginPanel;
    //private static LoginControls loginControls;

    public Server(String title) {
        serverUI = new ServerUI(title);
        //loginPanel = new LoginPanel();


        //loginPanel.setTitle("Login Form");
        //serverUI.addTabbedPane("Admin", loginPanel, "Connexion administration serveur");
        //serverUI.addPane(loginPanel);
    }

    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        serverUI.showGUI();
            }
        });
    }


    public static void main(String args[]) {
        serverUI = new ServerUI("Prototype Interface Serveur");
        serverUIControls = new ServerUIControls(serverUI);
        //loginPanel = new LoginPanel();
        //loginControls = new LoginControls(loginPanel, serverUI);


        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        serverUI.showGUI();
            }
        });
    }
};


/*
public class Server {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
*/
