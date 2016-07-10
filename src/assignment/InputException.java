package assignment;

/**
 * @author Robin Fritz
 * @version final version
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
