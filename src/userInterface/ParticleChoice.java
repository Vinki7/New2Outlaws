package userInterface;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the content of the ParticleChoicePanel. It contains checkboxes for each particle and their prices.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class ParticleChoice extends JPanel implements PanelManager{
    private ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

    private final JButton submit = new JButton("Submit");

    private final JCheckBox aeroBody = new JCheckBox("Aero bodywork");

    private final JCheckBox chippedMCU = new JCheckBox("Chipped MCU");

    private final JCheckBox empoweredEngine = new JCheckBox("Empowered engine");

    private final JCheckBox improvedChassis = new JCheckBox("Improved chassis");

    private final JCheckBox lowTractionWheels = new JCheckBox("Low traction wheels");

    private final JCheckBox sportsAirIntake = new JCheckBox("Sports air intake");
    private final JCheckBox improvedTransmissions = new JCheckBox("Improved transmissions");

    private final JPanel checkBoxContainer = new JPanel(new GridLayout(8, 1));

    private ArrayList<JLabel> priceTags = new ArrayList<>();

    private final JLabel aeroPrice = new JLabel("body");
    private final JLabel mcuPrice = new JLabel("mcu");
    private final JLabel enginePrice = new JLabel("engine");
    private final JLabel chassisPrice = new JLabel("chassis");
    private final JLabel wheelsPrice = new JLabel("wheels");
    private final JLabel airIntakePrice = new JLabel("airintake");
    private final JLabel transmissionsPrice = new JLabel("transmissions");

    private final JPanel priceTagContainer = new JPanel(new GridLayout(8, 1));

    private ArrayList<JLabel> specLabels = new ArrayList<>(8);

    private ArrayList<JLabel> specValues = new ArrayList<>(8);

    private final JPanel statPanel = new JPanel(new GridLayout(8, 1));

    private final JPanel statValues = new JPanel(new GridLayout(8, 1));

    /**
     * Constructor of the ParticleChoice class. It initializes the content of the panel.
     */
    public ParticleChoice(){
        // Set layout manager
        this.setLayout(new GridLayout(1, 4));

        checkBoxesHandler();

        priceTagsHandler();

        statsHandler();

        this.add(checkBoxContainer);
        this.add(priceTagContainer);
        this.add(statPanel);
        this.add(statValues);
    }

    /**
     * This method resets the configuration of the particles.
     */
    @Override
    public void reset(){
        this.getCheckBoxes().forEach(jCheckBox -> {
            jCheckBox.setSelected(false);
        });
    }

    /**
     * This method adds an ActionListener to the submit button.
     */
    public void statsHandler(){// This is maybe unnecessary
        for (int i = 0; i < 8; i++){
            specLabels.add(new JLabel("_"));
            specValues.add(new JLabel("_"));
        }
        specLabels.forEach(this.statPanel::add);
        specValues.forEach(this.statValues::add);
    }

    /**
     * This method adds an ActionListener to the submit button.
     */
    public void priceTagsHandler(){
        priceTags.add(aeroPrice);
        priceTags.add(mcuPrice);
        priceTags.add(enginePrice);
        priceTags.add(chassisPrice);
        priceTags.add(wheelsPrice);
        priceTags.add(airIntakePrice);
        priceTags.add(transmissionsPrice);

        priceTags.forEach(priceTag -> {// Lambda used here
            priceTag.setHorizontalAlignment(SwingConstants.CENTER);
            priceTag.setVerticalAlignment(SwingConstants.CENTER);
            priceTagContainer.add(priceTag);
        });

        this.submit.setHorizontalAlignment(SwingConstants.CENTER);
        priceTagContainer.add(this.submit);
    }

    /**
     * This method adds an ActionListener to the submit button.
     */
    public void checkBoxesHandler(){
        checkBoxes.add(aeroBody);
        checkBoxes.add(chippedMCU);
        checkBoxes.add(empoweredEngine);
        checkBoxes.add(improvedChassis);
        checkBoxes.add(lowTractionWheels);
        checkBoxes.add(sportsAirIntake);
        checkBoxes.add(improvedTransmissions);

        checkBoxes.forEach(checkBox -> {
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            checkBoxContainer.add(checkBox);
        });
    }

    /**
     * This method adds an ActionListener to the submit button.
     */
    public JButton getSubmit(){
        return this.submit;
    }

    /**
     * This method returns the checkbox for the Aero Bodywork.
     * 
     * @return instance of JCheckBox representing the Aero Bodywork checkbox
     */
    public JCheckBox getAeroBody(){
        return aeroBody;
    }

    /**
     * This method returns the checkbox for the Chipped MCU.
     * 
     * @return instance of JCheckBox representing the Chipped MCU checkbox
     */
    public JCheckBox getChippedMCU(){
        return chippedMCU;
    }

    /**
     * This method returns the checkbox for the Empowered Engine.
     * 
     * @return instance of JCheckBox representing the Empowered Engine checkbox
     */
    public JCheckBox getEmpoweredEngine(){
        return empoweredEngine;
    }

    /**
     * This method returns the checkbox for the Improved Chassis.
     * 
     * @return instance of JCheckBox representing the Improved Chassis checkbox
     */
    public JCheckBox getImprovedChassis(){
        return improvedChassis;
    }

    /**
     * This method returns the checkbox for the Low Traction Wheels.
     * 
     * @return instance of JCheckBox representing the Low Traction Wheels checkbox
     */
    public JCheckBox getLowTractionWheels(){
        return lowTractionWheels;
    }

    /**
     * This method returns the checkbox for the Sports Air Intake.
     * 
     * @return instance of JCheckBox representing the Sports Air Intake checkbox
     */
    public JCheckBox getSportsAirIntake(){
        return sportsAirIntake;
    }

    /**
     * This method returns the checkbox for the Improved Transmissions.
     * 
     * @return instance of JCheckBox representing the Improved Transmissions checkbox
     */
    public JCheckBox getImprovedTransmissions(){
        return this.improvedTransmissions;
    }

    /**
     * This method returns the list of checkboxes.
     * 
     * @return list of checkboxes
     */
    public ArrayList<JCheckBox> getCheckBoxes() {
        return checkBoxes;
    }

    /**
     * This method returns the list of price tags.
     * 
     * @return list of price tags
     */
    public ArrayList<JLabel> getPriceTags() {
        return priceTags;
    }

    /**
     * This method returns the list of labels representing the specifications.
     * 
     * @return list of labels representing the specifications
     */
    public ArrayList<JLabel> getSpecLabels() {
        return specLabels;
    }

    /**
     * This method returns the list of labels representing the values of the specifications.
     * 
     * @return list of labels representing the values of the specifications
     */
    public ArrayList<JLabel> getSpecValues() {
        return specValues;
    }

    /**
     * This method sets the list of labels representing the specifications.
     * 
     * @param labels list of labels representing the specifications
     */
    public void setSpecLabels(ArrayList<JLabel> labels){
        this.specLabels = labels;
    }

    /**
     * This method sets the list of labels representing the values of the specifications.
     * 
     * @param values list of labels representing the values of the specifications
     */
    public void setSpecValues(ArrayList<JLabel> values){
        this.specValues = values;
    }

}
