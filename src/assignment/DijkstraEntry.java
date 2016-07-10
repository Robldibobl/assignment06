package assignment;

/**
 * Created by Robin Fritz on 09.07.2016.
 */
public class DijkstraEntry {
    private String vertex;
    private boolean visited;
    private int distance;
    private DijkstraEntry previous;

    public DijkstraEntry(String vertex) {
        this.vertex = vertex;
        this.visited = false;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
    }

    public boolean isEqual(DijkstraEntry de) {
        if (de.getVertex().equals(this.vertex)) {
            return true;
        }
        return false;
    }

    public String getVertex() {
        return vertex;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getDistance() {
        return distance;
    }

    public DijkstraEntry getPrevious() {
        return previous;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPrevious(DijkstraEntry previous) {
        this.previous = previous;
    }
}
