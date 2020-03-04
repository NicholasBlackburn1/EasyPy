/**
 * This Class Is Where All The Main Program Runs from
 * 
 * @author Nicholas Blackburn
 */
package space.nicholasblackburn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import space.nicholasblackburn.gui.MainGui;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(final String[] args) {

        logger.info("loading Javafx client");

        MainGui.main(args);
    }
}