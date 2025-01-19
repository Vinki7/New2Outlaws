package Exceptions;

/**
 *  This exception should be thrown when it comes to adding new item to the composite and during the process is the same item found in it.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class Duplicate extends Exception{
    /**
     * This method provides an exception message. It also overrides method from extended class {@link Exception}.
     *
     * @return is the message which should be provided
     */
    @Override
    public String getMessage() {
        return "This vehicle already contains the purchased particle, refund in process...";
    }
}
