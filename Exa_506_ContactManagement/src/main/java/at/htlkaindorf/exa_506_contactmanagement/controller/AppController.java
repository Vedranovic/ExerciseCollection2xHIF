package at.htlkaindorf.exa_506_contactmanagement.controller;

import at.htlkaindorf.exa_506_contactmanagement.pojos.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AppController {
    @FXML
    public ListView<Contact> lvContacts;
    @FXML
    public Button btSave;
    @FXML
    public Button btDelete;
    @FXML
    public RadioButton rbPrivate;
    @FXML
    public RadioButton rbBusiness;
    @FXML
    public TextField tfNumber;
    @FXML
    public TextField tfName;
    @FXML
    public MenuItem miPrivate;
    @FXML
    public MenuItem miBusiness;
    @FXML
    public MenuItem miAll;

    private String filter;
    private DataController dataController;
    private ObservableList<Contact> filteredContactList;
    private Alert errorAlert;

    public void initialize() {
        filter = "all";
        dataController = new DataController();
        filteredContactList = FXCollections.observableArrayList();
        errorAlert = new Alert(Alert.AlertType.ERROR);

        miAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDisplayAllContacts();
            }
        });
        miBusiness.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDisplayBusinessContacts();
            }
        });
        miPrivate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDisplayPrivateContacts();
            }
        });
        btSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onSaveContact(event);
            }
        });
        btDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDeleteContact(event);
            }
        });
    }

    private void onDisplayAllContacts() {

    }

    private void onDisplayBusinessContacts() {

    }

    private void onDisplayPrivateContacts() {

    }

    private void updateDisplayData() {

    }

    public void onSaveContact(ActionEvent event) {

    }

    public void onDeleteContact(ActionEvent event) {

    }
}