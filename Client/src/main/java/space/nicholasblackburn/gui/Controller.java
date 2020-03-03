/**
 * This class is an fxml controller for all  of the display objects     
 */
package space.nicholasblackburn.gui;

import javax.annotation.ParametersAreNonnullByDefault;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;

import org.checkerframework.checker.units.qual.C;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.IncompatibleAddressException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class Controller {
    @FXML // fx:id="yAxis"
    private NumberAxis yAxis; // Value injected by FXMLLoader

    @FXML // fx:id="xAxis"
    private CategoryAxis xAxis; // Value injected by FXMLLoader

    @FXML // fx:id="port"
    private JFXPasswordField port; // Value injected by FXMLLoader

    @FXML
    private JFXPasswordField ip;

    @FXML // fx:id="CPU"
    private JFXSpinner CPU; // Value injected by FXMLLoader

    @FXML // fx:id="enablessh1"
    private JFXCheckBox openlog; // Value injected by FXMLLoader

    @FXML // fx:id="chart"
    private LineChart<Number, Number> chart; // Value injected by FXMLLoader

    @FXML // fx:id="DISK"
    private JFXSpinner DISK; // Value injected by FXMLLoader

    @FXML // fx:id="open"
    private JFXButton open; // Value injected by FXMLLoader

    @FXML // fx:id="RAM"
    private JFXSpinner RAM; // Value injected by FXMLLoader

    @FXML // fx:id="enablessh"
    private JFXCheckBox enablessh; // Value injected by FXMLLoader

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

    public IPAddress convertStringtoIP() throws AddressStringException, IncompatibleAddressException {

        return new IPAddressString(setIpAddress()).toAddress();
    }
}