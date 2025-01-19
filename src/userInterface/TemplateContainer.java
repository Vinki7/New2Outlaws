package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class represents the content of the TemplatePanel. It contains a table with data.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class TemplateContainer extends JPanel {
    private final JButton load = new JButton("Load");
    private final JButton save = new JButton("Save");
    private final JButton logOut = new JButton("Logout");
    private final JLabel budgetDisplay = new JLabel();
    private final JLabel budgetLabel = new JLabel("Budget:");
    private final JPanel topNavbar = new JPanel();

    private final JPanel bottomBar = new JPanel();

    /**
     * Constructor of the TemplateContainer class. It initializes the content of the panel.
     */
    public TemplateContainer(){
        this.setLayout(new BorderLayout(55, 0));
        // Top navbar with GridLayout
        this.topNavbar.setLayout(new GridLayout(1, 5));
        this.topNavbar.add(this.load);
        this.topNavbar.add(this.save);
        // Add budgetLabel
        this.budgetLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.topNavbar.add(budgetLabel);
        // Add budgetDisplay
        this.budgetDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        this.topNavbar.add(this.budgetDisplay);
        this.topNavbar.add(this.logOut);
        this.add(topNavbar, BorderLayout.NORTH);
    }

    /**
     * This method removes the content of the center of the panel.
     */
    public void removeCenterContent(){
        BorderLayout layout = (BorderLayout) this.getLayout();
        Component centerComponent = layout.getLayoutComponent(BorderLayout.CENTER);
        if (centerComponent != null){
            this.remove(centerComponent);
            this.revalidate();
            this.repaint();
        }
    }

    /**
     * This method removes the content of the south of the panel.
     */
    public void removeSouthContent(){
        BorderLayout layout = (BorderLayout) this.getLayout();
        Component southComponent = layout.getLayoutComponent(BorderLayout.SOUTH);
        if (southComponent != null){
            this.remove(southComponent);
            this.revalidate();
            this.repaint();
        }
    }

    /**
    * This method sets the bottom bar of the panel.
    *
    * @param bottomBar JPanel representing content of the bottom bar
    */
    public void setBottomBar(JPanel bottomBar){
        this.add(bottomBar, BorderLayout.SOUTH);
    }

    /**
     * This method sets the content of the center area.
     * 
     * @param content JPanel representing the content of the center area
     */
    public void setContent(JPanel content){
        this.add(content, BorderLayout.CENTER);
    }

    /**
     * This method provides access to the topNavBar field.
     * @return the instance of topNavBar
     */
    public JPanel getTopNavbar(){
        return this.topNavbar;
    }

    /**
     * This method provides the budgetDisplay JLabel
     * 
     * @return JLabel representing the outputted budget value
     */
    public JLabel getBudgetDisplay(){
        return this.budgetDisplay;
    }

    /**
     * This method provides the Load button.
     * 
     * @return JButton representing the Load button
     */
    public JButton getLoad(){
        return this.load;
    }

    /**
     * This method provides the Save button.
     * 
     * @return JButton representing the Save button
     */
    public JButton getSave(){
        return this.save;
    }

    /**
     * This method provides the LogOut button.
     * 
     * @return JButton representing the LogOut button
     */
    public JButton getLogOut(){
        return this.logOut;
    }

    /**
     * This method sets the budget display value.
     *
     * @param budgetDisplayValue value which should be displayed
     */
    public void setBudgetDisplayValue(String budgetDisplayValue){
        this.budgetDisplay.setText(budgetDisplayValue);
    }

    /**
     * This method sets the action listener for the logOut button.
     * 
     * @param listener ActionListener representing the action listener for the logOut button
     */
    public void setLogOutActionListener(ActionListener listener){
        this.logOut.addActionListener(listener);
    }

    /**
     * This method sets the action listener for the save button.
     * 
     * @param listener ActionListener representing the action listener for the save button
     */
    public void setSaveActionListener(ActionListener listener){
        this.save.addActionListener(listener);
    }

    /**
     * This method sets the action listener for the load button.
     * 
     * @param listener ActionListener representing the action listener for the load button
     */
    public void setLoadActionListener(ActionListener listener){
        this.load.addActionListener(listener);
    }

}
