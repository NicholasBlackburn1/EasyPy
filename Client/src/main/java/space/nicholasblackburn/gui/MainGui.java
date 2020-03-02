package space.nicholasblackburn.gui;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import space.nicholasblackburn.Main;
import space.nicholasblackburn.networking.UDPClient;

public class MainGui extends Application {

    public UDPClient client = new UDPClient();

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

            client.sendUdp();

        } catch (Exception e) {

            e.printStackTrace();
            Main.logger.severe("JAVAFX error" + e.getMessage());
        }

    }

    public static void main(final String[] args) {
        launch(args);
    }
}