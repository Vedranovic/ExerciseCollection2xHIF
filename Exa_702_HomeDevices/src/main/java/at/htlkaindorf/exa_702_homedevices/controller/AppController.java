package at.htlkaindorf.exa_702_homedevices.controller;

import at.htlkaindorf.exa_702_homedevices.pojos.Appliance;
import at.htlkaindorf.exa_702_homedevices.pojos.Washer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Optional;

public class AppController {
    @FXML
    private ListView lvData;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfEnergy;
    @FXML
    private TextField tfDrumSize;
    @FXML
    private Label lbDrumSize;
    @FXML
    private Button btLoadFile;
    @FXML
    private Button btOnOff;
    @FXML
    private Button btConnectDisconnect;
    @FXML
    private Button btSetBrightness;
    @FXML
    private Circle clActivated;
    @FXML
    private Circle clConnection;
    @FXML
    private Circle clBrightness;

    private DataController dataController;
    private Appliance selectedDevice;

    public void initialize() {
        dataController = new DataController();
        tfDrumSize.setVisible(false);
        lbDrumSize.setVisible(false);
        clActivated.setVisible(false);
        clConnection.setVisible(false);
        clBrightness.setVisible(false);
        btConnectDisconnect.setVisible(false);
        btSetBrightness.setVisible(false);

        btLoadFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                loadDevices(actionEvent);
            }
        });

        btOnOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onOnOff(actionEvent);
            }
        });

        btConnectDisconnect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onConnectDisconnect(actionEvent);
            }
        });

        btSetBrightness.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onSetBrightness(actionEvent);
            }
        });
    }

    public void loadDevices(ActionEvent actionEvent) {
        dataController.loadDevices();
        lvData.setItems(dataController.getDevices());
    }

    public void onDeviceSelected(MouseEvent mouseEvent) {
        setDataToGUI();
    }

    private void setDataToGUI() {
        selectedDevice = (Appliance) lvData.getSelectionModel().getSelectedItem();
        String selectedString = selectedDevice.toString();
        String [] parts = selectedString.split(" - ");
        String name = parts[0];
        String deviceName = parts[1];
        double kw = 0.0;

        if (name.equals("Washer")) {
            tfName.setText(deviceName);
            clActivated.setVisible(true);
            clConnection.setVisible(false);
            clBrightness.setVisible(false);
            tfEnergy.setText(kw + " kW");
            tfDrumSize.setVisible(true);
            lbDrumSize.setVisible(true);
            tfDrumSize.setText(String.valueOf(((Washer) selectedDevice).getDrumSize()));
        }
        if (name.equals("Fridge")) {
            tfName.setText(deviceName);
            clActivated.setVisible(true);
            clConnection.setVisible(false);
            clBrightness.setVisible(false);
            tfEnergy.setText(kw + " kW");
            lbDrumSize.setVisible(false);
            tfDrumSize.setVisible(false);
        }
        if (name.equals("Lamp")) {
            clActivated.setVisible(true);
            clConnection.setVisible(true);
            clBrightness.setVisible(true);
            tfName.setText(deviceName);
            tfEnergy.setText(kw + " kW");
            btConnectDisconnect.setVisible(true);
            btSetBrightness.setVisible(true);
            lbDrumSize.setVisible(false);
            tfDrumSize.setVisible(false);
        }
    }

    public void onOnOff(ActionEvent actionEvent) {
        if (selectedDevice != null) {
            if (selectedDevice.isOn()) {
                clActivated.setFill(Color.RED);
                selectedDevice.switchOff();
            } else {
                clActivated.setFill(Color.GREEN);
                selectedDevice.switchOn();
            }
        }
    }

    public void onConnectDisconnect(ActionEvent actionEvent) {
        if (selectedDevice != null) {
            if (selectedDevice.isOn()) {
                clConnection.setFill(Color.DARKRED);
                selectedDevice.switchOff();
            } else {
                clConnection.setFill(Color.LIGHTGREEN);
                selectedDevice.switchOn();
            }
        }
    }

    public void onSetBrightness(ActionEvent actionEvent) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setTitle("Bestätigung");
        inputDialog.setHeaderText("Bestätigung");
        inputDialog.setContentText("Please enter the brightness:");
        Optional<String> result = inputDialog.showAndWait();

        if (result.isPresent()) {

        }
    }
}