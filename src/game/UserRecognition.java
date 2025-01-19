package game;

import FactoryDP.getVehicle.CustomisedVehicle;

/**
 *  UserRecognition represents tool for extracting only necessary data during voting process
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public interface UserRecognition {


    /**
     * @return username for owner recognition
     */
    String getUsername();

    /**
     * @return user's vehicle with all it's modifications
     */
    CustomisedVehicle getVehicle();


    /**
     * Retrieves number of votes already given to the concrete owner/vehicle
     * @return number of votes
    **/
    int getVotes();

    /**
     * Adds another vote to already obtained votes for the concrete owner/vehicle
     **/
    void addVote();

    /**
     * Extracts the favourite player from the user/NPC
     *
     * @return name of the favourite player
     */
    String giveVote();

}
