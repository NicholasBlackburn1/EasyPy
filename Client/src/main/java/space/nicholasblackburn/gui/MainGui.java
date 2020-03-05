package space.nicholasblackburn.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import space.nicholasblackburn.Main;

public class MainGui extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        // Loads fxml file
        Main.logger.info("trying to load fxml");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainpage.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            Main.logger.info("Showing scene ");
            stage.show();

            Main.logger.info("Running upodate");

        } catch (Exception e) {

            e.printStackTrace();
            Main.logger.warning("JAVAFX error" + e.getMessage());
        }

    }

    public static void main(final String[] args) {
        launch(args);
    }
}