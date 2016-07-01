package assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01.07.2016.
 */
public class Graph {
    private List<Graph> vertices = new ArrayList<>();
    private List<Graph> edges = new ArrayList<>();

    public Graph(List<Graph> vertices, List<Graph> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public Graph() {

    }

    public List<Graph> getVertices() {
        return vertices;
    }
}

/**
 * Knoten/Kanten in ArrayLists speichern
 *
 *
 */
