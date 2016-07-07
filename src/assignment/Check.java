package assignment;

import java.util.List;

/**
 * Created by Robin Fritz on 01.07.2016.
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
     *
     * @param input
     */
    public static boolean existsVertex(String input) {
        if (true) { //vertices.contains(input)) {
            return true;
        }
        return false;
    }

    public static boolean existsEdge(String input1, String input2) {
        if (true) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param VertexA
     * @param VertexB
     * @throws NavigationException
     */
    public static void checkEquals(String VertexA, String VertexB) throws NavigationException {
        if (VertexA.toUpperCase().equals(VertexB.toUpperCase())) {
            throw new NavigationException("Error, please choose two vertices that are not the same!");
        }
    }
}
