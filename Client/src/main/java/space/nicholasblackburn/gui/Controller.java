/**
 * This class is an fxml controller for all  of the display objects     
 */
package space.nicholasblackburn.gui;

import javax.annotation.ParametersAreNonnullByDefault;

import org.checkerframework.checker.units.qual.C;

import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public CategoryAxis xAxis = new CategoryAxis();
    public NumberAxis yAxis = new NumberAxis();

    @FXML
    public LineChart chart = new LineChart<>(xAxis, yAxis);

    @FXML
    public ProgressIndicator CPU = new ProgressIndicator();
    public ProgressIndicator RAM = new ProgressIndicator();
    public ProgressIndicator DISKIO = new ProgressIndicator();

    @FXML
    private TextField ip;
    private TextField port;

    public void initialize() {
        // Chart config
        xAxis.setLabel("heat");
        yAxis.setLabel("cpu speed");
        chart.setTitle("Server Effenciety");

    }

    public void textHandler(final ActionEvent event) {

    }

    // Returns Ip address typed in by the user
    public String setIpAddress() {
        return ip.getText();
    }

    // Returns port address typed in by the user
    public String setPortNumber() {
        return port.getText();
    }

    public IPAddress convertStringtoIP() {

        return new IPAddressString(setIpAddress()).getAddress();
    }
}