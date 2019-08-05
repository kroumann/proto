package server.controls;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

import server.controls.AdminControls;
import server.controls.LoginControls;
import server.gui.*;

import server.gui.*;

public class ServerUIControls {

    private ServerUI serverUI;
    //private ServerUIControls serverUIControls;

    private LoginPanel loginPanel;
    private AdminPanel adminPanel;
    private CommandsPanel commandsPanel;
    private StocksPanel stocksPanel;
    private ComptaPanel comptaPanel;

    private Properties properties;

    private AdminControls adminControls;
    private LoginControls loginControls;

    public ServerUIControls(ServerUI serverUI) {

            this.serverUI = serverUI;
            //serverUIControls = new ServerUIControls(serverUI);

            loginPanel = new LoginPanel();
            loginControls =  new LoginControls(loginPanel, serverUI, this);

            adminPanel = new AdminPanel();
            adminControls = new AdminControls(adminPanel, serverUI, this);

            commandsPanel = new CommandsPanel();
            stocksPanel = new StocksPanel();
            comptaPanel =  new ComptaPanel();

            serverUI.addPane(loginPanel);
            serverUI.viewRefresh();
    }

    public void loginGranted() {

        serverUI.addTabbedPane("Admin", adminPanel, "Server Administration pane");
        serverUI.addTabbedPane("Commands", commandsPanel, "client cart details");
        serverUI.addTabbedPane("Stocks", stocksPanel, "Store stocks management");
        serverUI.addTabbedPane("Compta", comptaPanel, "Store Comptability management");
        serverUI.viewRefresh();
    }

    public String getProperty(String name) {

        try (InputStream in = getClass().getResourceAsStream("application.properties")){
            Properties prop = new Properties();
            prop.load(in);
            in.close();
            return prop.containsKey(name) ? prop.getProperty(name):null;
        } catch (IOException e) {
            throw new AssertionError("Could not load application.properties.");
        }

    }


}