package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the content of the LoginPanel. It contains text fields for username and password and buttons for login and registration.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class LoginView extends JPanel implements PanelManager {
    private final JTextField usernameField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JButton loginButton = new JButton("Login");

    private final JButton registerButton = new JButton("Register");

    /**
     * Constructor of the LoginView class. It initializes the content of the panel.
     */
    public LoginView(){
        this.setLayout(new GridLayout(3, 1));// 3 x gridRow, 1 x gridCol
        // Username handler
        JLabel username = new JLabel("Username:");
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setVerticalAlignment(SwingConstants.CENTER);
        this.add(username);
        this.usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(usernameField);
        // Password handler
        JLabel password = new JLabel("Password:");
        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setVerticalAlignment(SwingConstants.CENTER);
        this.add(password);
        this.passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(passwordField);
        add(loginButton);
        add(registerButton);
    }

    /**
     * This method resets the login fields.
     */
    @Override
    public void reset(){
        this.usernameField.setText("");
        this.passwordField.setText("");
    }

    /**
     * This method returns the username from the username field.
     * 
     * @return username from the username field
     */
    public String getUsername(){
        return this.usernameField.getText();
    }

    /**
     * This method returns the password from the password field.
     * 
     * @return password from the password field
     */
    public String getPassword(){
        // Creates complete string from list of characters
        return new String(this.passwordField.getPassword());
    }

    /**
     * This method adds an ActionListener to the login button.
     */
    public void addLoginListener(ActionListener listener){
        loginButton.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the register button.
     */
    public void addRegisterListener(ActionListener listener){
        registerButton.addActionListener(listener);
    }
}
