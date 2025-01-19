package MVC_pattern;

import userInterface.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * {@link ViewGUI} represents graphical user interface (GUI), handles the graphical representation of the current application state
 * Also is a part of MVC design pattern, represents V (view)
 *
 * @author Šimon Vinkler
 * @version Final
 * @since 1.3.2024
 */
public class ViewGUI extends JFrame {
    /**
     * CardLayoutManager and cardPanel are representing foundation of another possible approach which should be considered in future
     */
    private final CardLayout cardLayoutManager = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayoutManager);

    /**
     * Fields bellow are initialisations of objects used during whole run of application
     */
    // Init. views
    private final LoginView loginView = new LoginView();

    private final RegisterView registerView = new RegisterView();

    private final TemplateContainer templateContainer = new TemplateContainer();
    private final VehicleChoiceContent vehicleChoice = new VehicleChoiceContent();

    private final DifficultyChoice difficultyChoice = new DifficultyChoice();

    private final ParticleChoice particleChoice = new ParticleChoice();

    private final VoteTable voteTable = new VoteTable();

    private final VoteChoicePanel voteChoicePanel = new VoteChoicePanel();

    private final VoteResult voteResult = new VoteResult();

    /**
     * Constructs the main frame of the GUI
     */
    public ViewGUI() {
        this.setTitle("New2Outlaws");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.cardPanel.add(loginView, "Login");
        this.add(cardPanel);
        setVisible(true);
    }

    /**
     * Getter
     *
     * @return instance of login view panel
     */
    public LoginView getLoginView() {
        return this.loginView;
    }

    /**
     * Getter
     *
     * @return instance of register view panel
     */
    public RegisterView getRegisterView(){
        return this.registerView;
    }

    /**
     * Getter
     *
     * @return instance of difficulty choice panel
     */
    public DifficultyChoice getDifficultyChoice(){
        return this.difficultyChoice;
    }

    /**
     * Getter
     *
     * @return instance of vehicle choice panel
     */
    public VehicleChoiceContent getVehicleChoice(){
        return this.vehicleChoice;
    }

    /**
     * Getter
     *
     * @return instance of template container (panel)
     */
    public TemplateContainer getTemplateContainer(){
        return this.templateContainer;
    }

    /**
     * Getter
     *
     * @return instance of particle choice panel
     */
    public ParticleChoice getParticleChoice(){
        return this.particleChoice;
    }

    /**
     * Getter
     *
     * @return instance of vote table panel
     */
    public VoteTable getVoteTable(){
        return this.voteTable;
    }

    /**
     * Getter
     *
     * @return instance of vote choice panel
     */
    public VoteChoicePanel getVoteChoicePanel(){
        return this.voteChoicePanel;
    }

    /**
     * Getter
     *
     * @return instance of vote result panel
     */
    public VoteResult getVoteResult(){
        return this.voteResult;
    }

    /**
     * Displays error message
     *
     * @param message which will be displayed in JOptionPane
     */
    // Method to display error messages
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays announcement
     *
     * @param message which will be displayed in JOptionPane
     */
    public void displayAnnouncement(String message){
        JOptionPane.showMessageDialog(this, message, "Announcement", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles transition between views
     */
    public void switchToLoginView(){
        this.getContentPane().removeAll();
        this.getTemplateContainer().removeCenterContent();
        this.getTemplateContainer().removeSouthContent();
        this.getContentPane().add(loginView);
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToRegisterView(){
        this.getContentPane().removeAll();
        this.getContentPane().add(registerView);
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToDifficultyChoice(){
        this.getContentPane().removeAll();
        this.templateContainer.add(difficultyChoice, BorderLayout.CENTER);
        this.getContentPane().add(templateContainer);
//        this.getContentPane().add(vehicleChoice);
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToVehicleChoice(String baseBudget){
        // Remove previous content from center
        this.templateContainer.remove(difficultyChoice);
        // Add new center content
        this.templateContainer.add(vehicleChoice, BorderLayout.CENTER);
        // Display budget value
        this.templateContainer.setBudgetDisplayValue(baseBudget);
        // Rev. and rep.
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToParticleChoice(String baseBudget, ArrayList<JLabel> specTags, ArrayList<JLabel> specValues){
        this.templateContainer.remove(vehicleChoice);
        this.particleChoice.setSpecLabels(specTags);
        this.particleChoice.setSpecValues(specValues);
        // Add ParticleChoice
        this.templateContainer.add(particleChoice, BorderLayout.CENTER);
        // Display budget value
        this.templateContainer.setBudgetDisplayValue(baseBudget);
        // Rev. and rep.
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToVoteTable(){
        this.templateContainer.remove(this.particleChoice);
        this.templateContainer.add(this.voteTable, BorderLayout.CENTER);
        this.templateContainer.add(this.voteChoicePanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    /**
     * Handles transition between views
     */
    public void switchToVoteResult(){
        this.templateContainer.remove(this.voteTable);
        this.templateContainer.add(this.voteResult, BorderLayout.CENTER);
        this.templateContainer.remove(voteChoicePanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Resets every panel to original state
     */
    public void resetAll(){
        this.getLoginView().reset();
        this.getRegisterView().reset();
        this.getDifficultyChoice().reset();
        this.getParticleChoice().reset();
        this.getVoteChoicePanel().reset();
    }
}

