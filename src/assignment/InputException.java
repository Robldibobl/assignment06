package assignment;

/**
 * Created by Robin Fritz on 01.07.2016.
 */
public class InputException extends Exception {

    /**
     * Exception for input format type errors.
     *
     * @param message Specified message, if exception is thrown
     */
    public InputException(String message) {
        super(message);
    }
}
