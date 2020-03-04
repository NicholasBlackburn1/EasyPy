/**
 * This class is an fxml controller for all  of the display objects     
 */
package space.nicholasblackburn.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.ParametersAreNonnullByDefault;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXToggleButton;

import org.checkerframework.checker.units.qual.C;

import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.IncompatibleAddressException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.Duration;
import space.nicholasblackburn.Main;
import space.nicholasblackburn.gui.LogGui;

public class MainPageController implements Initializable {

    private LogGui loggui = new LogGui();

    @FXML // fx:id="yAxis"
    private NumberAxis yAxis; // Value injected by FXMLLoader

    @FXML // fx:id="xAxis"
    private CategoryAxis xAxis; // Value injected by FXMLLoader

    @FXML // fx:id="port"
    private JFXPasswordField port; // Value injected by FXMLLoader

    @FXML
    private JFXPasswordField ip;

    @FXML // fx:id="CPU"
    public JFXSpinner CPU; // Value injected by FXMLLoader

    @FXML // fx:id="enablessh1"
    private JFXCheckBox openlog; // Value injected by FXMLLoader

    @FXML // fx:id="chart"
    private LineChart<Number, Number> chart; // Value injected by FXMLLoader

    @FXML
    public JFXToggleButton connect;

    @FXML // fx:id="DISK"
    private JFXSpinner DISK; // Value injected by FXMLLoader

    @FXML // fx:id="open"
    private JFXButton open; // Value injected by FXMLLoader

    @FXML // fx:id="RAM"
    private JFXSpinner RAM; // Value injected by FXMLLoader

    @FXML // fx:id="enablessh"
    private JFXCheckBox enablessh; // Value injected by FXMLLoader

    public ToggleGroup ConnectGroup = new ToggleGroup();

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        // Chart config for tile and x and y axis
        xAxis.setLabel("heat");
        yAxis.setLabel("cpu speed");
        chart.setTitle("Server Effenciety");

        RAM.progressProperty().set(0);
        CPU.progressProperty().set(0);
        DISK.progressProperty().set(0);

        connect.setToggleGroup(ConnectGroup);

        // Creates an actiont that runs on a button click
        connect.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection
                openServerHandler();

            }
        });

        // opens log window
        openlog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Opens Log Menu
                openLogHandler();
            }
        });
    }

    // Simply Calls Function On Open server Button PRess
    public void openServerHandler() {

        try {

            if (this.connect.isSelected()) {
                Main.logger.warn("Button pressed opening");
            }

        } catch (final Exception e) {
            e.printStackTrace();

        }
    }

    // Simply Calls Function On Open server Button PRess
    public void openLogHandler() {

        Stage stage = new Stage();

        try {

            if (this.openlog.isSelected()) {
                Main.logger.warn("Logger opeing pressed opening");
                loggui.start(stage);
            }

        } catch (final Exception e) {
            e.printStackTrace();

        }
    }

    // Returns Ip address typed in by the user
    public String setIpAddress() {
        Main.logger.warn("IP" + ip.getText());
        return ip.getText();
    }

    // Returns port address typed in by the user
    public String setPortNumber() {
        Main.logger.warn("Port" + port.getText());
        return port.getText();
    }

    public IPAddress convertStringtoIP() throws AddressStringException, IncompatibleAddressException {

        return new IPAddressString(setIpAddress()).toAddress();
    }

}