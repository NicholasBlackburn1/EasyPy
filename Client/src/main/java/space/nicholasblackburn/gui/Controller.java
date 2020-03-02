package space.nicholasblackburn.gui;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ProgressIndicator;

public class Controller {

    @FXML
    public LineChart<Number, Number> chart;

    @FXML
    public CategoryAxis xAxis;
    public NumberAxis yAxis;

    @FXML
    public ProgressIndicator CPU;
    public ProgressIndicator RAM;
    public ProgressIndicator DISKIO;

}