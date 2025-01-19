package Exceptions;

/**
 *  This exception should be thrown during purchase when the budget of the owner is insufficient to the value of which should be the budget decreased.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public final class InsufficientFunds extends Exception{

    /**
     * This method provides the exception message.
     *
     * @return is String which represents the desired message.
     */
    public String getMessage(){
        return "Insufficient funds in budget";
    }
}
