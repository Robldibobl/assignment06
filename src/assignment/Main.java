package assignment;

import edu.kit.informatik.Terminal;

import java.io.IOException;

/**
 * Created by Robin Fritz on 01.07.2016.
 */
public class Main {

    /**
     * Main method; splits input into commands and parameters.
     *
     * @param args Commandline parameters
     */
    public static void main(String[] args) {
        NavigationSystem navigation = null;
        try {
            navigation = new NavigationSystem(args[0]);
        } catch (InputException | NavigationException e) {
            Terminal.printLine(e.getMessage());
        }
        boolean b = true;

        while (b == true) {
            String input = Terminal.readLine();
            if (input.equals("quit")) {
                b = false;
            } else {

                try {
                    String[] inputArr = input.split(" ");
                    if (inputArr.length > 2) {
                        throw new InputException("Error, wrong input format!");
                    }
                    String[] param = new String[0];
                    if (inputArr.length == 2) {
                        if (inputArr[1].charAt(inputArr[1].length() - 1) == ';') {
                            throw new InputException("Error, wrong input format!");
                        }
                        param = inputArr[1].split(";");
                    }

                    switch (inputArr[0]) {
                        case "test":
                            Terminal.printLine(navigation.test(param));
                            break;

                        case "search":
                            Terminal.printLine(navigation.search(param));
                            break;

                        case "route":
                            Terminal.printLine(navigation.route(param));
                            break;

                        case "insert":
                            Terminal.printLine(navigation.insert(param));
                            break;

                        case "info":
                            Terminal.printLine(navigation.info(param));
                            break;

                        case "nodes":
                            Terminal.printLine(navigation.nodes(param));
                            break;

                        case "vertices":
                            Terminal.printLine(navigation.vertices(param));
                            break;

                        default:
                            throw new InputException("Error, unknown command!");
                    }
                } catch (InputException | NavigationException | IOException e) {
                    Terminal.printLine(e.getMessage());
                }
            }
        }
    }
}
