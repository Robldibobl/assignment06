package assignment;

import edu.kit.informatik.Terminal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin Fritz on 01.07.2016.
 */
public class NavigationSystem {
    private List<String> vertices;
    private List<String> edges;
    private int[][] distances;
    private final String PATH;

    /**
     * Constructor of the class NavigationSystem.
     *
     * @param path Commandline parameter
     * @throws InputException      For input format type errors
     * @throws NavigationException For navigation system type errors
     */
    public NavigationSystem(String path) throws InputException, NavigationException {
        PATH = path;
        readIn();
        generateMatrix();
        fillMatrix();
    }

    public int test(String[] param) throws InputException {
        String a = param[0];
        String b = param[1];

        if (true) {
            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).equals(a)) {
                    for (int j = 0; j < vertices.size(); j++) {
                        if (vertices.get(j).equals(b)) {
                            return distances[i][j];
                        }
                    }
                }
            }
        }
        return 37;
    }

    public String testMatrix(String[] param) throws InputException {
        String output = new String();
        int temp;

        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                temp = distances[i][j];

                output += "" + temp + " ";
            }
            output += "" + "\n";
        }
        output = output.trim();

        return output;
    }

    /**
     * Divides the input from the text file into vertices and edges.
     */
    public void readIn() {
        String[] serialization = Terminal.readFile(PATH);
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        boolean readVertices = true;

        for (int i = 0; i < serialization.length; i++) {
            if (readVertices && serialization[i].equals("--")) {
                readVertices = false;
                i++;
            }
            if (readVertices) {
                vertices.add(serialization[i].toLowerCase());
            } else {
                edges.add(serialization[i].toLowerCase());
            }
        }
    }

    /**
     * Generates a matrix with the size of the number of vertices.
     */
    public void generateMatrix() {
        distances = new int[vertices.size()][vertices.size()];
    }

    /**
     * Fills the matrix with the distance between two vertices marking the indexes.
     *
     * @throws InputException      For input format type errors
     * @throws NavigationException For navigation system type errors
     */
    public void fillMatrix() throws InputException, NavigationException {
        String tempA;
        String tempB;
        int distance;

        for (int k = 0; k < edges.size(); k++) {
            String[] matrixEntries = edges.get(k).split(";");
            tempA = matrixEntries[0];
            tempB = matrixEntries[1];

            try {
                Integer.parseInt(matrixEntries[2]);
            } catch (NumberFormatException e) {
                throw new InputException("Error, please choose a number as distance!");
            }
            Check.checkInteger(Integer.parseInt(matrixEntries[2]));

            distance = Integer.parseInt(matrixEntries[2]);

            Check.checkEquals(tempA, tempB);

            for (int i = 0; i < vertices.size(); i++) {
                if (vertices.get(i).equals(tempA)) {
                    for (int j = 0; j < vertices.size(); j++) {
                        if (vertices.get(j).equals(tempB)) {
                            distances[i][j] = distance;
                            distances[j][i] = distance;
                        }
                    }
                }
            }
        }
    }

    private String generateOutput() {
        String output = new String();

        for (int i = 0; i < vertices.size(); i++) {
            output += "" + vertices.get(i) + "\n";
        }
        output += "" + "--" + "\n";

        for (int j = 0; j < edges.size(); j++) {
            output += "" + edges.get(j) + "\n";
        }
        output = output.trim();

        return output;
    }

    public int search(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 2);
        SSSP algorithm = new SSSP(vertices, distances, param[0]);

        if (!vertices.contains(param[0]) || !vertices.contains(param[1])) {
            throw new NavigationException("Error, please choose two existing vertices!");
        }

        return algorithm.search(param[1]);
    }

    public String route(String[] param) throws InputException {
        Check.checkAmount(param, 2);
        SSSP algorithm = new SSSP(vertices, distances, param[0]);

        if (true) {

        }

        return algorithm.route(param[1]);
    }

    /*
    noch nicht getestet
     */
    public String insert(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 3);
        Check.checkString(param[0]);
        Check.checkString(param[1]);
        param[0] = param[0].toLowerCase();
        param[1] = param[1].toLowerCase();

        if (!vertices.contains(param[0]) && !vertices.contains(param[1])) {
            throw new NavigationException("Error, please choose at least one existing vertex!");
        } else {
            if (!vertices.contains(param[0])) {
                vertices.add(param[0]);
            }
            if (!vertices.contains(param[1])) {
                vertices.add(param[1]);
            }
        }

        int number;
        try {
            Integer.parseInt(param[2]);
        } catch (NumberFormatException e) {
            throw new InputException("Error, please choose a number!");
        }
        Check.checkInteger(Integer.parseInt(param[2]));
        number = Integer.parseInt(param[2]);

        for (int i = 0; i < distances.length; i++) {
            if (vertices.get(i).equals(param[0])) {
                for (int j = 0; j < distances.length; j++) {
                    if (vertices.get(j).equals(param[1])) {
                        if (distances[i][j] != 0) {
                            throw new NavigationException("Error, edge already exists!");
                        }
                        distances[i][j] = number;
                        distances[j][i] = number;

                        edges.add(param[0] + ";" + param[1] + ";" + param[2]);
                    }
                }
            }
        }

        return "OK";
    }

    /**
     * Prints out the current graph.
     *
     * @param param String array with parameters
     * @return Returns the list of vertices and edges
     * @throws InputException For input format type errors
     * @throws IOException    For navigation system type errors
     */
    public String info(String[] param) throws InputException, IOException {
        Check.checkAmount(param, 0);

        return generateOutput();
    }

    /**
     * Prints out all neighboring vertices.
     *
     * @param param String array with parameters
     * @return Returns all neighboring vertices
     * @throws InputException      For input format type errors
     * @throws NavigationException For navigation system type errors
     */
    public String nodes(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 1);
        param[0] = param[0].toLowerCase();
        String output = new String();

        if (vertices.contains(param[0])) {
            for (int i = 0; i < distances.length; i++) {
                if (vertices.get(i).equals(param[0])) {
                    for (int j = 0; j < distances.length; j++) {
                        if (distances[i][j] != 0) {
                            output += "" + vertices.get(j) + "\n";
                        }
                    }
                }
            }
        } else {
            throw new NavigationException("Error, the given vertex does not exist!");
        }

        output = output.trim();
        return output;
    }

    /**
     * Prints out all vertices.
     *
     * @param param String array with parameters
     * @return Returns all vertices
     * @throws InputException For input format type errors
     */
    public String vertices(String[] param) throws InputException {
        Check.checkAmount(param, 0);
        String output = new String();

        for (int i = 0; i < vertices.size(); i++) {
            output += "" + vertices.get(i) + "\n";
        }

        output = output.trim();
        return output;
    }
}
