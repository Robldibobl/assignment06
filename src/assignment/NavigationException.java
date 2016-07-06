package assignment;

/**
 * Created by Robin Fritz on 01.07.2016.
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
