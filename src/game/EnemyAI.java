package game;

import java.util.*;

/**
 *  EnemyAI class represents non-person character, which is controlled by the computer. It is used to contain necessary data to fill the voting statistic.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class EnemyAI extends Participant implements Decision{

    /**
     * This field represents serial number of the NPC
     */
    private int serialNumber;

    /**
     * This method is used to set serial number of the NPC
     */
    public void setSerialNumber(int number){
        this.serialNumber = number;
    }

    /**
     * This method is implemented from the Decision interface and is used to vote for vehicle based on the choice from voting statistic.
     */
    @Override
    public void voteForVehicle(HashMap<String, UserRecognition> votingStatistic) {
        /*
        * This single line replaces whole for loop and retrieves all keys - names of users
        * */
        List<String> listOfParticipants = new ArrayList<>(votingStatistic.keySet());

        // Create a Random object
        Random random = new Random();

        // Shuffle the list to randomize the order
        Collections.shuffle(listOfParticipants, random);
        setFavourite(listOfParticipants.getFirst());
        UserRecognition votingCandidate =  votingStatistic.get(getFavourite());
        votingCandidate.addVote();
        votingStatistic.put(giveVote(), votingCandidate);
    }

    /**
     * The implementation is not finished yet!!!
     *
     * @return name of user to which belongs the favourite vehicle
     */
    @Override
    public String giveVote() {
        return getFavourite();
    }

}
