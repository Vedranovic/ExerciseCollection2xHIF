package at.htlkaindorf.exa_702_homedevices.controller;

import at.htlkaindorf.exa_702_homedevices.pojos.Appliance;
import at.htlkaindorf.exa_702_homedevices.pojos.IO_Access;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class DataController {
    private ObservableList<Appliance> devices;

    public void loadDevices() {
        IO_Access io = new IO_Access();

        devices = FXCollections.observableList(io.readAllDevices());
        Collections.sort(devices);
    }

    public ObservableList<Appliance> getDevices() {
        return devices;
    }
}
