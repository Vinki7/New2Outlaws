package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the content of the RegisterPanel. It contains text fields for username and password and a button for registration.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class RegisterView extends JPanel implements PanelManager{
    private final JTextField usernameField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JPasswordField repeatPasswordField = new JPasswordField(20);
    private final JButton loginButton = new JButton("Login");

    private final JButton registerButton = new JButton("Register");

    /**
     * Constructor of the RegisterView class. It initializes the content of the panel.
     */
    public RegisterView(){
        this.setLayout(new GridLayout(4, 1));
        // Username handler
        JLabel username = new JLabel("Username:");
        username.setHorizontalAlignment(SwingConstants.CENTER);
        username.setVerticalAlignment(SwingConstants.CENTER);
        this.add(username);
        this.add(usernameField);
        // First password handler
        JLabel firstPassword = new JLabel("Password");
        firstPassword.setHorizontalAlignment(SwingConstants.CENTER);
        firstPassword.setVerticalAlignment(SwingConstants.CENTER);
        this.add(firstPassword);
        this.add(passwordField);
        // Second password
        JLabel secondPassword = new JLabel("Repeat password:");
        secondPassword.setHorizontalAlignment(SwingConstants.CENTER);
        secondPassword.setVerticalAlignment(SwingConstants.CENTER);
        this.add(secondPassword);
        this.add(repeatPasswordField);
        add(registerButton);
        add(loginButton);
    }

    /**
     * This method resets the register fields.
     */
    @Override
    public void reset(){
        this.repeatPasswordField.setText("");
        this.passwordField.setText("");
        this.usernameField.setText("");
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
        return new String(this.passwordField.getPassword());
    }

    /**
     * This method returns the repeated password from the repeated password field.
     * 
     * @return repeated password from the repeated password field
     */
    public String getRepeatedPassword(){
        return new String((this.repeatPasswordField.getPassword()));
    }

    /**
     * This method adds an ActionListener to the register button.
     */
    public void addRegisterListener(ActionListener listener){
        registerButton.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the login button.
     */
    public void addLoginListener(ActionListener listener){
        loginButton.addActionListener(listener);
    }
}
