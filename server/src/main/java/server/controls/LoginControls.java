package server.controls;

import java.awt.event.*;
import javax.swing.*;

import server.controls.ServerUIControls;
import server.gui.*;



 public class LoginControls {

    private LoginPanel loginPanel;
    private ServerUI serverUI;
    private ServerUIControls serverUIControls;
    private AdminPanel adminPanel;
    private CommandsPanel commandsPanel;
    private StocksPanel stocksPanel;
    private ComptaPanel comptaPanel;

    private AdminControls adminControls;

    public LoginControls(LoginPanel loginPanel, ServerUI serverUI, ServerUIControls serverUIControls) {
        this.loginPanel = loginPanel;
        this.serverUI = serverUI;
        this.serverUIControls = serverUIControls;
        loginPanel.addLoginListener(new LoginButtonListener());
        loginPanel.addResetListener(new ResetBtnListener());
        loginPanel.addCheckBoxListener(new CheckBoxListener());
    }

    class LoginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            String userText;
            String pwdText;
            userText = loginPanel.getUserName();
            pwdText = new String(loginPanel.getUserPassword());

            if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {
                serverUIControls.loginGranted();
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
