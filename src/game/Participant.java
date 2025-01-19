package game;

import FactoryDP.getVehicle.CustomisedVehicle;
import game.StrategyDP.*;

import java.io.Serializable;

/**
 * Abstract class representing a participant in the game.
 * This class provides the base functionality for all participants,
 * including methods for setting and getting game modes, budgets, and other participant details.
 *
 * @author Šimon Vinkler
 * @version 1.0
 * @since 1.3.2024
 */
public abstract class Participant implements UserRecognition, Serializable {
    private int budget;
    private CustomisedVehicle vehicle = null;
    private String username;
    private int votes = 0;

    private transient Difficulty gameMode;

    private String favourite;

    /**
     * Sets the game difficulty mode for the participant.
     * The mode is defined by a string which is converted to uppercase and used
     * to determine the specific difficulty settings.
     *
     * @param gameMode The game difficulty mode as a string. Acceptable values are "ROOKIE", "PRO", or others defaulting to "AMATEUR".
     */
    public void setGameMode(String gameMode){
        gameMode = gameMode.toUpperCase();
        switch (gameMode){
            case "ROOKIE":
                this.gameMode = new RookieDifficulty();
                break;

            case "PRO":
                this.gameMode = new ProDifficulty();
                break;

            default:
                this.gameMode = new AmateurDifficulty();
        }

        this.gameMode.setDifficulty();
        this.gameMode.setBudget();
    }

    /**
     * Retrieves the game difficulty mode for this participant.
     *
     * @return The current game difficulty mode as a {@link Difficulty} object.
     */
    public Difficulty getGameMode(){
        return this.gameMode;
    }

    /**
     * Sets the username for this participant.
     *
     * @param nickName The username to be set for this participant.
     */
    protected void setUsername(String nickName){
        this.username = nickName;
    }

    /**
     * Returns the current budget of this participant.
     *
     * @return The current budget as an integer.
     */
    public int getBudget(){
        return this.budget;
    }

    /**
     * Updates the budget of this participant.
     *
     * @param newBudget The new budget value to be set.
     */
    public void updateBudget(int newBudget){
        this.budget = newBudget;
    }

    /**
     * Sets the vehicle for this participant.
     *
     * @param vehicle The {@link CustomisedVehicle} object to be set for this participant.
     */
    public void setCustomisableVehicle(CustomisedVehicle vehicle){
        this.vehicle = vehicle;
    }

    /**
     * Sets the participant's favourite attribute.
     *
     * @param fav The string representing the favourite attribute to set.
     */
    public void setFavourite(String fav){
        this.favourite = fav;
    }

    /**
     * Retrieves the favourite attribute of this participant.
     *
     * @return The favourite attribute as a string.
     */
    public String getFavourite(){
        return this.favourite;
    }

    // Interface implementations of UserRecognition

    /**
     * Retrieves the username of this participant.
     *
     * @return The username of this participant.
     */
    @Override
    public String getUsername(){
        return this.username;
    }

    /**
     * Retrieves the vehicle associated with this participant.
     *
     * @return The {@link CustomisedVehicle} object associated with this participant.
     */
    @Override
    public CustomisedVehicle getVehicle() {
        return vehicle;
    }

    /**
     * Retrieves the total number of votes this participant has received.
     *
     * @return The total votes as an integer.
     */
    @Override
    public int getVotes(){
        return this.votes;
    }

    /**
     * Increments the vote count for this participant by one.
     */
    @Override
    public void addVote(){
        this.votes++;
    }
}
