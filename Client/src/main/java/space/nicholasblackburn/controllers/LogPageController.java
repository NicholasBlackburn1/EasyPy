package space.nicholasblackburn.controllers;

import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import space.nicholasblackburn.Main;

public class LogPageController implements Initializable {

    @FXML // fx:id="logout"
    private JFXTextArea logout; // Value injected by FXMLLoader

    @FXML // fx:id="HighLighting"
    private JFXToggleButton HighLighting; // Value injected by FXMLLoader

    @FXML // fx:id="save"
    private JFXToggleButton save; // Value injected by FXMLLoader

    @FXML // fx:id="Clear"
    private JFXToggleButton Clear; // Value injected by FXMLLoader

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                displayLog();
            }
        });

    }

    private void displayLog() {

        PrintStream console = System.out;
        try {
            if (this.save.isSelected()) {

                logout.appendText(String.valueOf(console));

                Main.logger.warn("[Loging]" + "printing Console to Log window ");
            }

        } catch (final Exception e) {
            e.printStackTrace();

        }
    }

}
