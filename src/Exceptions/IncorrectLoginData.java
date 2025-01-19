package Exceptions;

/**
 *  This exception should be thrown during the login process when either username or password does not fill the conditions for successful process.
 *
 *  @author Šimon Vinkler
 *  @version 1.0
 *  @since 1.3.2024
 */
public class IncorrectLoginData extends Exception{

    /**
     * Field exc represents the statement given during the initialisation of the new object in code by developer.
     */
    private final String exc;

    /**
     * Constructor of the exception class/object.
     *
     * @param exceptionMessage is provided by developer and during the process assigned to the exc field
     */
    public IncorrectLoginData(String exceptionMessage){
        this.exc = exceptionMessage;
    }

    /**
     * Method which provides the exception message extracted from exc field
     *
     * @return is String representing the desired message
     */
    public String getMessage(){
        return exc;
    }
}
