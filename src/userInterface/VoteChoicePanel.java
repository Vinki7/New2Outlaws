package userInterface;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the content of the VoteChoicePanel. It contains a text field for username and a button for voting.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class VoteChoicePanel extends JPanel implements PanelManager{
    private JLabel username = new JLabel("Type username here:");

    private JTextField inputUsername = new JTextField(20);

    private JButton giveVote = new JButton("Vote");

    /**
     * Constructor of the VoteChoicePanel class. It initializes the content of the panel.
     */
    public VoteChoicePanel(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.username.setHorizontalAlignment(SwingConstants.RIGHT);
        this.add(this.username);

        this.inputUsername.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.inputUsername);

        this.giveVote.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.giveVote);
    }

    /**
     * This method resets the vote fields.
     */
    @Override
    public void reset(){
        this.inputUsername.setText("");
    }

    /**
     * This method returns the username from the username field.
     * 
     * @return username from the username field
     */
    public JTextField getInputUsername(){
        return this.inputUsername;
    }

    /**
     * This method returns the instance of the vote button.
     * 
     * @return vote button
     */
    public JButton getGiveVote(){
        return this.giveVote;
    }

}
