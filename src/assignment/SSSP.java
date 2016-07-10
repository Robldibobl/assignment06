package assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin Fritz on 09.07.2016.
 */
public class SSSP { //Single Source Shortest Path
    private List<DijkstraEntry> dijkstraTable;
    private DijkstraEntry current;
    private List<String> vertices;

    public SSSP(List<String> vertices, int[][] graph, String s) {
        this.vertices = vertices;
        generateTable(vertices);
        setStart(s);

        while (!allVisited()) {
            checkDistance(graph);
        }
    }

    public int search(String z) {
        return getVertex(z).getDistance();
    }

    public String route(String z) {
        String result = new String();
        String temp = z;

        while (!temp.equals(null)) {
            result = temp + " " + result;
            temp = getVertex(temp).getPrevious().getVertex();
        }

        result = result.trim();
        return result;
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
        current = temp;
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