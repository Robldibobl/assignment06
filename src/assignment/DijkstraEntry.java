package assignment;

/**
 * @author Robin Fritz
 * @version 1.0
 */
public class DijkstraEntry {
    private String vertex;
    private boolean visited;
    private int distance;
    private DijkstraEntry previous;

    /**
     * Creates entries for each vertex.
     *
     * @param vertex Name of a vertex
     */
    public DijkstraEntry(String vertex) {
        this.vertex = vertex;
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
    }

    /**
     * Checks if two vertices are the same.
     *
     * @param de DijkstraEntry passed down to this boolean
     * @return Returns true or false
     */
    public boolean isEqual(DijkstraEntry de) {
        if (de.getVertex().equals(this.vertex)) {
            return true;
        }
        return false;
    }

    /**
     * Getter for the name of a vertex.
     *
     * @return Returns the name of a vertex
     */
    public String getVertex() {
        return vertex;
    }

    /**
     * Getter for the boolean visited.
     *
     * @return Returns true or false
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Getter for distance.
     *
     * @return Returns the distance between vertices
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Getter for a previous vertex.
     *
     * @return Returns the previous vertex
     */
    public DijkstraEntry getPrevious() {
        return previous;
    }

    /**
     * Setter for the boolean visited.
     */
    public void setVisited() {
        this.visited = true;
    }

    /**
     * Setter for distance.
     *
     * @param distance Distance between vertices
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Setter for a previous vertex.
     *
     * @param previous Previous vertex
     */
    public void setPrevious(DijkstraEntry previous) {
        this.previous = previous;
    }
}