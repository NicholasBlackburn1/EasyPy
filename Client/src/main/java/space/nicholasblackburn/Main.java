/**
 * This Class Is Where All The Main Program Runs from
 * 
 * @author Nicholas Blackburn
 */
package space.nicholasblackburn;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import space.nicholasblackburn.gui.MainGui;

public class Main {
    public static Logger logger = Logger.getLogger("Client");

    public static void main(final String[] args) {

        logger.info("loading Javafx client");

        MainGui.main(args);
    }
}