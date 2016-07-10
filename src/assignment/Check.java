package assignment;

/**
 * @author Robin Fritz
 * @version 1.0
 */
public class Check {

    /**
     * Checks if input is an integer.
     *
     * @param input Input from terminal
     * @throws InputException For input format type errors
     */
    public static void checkInteger(int input) throws InputException {
        if (input < 0) {
            throw new InputException("Error, please choose a number as distance!");
        }
    }

    /**
     * Checks length of parameter array.
     *
     * @param param Input
     * @param n     Number of required parameters
     * @throws InputException For input format type errors
     */
    public static void checkAmount(String[] param, int n) throws InputException {
        if (param.length != n) {
            throw new InputException("Error, wrong input format!");
        }
    }

    /**
     * Checks if a string contains only letters.
     *
     * @param input Input
     * @throws InputException For input format type errors
     */
    public static void checkString(String input) throws InputException {
        String temp = input;
        temp = temp.replaceAll("[*0-9]", "");

        if (input.matches("")) {
            throw new InputException("Error, vertex names can not be empty!");
        }

        if (input.contains(",")) {
            throw new InputException("Error, vertex names can only contain letters!");
        }

        if (!temp.matches(input)) {
            throw new InputException("Error, vertex names can only contain letters!");
        }
    }

    /**
     * Checks if the two vertices are the same.
     *
     * @param vertexA Input one
     * @param vertexB Input two
     * @throws NavigationException For navigation system type errors
     */
    public static void checkEquals(String vertexA, String vertexB) throws NavigationException {
        if (vertexA.toLowerCase().equals(vertexB.toLowerCase())) {
            throw new NavigationException("Error, please choose two vertices that are not the same!");
        }
    }
}