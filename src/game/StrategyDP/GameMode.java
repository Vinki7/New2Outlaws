package game.StrategyDP;

/**
 * Abstract parental class which serves as a template for strategies in Strategy DP
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public abstract class GameMode {
    /**
     * This field represents game difficulty
     */
    private String difficulty;// game difficulty
    /**
     * This field represents budget size which affects final vehicle configuration
     */
    private int budgetSize;

    /**
     * This method is used to add difficulty to the game mode
     * 
     * @param difficulty represents difficulty chosen by user
     */
    void addDifficulty(String difficulty){
        this.difficulty = difficulty.toUpperCase();
    }

    /**
     * This method is used to set budget size to the game mode
     * 
     * @param budgetSize represents budget extracted from chosen difficulty
     */
    void addBudget(int budgetSize){
        this.budgetSize = budgetSize;
    }

    /**
     * This method is used to get difficulty of the game mode
     * 
     * @return difficulty of the game mode
     */
    String difficulty(){
        return this.difficulty;
    }

    /**
     * This method is used to get budget size of the game mode
     * 
     * @return budget size of the game mode
     */
    int budgetSize(){
        return this.budgetSize;
    }

}
