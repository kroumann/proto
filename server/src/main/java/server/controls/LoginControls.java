package server.controls;

import java.awt.event.*;
import javax.swing.*;

import server.gui.*;



 public class LoginControls {

    private LoginPanel loginPanel;
    private ServerUI serverUI;
    private AdminPanel adminPanel;
    private CommandsPanel commandsPanel;
    private StocksPanel stocksPanel;
    private ComptaPanel comptaPanel;

    public LoginControls(LoginPanel loginPanel,  ServerUI serverUI) {
        this.loginPanel = loginPanel;
        this.serverUI = serverUI;
        loginPanel.addLoginListener(new LoginButtonListener());
        loginPanel.addResetListener(new ResetBtnListener());
        loginPanel.addCheckBoxListener(new CheckBoxListener());
        serverUI.addPane(loginPanel);
        serverUI.viewRefresh();
    }

    class LoginButtonListener implements ActionListener {
    
        public void actionPerformed(ActionEvent a) {
            String userText;
            String pwdText;
            userText = loginPanel.getUserName();
            pwdText = new String(loginPanel.getUserPassword());
            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {
                adminPanel = new AdminPanel();
                serverUI.addTabbedPane("Admin", adminPanel, "Server Administration pane");
                commandsPanel = new CommandsPanel();
                serverUI.addTabbedPane("Commands", commandsPanel, "client cart details");
                stocksPanel = new StocksPanel();
                serverUI.addTabbedPane("Stocks", stocksPanel, "Store stocks management");
                comptaPanel = new ComptaPanel();
                serverUI.addTabbedPane("Compta", comptaPanel, "Store Comptability management");
                //JOptionPane.showMessageDialog(serverUI, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(serverUI, "Invalid Username or Password");
            }
            serverUI.viewRefresh();
        }
    }

    class ResetBtnListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            loginPanel.cleanUserCredential();
        }
    }

    class CheckBoxListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            if (loginPanel.getCheckBoxState()) {
                loginPanel.showUserPassword();
            } else {
                loginPanel.hideUserPassword();
            }
            serverUI.viewRefresh();
        }
    }

}
