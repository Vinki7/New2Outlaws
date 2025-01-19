package Exceptions;

/**
 *  This exception should be thrown during the registration process when provided credentials don't match the desired format or don't stand up to conditions in the logic of the process.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class IncorrectRegistrationData extends Exception{

    /**
     * This field represents the message which is assigned during the creation process of new instance of the exception
     */
    String message;

    /**
     * Constructor, here is the message provided by developer being assigned to the field called message.
     *
     * @param message
     */
    public IncorrectRegistrationData(String message){
        this.message = message;
    }

    /**
     * This method overrides method from the parental class {@link Exception} and provides the message from field message.
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}
