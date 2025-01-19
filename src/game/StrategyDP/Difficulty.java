package game.StrategyDP;

/**
 * This is interface created for strategy DP, includes methods which are crucial for managing game difficulty.
 * 
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public interface Difficulty {
    /**
     * This method is used to set difficulty level of the game
     */
    void setDifficulty();

    /**
     * This method is used to set budget size of the game which is later used to determine final vehicle configuration
     */
    void setBudget();

    /**
     * This method is used to get defined budget size of the game
     * 
     * @return budget size of the game
     */
    int getBudget();

    /**
     * This method is used to get difficulty of the game
     * 
     * @return difficulty of the game
     */
    String getDifficulty();

}
