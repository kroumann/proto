package server.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  


public class LoginPanel extends JPanel {

    private GridBagConstraints gbc = new GridBagConstraints();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20);
    private final JButton loginButton = new JButton("LOGIN");
    private final JButton resetButton = new JButton("RESET");
    private final JCheckBox showPassword = new JCheckBox("Show Password");


    public LoginPanel() {
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0 ;
        gbc.insets = new Insets(4, 4, 4, 4);

        add(userLabel, gbc);
        gbc.gridx++;
        add(userTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(passwordLabel, gbc);
        gbc.gridx++;
        add(passwordField, gbc);
        gbc.gridx = 1;
        gbc.gridy++;
        add(showPassword, gbc);
        gbc.gridx = 1;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.WEST;
        add(loginButton, gbc);
        //gbc.gridx++;
        gbc.anchor = GridBagConstraints.EAST;
        add(resetButton, gbc);
        //addActionEvent();
    }

    	/**
	 * Scans the username field for a username
	 *
	 * @return username from usernamefield
	 */
	public String getUserName() {
		return userTextField.getText();
	}

	/**
	 * Scans the password field for a password
	 *
	 * @return password from password field
	 */
	public char[] getUserPassword() {
		return passwordField.getPassword();
	}

    public void cleanUserCredential()
    {
        userTextField.setText("");
        passwordField.setText("");
    }

    public void showUserPassword(){
        passwordField.setEchoChar((char)0);
    }

    public void hideUserPassword(){
        char c= (char) 0x2022; //dot inicode
        passwordField.setEchoChar(c); 
    }

    public boolean getCheckBoxState(){
        return showPassword.isSelected();
    }


    public void addLoginListener(ActionListener loginBtnListener) {
        loginButton.addActionListener(loginBtnListener);
    }

    public void addResetListener(ActionListener resetBtnListener) {
        resetButton.addActionListener(resetBtnListener);
    }

    public void addCheckBoxListener(ActionListener checkBoxListener) {
        showPassword.addActionListener(checkBoxListener);
    }

}
