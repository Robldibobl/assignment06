package assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robin Fritz
 * @version final version
 */
public class ShortestPath {
    private List<DijkstraEntry> dijkstraTable;
    private DijkstraEntry current;
    private List<String> vertices;

    /**
     * Constructor of the class ShortestPath.
     *
     * @param vertices List of vertices
     * @param graph    Matrix with entries displaying the distances between vertices which are the indexes
     * @param s        Starting point of the search
     */
    public ShortestPath(List<String> vertices, int[][] graph, String s) {
        this.vertices = vertices;
        generateTable(vertices);
        setStart(s);

        while (!allVisited()) {
            checkDistance(graph);
        }
    }

    /**
     * Method to return the shortest distance to the destination vertex.
     *
     * @param z Destination of the search
     * @return Returns the shortest distance between start and destination
     */
    public int search(String z) {
        return getVertex(z).getDistance();
    }

    /**
     * Method to return the shortest route to the destination vertex.
     *
     * @param z Destination of the route
     * @return Returns the shortest route between start and distance separated with one space in between vertices
     */
    public String route(String z) {
        String result = new String();
        String temp = z;

        while (!temp.equals(null)) {
            result = temp + " " + result;
            if (getVertex(temp).getPrevious() == null) {
                break;
            }
            temp = getVertex(temp).getPrevious().getVertex();
        }

        return result.trim();
    }

    private void generateTable(List<String> vertices) {
        dijkstraTable = new ArrayList<>();

        for (String val : vertices) {
            dijkstraTable.add(new DijkstraEntry(val));
        }
    }

    private DijkstraEntry getVertex(String name) {
        for (DijkstraEntry val : dijkstraTable) {
            if (val.getVertex().equals(name)) {
                return val;
            }
        }

        return null;
    }

    private void setStart(String s) {
        DijkstraEntry temp = getVertex(s);
        temp.setDistance(0);
        temp.setVisited();
        current = temp;
    }

    private void checkDistance(int[][] graph) {
        DijkstraEntry temp = current;
        DijkstraEntry z = current;

        for (int i = 0; i < vertices.size(); i++) {
            if (dijkstraTable.get(i).isEqual(current)) {
                for (int j = 0; j < vertices.size(); j++) {
                    z = dijkstraTable.get(j);

                    if (graph[i][j] != 0 & !z.isVisited()) {
                        if (graph[i][j] + current.getDistance() < z.getDistance()) {
                            z.setDistance(graph[i][j] + current.getDistance());
                            z.setPrevious(current);

                            if (temp.isEqual(current)) {
                                temp = z;
                            } else if (z.getDistance() < temp.getDistance()) {
                                temp = z;
                            }
                        }
                    }
                }
            }
        }

        if (temp.isEqual(current)) {
            temp = getSmallestDistance();
        }
        current.setVisited();
        current = temp;
    }

    private DijkstraEntry getSmallestDistance() {
        int dist = Integer.MAX_VALUE;
        DijkstraEntry result = new DijkstraEntry("NONE");
        result.setVisited();
        for (DijkstraEntry val : dijkstraTable) {
            if (!val.isVisited() && val.getDistance() <= dist) {
                dist = val.getDistance();
                result = val;
            }
        }
        return result;
    }

    private boolean allVisited() {
        for (DijkstraEntry val : dijkstraTable) {
            if (!val.isVisited()) {
                return false;
            }
        }
        return true;
    }
}