package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the content of the DifficultyChoicePanel. It contains buttons for each difficulty. Implements {@link PanelManager} interface to reset values.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */

public class DifficultyChoice extends JPanel implements PanelManager {
    private JRadioButton amateur = new JRadioButton("Amateur");
    private JRadioButton rookie = new JRadioButton("Rookie");
    private JRadioButton pro = new JRadioButton("Pro");

    private ButtonGroup difficGroup = new ButtonGroup();

    private JButton submit = new JButton("Submit choice");

    /**
     * Constructor of the DifficultyChoice class. It initializes the content of the panel.
     */
    public DifficultyChoice(){
        difficGroup.add(amateur);
        difficGroup.add(rookie);
        difficGroup.add(pro);

        // Add content
        this.setLayout(new GridLayout(0, 1)); // One column, any number of rows
        JLabel header = new JLabel("Choose difficulty:");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(header);
        // Add buttons
        amateur.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(amateur);
        rookie.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(rookie);
        pro.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(pro);
        // Add submit
        submit.setSize(200, 50);
        submit.setHorizontalAlignment(SwingConstants.CENTER);
        submit.setVerticalAlignment(SwingConstants.CENTER);
        JPanel southContainer = new JPanel(new FlowLayout());
        southContainer.add(submit);
        this.add(southContainer);
    }

    /**
     * This method resets the selection of the difficulty.
     */
    @Override
    public void reset(){
        this.difficGroup.clearSelection();
    }

    /**
     * This method adds an ActionListener to the submit button.
     */
    public void addSubmitListener(ActionListener listener){
        this.submit.addActionListener(listener);
    }

    /**
     * This method returns instance of the JButton representing the submit button.
     * 
     * @return JButton submit button
     */
    public JRadioButton getAmateur(){
        return amateur;
    }

    /**
     * This method returns the instance of the JRadioButton representing the Rookie difficulty.
     * 
     * @return instance of JRadioButton representing the Rookie difficulty
     */
    public JRadioButton getRookie(){
        return rookie;
    }

    /**
     * This method returns the instance of the JRadioButton representing the Pro difficulty.
     * 
     * @return instance of JRadioButton representing the Pro difficulty
     */
    public JRadioButton getPro(){
        return pro;
    }

    /**
     * This method adds an ActionListener to the Amateur button.
     * 
     * @param listener instance of ActionListener to be added to the Amateur button
     */
    public void addAmateurListener(ActionListener listener){
        this.amateur.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Rookie button.
     * 
     * @param listener instance of ActionListener to be added to the Rookie button
     */
    public void addRookieListener(ActionListener listener){
        this.rookie.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Pro button.
     * 
     * @param listener instance of ActionListener to be added to the Pro button
     */
    public void addProListener(ActionListener listener){
        this.pro.addActionListener(listener);
    }


}
