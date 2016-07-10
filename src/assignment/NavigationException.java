package assignment;

/**
 * @author Robin Fritz
 * @version 1.0
 */
public class NavigationException extends Exception {

    /**
     * Exception for navigation system type errors.
     *
     * @param message Specified message, if exception is thrown
     */
    public NavigationException(String message) {
        super(message);
    }
}
