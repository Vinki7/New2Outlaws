package game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *  VotingControl controls the whole voting process, handles logic and data related to voting.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class VotingControl {

    /**
     * Serves for mapping players. Works as Composite design pattern
     */
    private HashMap<String, UserRecognition> votingStatistic = new HashMap<>();

    /**
     * Represents winner chosen during the voting process
     */
    private UserRecognition winner;

    /**
     * Method which provides access to the Composite (mapped players) and provides data
     *
     * @return composite (mapped players)
     */
    public HashMap<String, UserRecognition> getVotingStatistic(){
        return this.votingStatistic;
    }

    /**
     * Method to insert enemies generated in separate thread to the composite (mapped players/voting statistic)
     *
     * @param enemies represents list of enemies which will be inserted to the composite (voting statistic)
     */
    public void fillCompositeByEnemies(ArrayList<EnemyAI> enemies){
        for (EnemyAI enemy: enemies){
            votingStatistic.put(enemy.getUsername(), enemy);
        }
    }

    /**
     * Method to insert user to the composite (voting statistics)
     *
     * @param user represents person which will be inserted to the composite
     */
    public void addUser(User user){
        votingStatistic.put(user.getUsername(), user);
    }

    /**
     * Method traversing the composite and searching for the player with the highest vote count which is eventually set as winner
     */
    public void setWinner(){
        ArrayList<String> listOfParticipants = new ArrayList<>(votingStatistic.keySet());
        UserRecognition possibleWinner = null;
        int winnerVotes = 0;

        // Go through listOfParticipants and search the participant with most votes
        for (String key: listOfParticipants){
            if (winnerVotes < votingStatistic.get(key).getVotes()){
                possibleWinner = votingStatistic.get(key);
                winnerVotes = possibleWinner.getVotes();
            }
        }

        // Finally set winner
        this.winner = possibleWinner;
    }

    /**
     * Method which provides access to the winner field and necessary data stored in there.
     *
     * @return winner of the voting process using the {@link UserRecognition} interface to provide only necessary data
     */
    public UserRecognition getWinner(){
        return winner;
    }


}
