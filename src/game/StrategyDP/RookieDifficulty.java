package game.StrategyDP;

/**
 * This class represents rookie difficulty level of the game, implements Difficulty interface and extends GameMode class. Represents one of the concrete strategies in Strategy DP and defines methods for setting difficulty and budget size of the game.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class RookieDifficulty extends GameMode implements Difficulty {

    /**
     * This method is used to set difficulty level of the game
     */
    @Override
    public void setDifficulty() {
        this.addDifficulty("Rookie");
    }

    /**
     * This method is used to set budget size of the game which is later used to determine final vehicle configuration
     */
    @Override
    public void setBudget() {
        this.addBudget(12500);
    }

    /**
     * This method is used to get defined budget size of the game
     * 
     * @return budget size of the game
     */
    @Override
    public int getBudget() {
        return this.budgetSize();
    }

    /**
     * This method is used to get difficulty of the game
     * 
     * @return difficulty of the game
     */
    @Override
    public String getDifficulty() {
        return this.difficulty();
    }

}
