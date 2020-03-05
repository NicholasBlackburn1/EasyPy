/**
 * This Class Is Where All The Main Program Runs from
 * 
 * @author Nicholas Blackburn
 */
package space.nicholasblackburn;

import java.io.PrintStream;
import java.util.logging.Logger;

import space.nicholasblackburn.gui.MainGui;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(final String[] args) {
        logger.info("loading Javafx client");

        MainGui.main(args);
    }
}