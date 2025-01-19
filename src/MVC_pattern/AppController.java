package MVC_pattern;

import FactoryDP.getParticle.ConcreteParticleFactory;
import FactoryDP.getParticle.ParticleManufacture;
import FactoryDP.getVehicle.ConcreteVehicleFactory;
import FactoryDP.getVehicle.CustomisedVehicle;
import FactoryDP.getVehicle.VehicleManufacture;
import FactoryDP.getVehicle.VehicleNames;
import game.ManagerOfCharacters;
import game.ObserverDP.UserStatusListener;
import game.UserRecognition;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link AppController} is the C-part (controller) of MVC design pattern. Thus handles communication between
 * View (viewGUI) and Model (modelManager). It splits the logic and UI, manages the data flow.
 *
 * @author Šimon Vinkler
 * @version Final
 * @since 1.3.2024
 */
public class AppController implements UserStatusListener {
    /**
     * viewGUI represents the V part of MVC design pattern, separates the UI from data & logic
     * Handles graphic representation of the app (communicates with user)
     */
    private ViewGUI viewGUI;
    /**
     * modelManager represents the M part of MVC design pattern, separates data & logic from UI
     * Contains user data, data of enemies, data of vehicle, voting data...
     */
    private ManagerOfCharacters modelManager;

    /**
     * Serves as app initialisation. Constructs the "body, brain and memory" of the app.
     *
     * @param view represents ViewGUI object for GUI handling, part of MVC pattern.
     * @param model represents ManagerOfCharacters object to handle Data&Logic, part of MVC pattern.
     */
    public AppController(ViewGUI view, ManagerOfCharacters model){
        this.viewGUI = view;
        this.modelManager = model;


        this.setLoginListeners();

        this.setRegisterListeners();

        this.setDifficultyListeners();

        this.setVehicleChoiceListeners();

        this.setParticleChoiceListeners();

        this.setVoteListeners();

        this.setResultListeners();

        this.setTemplateContainerListeners();
    }

    /**
     * Helper method for login listeners setup
     *
     */
    private void setLoginListeners(){
        this.viewGUI.getLoginView().addLoginListener(e -> {
            // Get username
            String inputUsername = this.viewGUI.getLoginView().getUsername();
            String inputPassword = this.viewGUI.getLoginView().getPassword();
            // Handle validation process
            try{
                if (this.modelManager.logIn(inputUsername, inputPassword)){
                    this.viewGUI.switchToDifficultyChoice();
                }
            }catch (Exception exception){
                this.viewGUI.displayErrorMessage(exception.getMessage());
            }
        });

        this.viewGUI.getLoginView().addRegisterListener(e -> {
            this.viewGUI.switchToRegisterView();
        });
    }

    /**
     * Helper method - sets up listeners for buttons from RegisterView panel
     *
     */
    private void setRegisterListeners(){
        this.viewGUI.getRegisterView().addLoginListener(e -> {
            this.viewGUI.switchToLoginView();
        });

        this.viewGUI.getRegisterView().addRegisterListener(e -> {
            String username = this.viewGUI.getRegisterView().getUsername();
            String password = this.viewGUI.getRegisterView().getPassword();
            String repeatedPassword = this.viewGUI.getRegisterView().getRepeatedPassword();

            try{
                if (this.modelManager.register(username, password, repeatedPassword)){
                    this.viewGUI.switchToDifficultyChoice();
                }
            }catch (Exception exception){
                this.viewGUI.displayErrorMessage(exception.getMessage());
            }
        });
    }

    /**
     * Helper method - sets up listeners for buttons from DifficultyChoice panel
     *
     */
    private void setDifficultyListeners(){
        this.viewGUI.getDifficultyChoice().addAmateurListener(e -> {
            this.modelManager.setGameMode(this.viewGUI.getDifficultyChoice().getAmateur().getText());
        });

        this.viewGUI.getDifficultyChoice().addRookieListener(e -> {
            this.modelManager.setGameMode(this.viewGUI.getDifficultyChoice().getRookie().getText());
        });

        this.viewGUI.getDifficultyChoice().addProListener(e -> {
            this.modelManager.setGameMode(this.viewGUI.getDifficultyChoice().getPro().getText());
        });

        this.viewGUI.getDifficultyChoice().addSubmitListener(e -> {
            int budget = this.modelManager.displayBudget();
            this.viewGUI.switchToVehicleChoice("$" + Integer.toString(budget));
            System.out.println("--budget assigned: " + budget);
        });
    }

    /**
     * Helper method - sets up listeners for buttons from TemplateContainer panel
     *
     */
    private void setTemplateContainerListeners(){
        this.viewGUI.getTemplateContainer().getLogOut().addActionListener(listener->{
            this.viewGUI.switchToLoginView();
            this.viewGUI.resetAll();
            this.modelManager.logOut();
        });

        // Serialisation was not implemented in final version
        this.viewGUI.getTemplateContainer().getSave().addActionListener(listener->{
            this.viewGUI.displayAnnouncement("This feature is still being developed!");
            /*if (this.modelManager.save()){
                this.viewGUI.displayAnnouncement("Save successful!");
            }*/
        });

        this.viewGUI.getTemplateContainer().getLoad().addActionListener(listener->{
            this.viewGUI.displayAnnouncement("This feature is still being developed!");
            /*if (this.modelManager.load()){
                if (this.modelManager.getNewUser().getVehicle() == null){
                    this.viewGUI.switchToVehicleChoice(Integer.toString(this.modelManager.displayBudget()));
                }else if (this.modelManager.getNewUser().getVehicle().getParticleCount() != 0){
                    this.switchToParticleHandler();
                }
                this.viewGUI.displayAnnouncement("Load successful!");
            }else {
                this.viewGUI.displayErrorMessage("Load failed!");
            }*/
        });

        this.viewGUI.getTemplateContainer().getLoad().addActionListener(listener->{

        });
    }

    /**
     * Helper method - sets up listeners for buttons from VehicleChoice panel
     *
     */
    private void  setVehicleChoiceListeners(){
        // Setup price tags
        ArrayList<JLabel> priceTags = this.viewGUI.getVehicleChoice().getPriceTags();
        priceTags.forEach(priceTag -> {
            VehicleManufacture vehicle = new ConcreteVehicleFactory().createVehicle(priceTag.getText());
            priceTag.setText("$" + vehicle.getPrice());
        });

        this.modelManager.getUserStatusObserver().addListener(this);
        this.viewGUI.getVehicleChoice().addChallengerListener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.CHALLENGER.name());
            switchToParticleHandler();
        });

        this.viewGUI.getVehicleChoice().addChargerListener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.CHARGER.name());
            switchToParticleHandler();
        });

        this.viewGUI.getVehicleChoice().addFirebird74Listener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.FIREBIRD74.name());
            switchToParticleHandler();
        });

        this.viewGUI.getVehicleChoice().addFirebird82Listener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.FIREBIRD82.name());
            switchToParticleHandler();
        });

        this.viewGUI.getVehicleChoice().addGT40Listener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.GT40.name());
            switchToParticleHandler();
        });

        this.viewGUI.getVehicleChoice().addMustang69Listener(e -> {
            this.modelManager.vehicleSetup(VehicleNames.MUSTANG.name());
            switchToParticleHandler();
        });
    }

    /**
     * Helper method - sets up listeners for buttons from ParticleChoice panel
     *
     */
    private void setParticleChoiceListeners(){
        // Setup price tags
        ArrayList<JLabel> priceTags = this.viewGUI.getParticleChoice().getPriceTags();
        priceTags.forEach(priceTag -> {// Lambda used here
            ParticleManufacture particle = new ConcreteParticleFactory().createParticle(priceTag.getText());
            priceTag.setText("$" + particle.getPrice());
        });

        this.viewGUI.getParticleChoice().getAeroBody().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("body")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getAeroBody().setSelected(false);
                }

            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("body");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getEmpoweredEngine().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("engine")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getEmpoweredEngine().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("engine");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getChippedMCU().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("mcu")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getChippedMCU().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("mcu");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getImprovedChassis().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("chassis")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getImprovedChassis().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("chassis");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getImprovedTransmissions().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("transmissions")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getImprovedTransmissions().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("transmissions");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getLowTractionWheels().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("wheels")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getImprovedTransmissions().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("wheels");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getSportsAirIntake().addItemListener(listener->{
            if (listener.getStateChange() == ItemEvent.SELECTED){
                if (this.modelManager.addParticle("airIntake")){
                    this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
                }else {
                    this.viewGUI.displayErrorMessage("Insufficient funds!");
                    this.viewGUI.getParticleChoice().getImprovedTransmissions().setSelected(false);
                }
            }else if (listener.getStateChange() == ItemEvent.DESELECTED){
                this.modelManager.removeParticle("airIntake");
                this.updateSpecs(this.viewGUI.getParticleChoice().getSpecValues());
            }
        });

        this.viewGUI.getParticleChoice().getSubmit().addActionListener(listener -> {
            this.modelManager.prepareVoteDataset();

            HashMap<String, UserRecognition> votingStatistic = this.modelManager.getVotingControl().getVotingStatistic();

            // Define table headers
            String[] tHead = {"Username", "Brand", "Model", "Horsepower"};

            // Prepare the table content array
            Object[][] tableContent = new Object[votingStatistic.size()][4];

            // Atomic integer to keep track of the current index for the table content array
            AtomicInteger index = new AtomicInteger(0);

            // Iterate over each entry in the map
            votingStatistic.forEach((username, userRecognition) -> {
                tableContent[index.get()][0] = username;
                tableContent[index.get()][1] = userRecognition.getVehicle().getBrand();
                tableContent[index.get()][2] = userRecognition.getVehicle().getModel();
                tableContent[index.get()][3] = userRecognition.getVehicle().getHorsePower();
                index.incrementAndGet();
            });

            // Switch to vote table view after filling the table content
            this.viewGUI.getVoteTable().setTable(tHead, tableContent);
            this.viewGUI.switchToVoteTable();
        });
    }

    /**
     * Helper method - sets up listeners for buttons from VoteChoicePanel and VoteResult
     *
     */
    private void setVoteListeners(){
        this.viewGUI.getVoteChoicePanel().getGiveVote().addActionListener(listener -> {
            String inputUsername = this.viewGUI.getVoteChoicePanel().getInputUsername().getText();
            if (inputUsername.isEmpty()){
                this.viewGUI.displayErrorMessage("Wrong username format. Please, try again...");
            }else {
                UserRecognition vote = this.modelManager.vote(this.viewGUI.getVoteChoicePanel().getInputUsername().getText());
                if (vote == null){
                    this.viewGUI.displayErrorMessage("Unable to find the participant. Please, try again...");
                }else {
                    UserRecognition winner = this.modelManager.getVotingControl().getWinner();

                    // Define table headers
                    String[] tHead = {"Winner:", winner.getUsername()};

                    // Prepare the table content array
                    Object[][] tableContent = new Object[8][2];

                    CustomisedVehicle vehicle = winner.getVehicle();

                    // Go over each specification
                    tableContent[0][0] = "Brand:";
                    tableContent[1][0] = "Model:";
                    tableContent[2][0] = "Production year:";
                    tableContent[3][0] = "Horse power:";
                    tableContent[4][0] = "Torque:";
                    tableContent[5][0] = "Acceleration:";
                    tableContent[6][0] = "Top speed:";
                    tableContent[7][0] = "Weight:";
                    tableContent[0][1] = vehicle.getBrand();
                    tableContent[1][1] = vehicle.getModel();
                    tableContent[2][1] = vehicle.getProductionYear();
                    tableContent[3][1] = vehicle.getHorsePower();
                    tableContent[4][1] = vehicle.getTorque();
                    tableContent[5][1] = vehicle.getAcceleration();
                    tableContent[6][1] = vehicle.getMaxSpeed();
                    tableContent[7][1] = vehicle.getWeight();



                    // Switch to vote table view after filling the table content
                    this.viewGUI.getVoteResult().setTable(tHead, tableContent);
                    this.viewGUI.switchToVoteResult();
                }
            }
        });
    }

    /**
     * Helper method - sets up listeners for buttons from VehicleChoice panel
     *
     */
    private void setResultListeners(){
        this.viewGUI.getVoteResult().getNewGame().addActionListener(listener->{
            this.viewGUI.getTemplateContainer().remove(this.viewGUI.getVoteResult());
//            this.modelManager.resetGame();
            this.viewGUI.resetAll();
            this.viewGUI.switchToDifficultyChoice();
        });
    }

    /**
     * Helper method - prepares data for smooth transition to ParticleChoice panel
     *
     */
    private void switchToParticleHandler(){
        ArrayList<JLabel> specTags = this.viewGUI.getParticleChoice().getSpecLabels();
        ArrayList<JLabel> specValues = this.viewGUI.getParticleChoice().getSpecValues();

        // Handle specs tags
        specTags.get(0).setText("Brand:");
        specTags.get(1).setText("Model:");
        specTags.get(2).setText("Production year:");
        specTags.get(3).setText("Horse Power:");
        specTags.get(4).setText("Torque:");
        specTags.get(5).setText("Acceleration:");
        specTags.get(6).setText("Top speed:");
        specTags.get(7).setText("Weight:");

        specTags.forEach(tag -> {
            tag.setHorizontalAlignment(SwingConstants.CENTER);
            tag.setVerticalAlignment(SwingConstants.CENTER);
        });

        for (JLabel specValue : specValues) {
            specValue.setHorizontalAlignment(SwingConstants.LEFT);
        }

        this.viewGUI.switchToParticleChoice("$" + this.modelManager.displayBudget(), specTags, updateSpecs(specValues));
    }

    /**
     * This method extracts data from Model to View which will be displayed in ParticleChoice panel
     *
     * @param oldSpecs the array list of JLabel type is provided and updated in method.
     * @return updated list of JLabels - JLabels display the current vehicle properties (specs)
     */
    public ArrayList<JLabel> updateSpecs(ArrayList<JLabel> oldSpecs){
        ArrayList<String> vehicleSpecs = this.modelManager.getVehicleSpecs();

        for (int i = 0; i < oldSpecs.size(); i++){
            oldSpecs.get(i).setText(vehicleSpecs.get(i));
        }

        return oldSpecs;
    }

    /**
     * update() method updates displayed budget with new value extracted from Model and converted to displayable format
     * Method is implemented from UserStatusListener interface which is par of Observer Design pattern
     *
     */
    @Override
    public void update() {
        int newBudget = this.modelManager.displayBudget();
        this.viewGUI.getTemplateContainer().getBudgetDisplay().setText("$"+ newBudget);
    }
}
