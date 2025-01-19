package game;

import java.util.HashMap;

/**
 *  Decision interface is used to determine the decision of player or NPC. It is used to vote for vehicle in this case.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public interface Decision {
    /**
     * This method is used to vote for vehicle based on the choice from voting statistic.
     * 
     * @param votingStatistic represents composite design pattern, which contains necessary data of players for voting
     */
    void voteForVehicle(HashMap<String, UserRecognition> votingStatistic);
}
