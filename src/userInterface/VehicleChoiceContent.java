package userInterface;

import FactoryDP.getVehicle.VehicleNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class represents the content of the VehicleChoicePanel. It contains buttons for each vehicle and their prices.
 * 
 * @version 1.0
 * @since 1.3.2024
 * @author Šimon Vinkler
 */
public class VehicleChoiceContent extends JPanel {
    // with menu/nav at NORTH and just added the CENTER content
    private final JButton challenger = new JButton("Dodge Challenger");
    private final JLabel challengerPrice = new JLabel(VehicleNames.CHALLENGER.name());
    private final JButton charger = new JButton("Dodge Charger");
    private final JLabel chargerPrice = new JLabel(VehicleNames.CHARGER.name());
    private final JButton firebird74 = new JButton("Pontiac Firebird 74'");
    private final JLabel firebird74Price = new JLabel(VehicleNames.FIREBIRD74.name());
    private final JButton firebird82 = new JButton("Pontiac Firebird 82'");
    private final JLabel firebird82Price = new JLabel(VehicleNames.FIREBIRD82.name());
    private final JButton gt40 = new JButton("Ford GT40");
    private final JLabel gt40Price = new JLabel(VehicleNames.GT40.name());
    private final JButton mustang69 = new JButton("Ford Mustang 69'");
    private final JLabel mustangPrice = new JLabel(String.valueOf(VehicleNames.MUSTANG.name()));
    private final JPanel buttonContainer = new JPanel(new GridLayout(6, 2));

    private final JLabel headerLabel = new JLabel("Choose a vehicle:");

    private final ArrayList<JLabel> priceTags = new ArrayList<>();

    /**
     * Constructor of the VehicleChoiceContent class. It initializes the content of the panel.
     */
    public VehicleChoiceContent(){
        this.priceTags.add(challengerPrice);
        this.priceTags.add(chargerPrice);
        this.priceTags.add(firebird74Price);
        this.priceTags.add(firebird82Price);
        this.priceTags.add(gt40Price);
        this.priceTags.add(mustangPrice);

        this.priceTags.forEach(priceTag -> {
            priceTag.setHorizontalAlignment(SwingConstants.CENTER);
            priceTag.setVerticalAlignment(SwingConstants.CENTER);
        });

        // Set Layout Manager
        this.setLayout(new BorderLayout());
        // Set label
        this.headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.headerLabel.setMinimumSize(new Dimension(300, 35));
        this.add(headerLabel, BorderLayout.NORTH);
        // Set buttons & price of each vehicle
        this.buttonContainer.add(challenger);
        this.buttonContainer.add(challengerPrice);

        this.buttonContainer.add(charger);
        this.buttonContainer.add(chargerPrice);

        this.buttonContainer.add(firebird74);
        this.buttonContainer.add(firebird74Price);

        this.buttonContainer.add(firebird82);
        this.buttonContainer.add(firebird82Price);

        this.buttonContainer.add(gt40);
        this.buttonContainer.add(gt40Price);

        this.buttonContainer.add(mustang69);
        this.buttonContainer.add(mustangPrice);

        this.add(buttonContainer, SwingConstants.CENTER);

        this.add(this.headerLabel, BorderLayout.NORTH);
        this.add(this.buttonContainer, BorderLayout.CENTER);
    }

    /**
     * This method returns the button for the Dodge Challenger.
     * 
     * @return instance of JButton representing the Dodge Challenger button
     */
    public JButton getChallenger(){
        return this.challenger;
    }

    /**
     * This method returns the button for the Dodge Charger.
     * 
     * @return instance of JButton representing the Dodge Charger button
     */
    public JButton getCharger(){
        return this.charger;
    }

    /**
     * This method returns the button for the Pontiac Firebird 74'.
     * 
     * @return instance of JButton representing the Pontiac Firebird 74' button
     */
    public JButton getFirebird74(){
        return this.firebird74;
    }

    /**
     * This method returns the button for the Pontiac Firebird 82'.
     * 
     * @return instance of JButton representing the Pontiac Firebird 82' button
     */
    public JButton getFirebird82() {
        return this.firebird82;
    }

    /**
     * This method returns the button for the Ford GT40.
     * 
     * @return instance of JButton representing the Ford GT40 button
     */
    public JButton getGt40(){
        return this.gt40;
    }

    /**
     * This method returns the button for the Ford Mustang 69'.
     * 
     * @return instance of JButton representing the Ford Mustang 69' button
     */
    public JButton getMustang69(){
        return this.mustang69;
    }

    /**
     * This method adds an ActionListener to the Dodge Challenger button.
     * 
     * @param listener instance of ActionListener to be added to the Dodge Challenger button
     */
    public void addChallengerListener(ActionListener listener){
        this.challenger.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Dodge Charger button.
     * 
     * @param listener instance of ActionListener to be added to the Dodge Charger button
     */
    public void addChargerListener(ActionListener listener){
        this.charger.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Pontiac Firebird 74' button.
     * 
     * @param listener instance of ActionListener to be added to the Pontiac Firebird 74' button
     */
    public void addFirebird74Listener(ActionListener listener){
        this.firebird74.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Pontiac Firebird 82' button.
     * 
     * @param listener instance of ActionListener to be added to the Pontiac Firebird 82' button
     */
    public void addFirebird82Listener(ActionListener listener){
        this.firebird82.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Ford GT40 button.
     * 
     * @param listener instance of ActionListener to be added to the Ford GT40 button
     */
    public void addGT40Listener(ActionListener listener){
        this.gt40.addActionListener(listener);
    }

    /**
     * This method adds an ActionListener to the Ford Mustang 69' button.
     * 
     * @param listener instance of ActionListener to be added to the Ford Mustang 69' button
     */
    public void addMustang69Listener(ActionListener listener){
        this.mustang69.addActionListener(listener);
    }

    /**
     * This method returns the price tags of each vehicle.
     * 
     * @return ArrayList of JLabels representing the price tags of each vehicle
     */
    public ArrayList<JLabel> getPriceTags(){
        return this.priceTags;
    }
}
