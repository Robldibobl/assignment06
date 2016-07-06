package assignment;

import edu.kit.informatik.Terminal;

/**
 * Created by Robin Fritz on 01.07.2016.
 */
public class NavigationSystem {
    private String[] serialization;
    private String[] vertices;
    private String[] edges;

    public NavigationSystem() {
        serialization = new String[]{Terminal.readFile());
        vertices = serialization.split("--");
    }

    public int search(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 2);
        Check.existsVertice(param[0]);
        Check.existsVertice(param[1]);

        int distance = 0;

        /*
        Distanz zwischen Startstadt und Zielstadt wird ermittelt, als distance ausgegeben
         */

        return distance;
    }

    public String route(String[] param) throws InputException {
        Check.checkAmount(param, 2);

        String route = new String();

        /*
        Geht nach dem Algorithmus durch den Graphen, gibt die berechnete Route im String route aus
         */

        return route;
    }

    public String insert(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 3);

        if (!Check.existsVertice(param[0]) && !Check.existsVertice(param[1])) {
            throw new NavigationException("Error, please choose at least one existing vertice!");
        }

        int number;
        try {
            number = Integer.parseInt(param[0]);
        } catch (NumberFormatException e) {
            throw new InputException("Error, please choose a number!");
        }
        Check.checkInteger(Integer.parseInt(param[2]));

        if (Check.existsEdge(param[0], param[1])) {
            throw new NavigationException("Error, edge already exists!");
        }

        /*
        Falls mindestens einer der Knoten existiert: fügt den nicht existierenden dem Graphen hinzu und
        erstellt eine Kante zwischen den beiden der Länge number
         */

        return "OK";
    }

    public String[] info(String[] param) throws InputException {
        Check.checkAmount(param, 0);

        String[] serialization = new String[]{};

        /*
        Aktualisiert das ursprüngliche input String array und gibt es aus (dieses dann auch in der input Datei
        speichern)
         */

        return serialization;
    }

    public String nodes(String[] param) throws InputException, NavigationException {
        Check.checkAmount(param, 1);
        String output = new String();

        if (Check.existsVertice(param[0])) {
            for (int i = 0; i < X; i++) {
                if () {
                    output += "" + vertices.get(i) + "\n";
                }
            }
        } else {
            throw new NavigationException("Error, the given vertice does not exist!");
        }

        output = output.trim();
        return output;
    }

    public String[] vertices(String[] param) throws InputException {
        Check.checkAmount(param, 0);

        return vertices;
    }
}
