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

public class MainGui extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        // Loads fxml file
        try {
            Controller controller = new Controller();
            FXMLLoader loader = new FXMLLoader();

            loader.setController(controller);

            final Parent root = FXMLLoader.load(getClass().getResource("/mainpage.fxml"));
            Scene scene = new Scene(root, 700, 400);

            stage.setTitle("EsayPi Monitor");

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void GraphInit() {
        xAxis.setLabel("telp");

        xAxis.setAutoRanging(true);
        xAxis.setTickLabelsVisible(true);
        xAxis.setTickMarkVisible(true);

        yAxis.setAutoRanging(true);
        yAxis.setTickLabelsVisible(true);

    }

    public static void main(final String[] args) {
        launch(args);
    }
}