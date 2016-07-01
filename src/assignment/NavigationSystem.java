package assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin Fritz on 01.07.2016.
 */
public class NavigationSystem {
    private List<Graph> vertices;
    private List<Graph> edges;
    private Graph graph;

    public NavigationSystem() {
        graph = new Graph();
        vertices = new ArrayList<>();
        edges = new ArrayList<>()

    }

    public void search(String[] param) throws InputException {
        Check.checkAmount(param, 2);
        Check.checkVertice(param[0]);
        Check.checkVertice(param[1]);

    }

    public void route(String[] param) throws InputException {
        Check.checkAmount(param, 2);
    }

    public void insert(String[] param) throws InputException {
        Check.checkAmount(param, 3);
        Check.checkVertice(param[0]);
        Check.checkVertice(param[1]);
        Check.checkInteger(Integer.parseInt(param[2]));

    }

    public void info(String[] param) throws InputException {
        Check.checkAmount(param, 0);
    }

    public void nodes(String[] param) throws InputException {
        Check.checkAmount(param, 1);
        Check.checkVertice(param[0]);
    }

    public void vertices(String[] param) throws InputException {
        Check.checkAmount(param, 0);

    }
}
