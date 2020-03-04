package space.nicholasblackburn.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import space.nicholasblackburn.*;

public class LogGui extends Application {

    static Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        Main.logger.info("[log page]" + "trying to load fxml");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/logwindow.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            Main.logger.info("[Log page]" + "Showing scene ");
            stage.show();

            Main.logger.warn("[log page]" + "Running upodate");

        } catch (Exception e) {

            e.printStackTrace();
            Main.logger.error("[log page]" + "JAVAFX error" + e.getMessage());
        }

    }

    public void Run() {
        try {

            start(stage);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}