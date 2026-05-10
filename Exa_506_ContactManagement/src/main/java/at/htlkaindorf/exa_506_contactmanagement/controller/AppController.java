package at.htlkaindorf.exa_506_contactmanagement.controller;

import at.htlkaindorf.exa_506_contactmanagement.pojos.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

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
        lvContacts.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        miPrivate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filter = "private";
                updateDisplayData();
            }
        });
        miBusiness.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filter = "business";
                updateDisplayData();
            }
        });
        miAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filter = "all";
                updateDisplayData();
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
        filteredContactList.setAll(dataController.getContacts());
    }

    private void onDisplayBusinessContacts() {
        for (Contact contact : dataController.getContacts()) {
            if (!contact.isPrivate()) {
                filteredContactList.add(contact);
            }
        }
    }

    private void onDisplayPrivateContacts() {
        for (Contact contact : dataController.getContacts()) {
            if (contact.isPrivate()) {
                filteredContactList.add(contact);
            }
        }
    }

    private void updateDisplayData() {
        filteredContactList.clear();

        switch (filter) {
            case "all":
                onDisplayAllContacts();
                break;
            case "business":
                onDisplayBusinessContacts();
                break;
            case "private":
                onDisplayPrivateContacts();
                break;
        }

        FXCollections.sort(filteredContactList);
        lvContacts.setItems(filteredContactList);
    }

    public void onSaveContact(ActionEvent event) {
        if (tfNumber.getText().isEmpty() || tfNumber.getText().isEmpty() || !tfNumber.getText().contains("/")) {
            errorAlert.setContentText("Make sure to fill in all fields and that your number contains a /!");
            errorAlert.showAndWait();
        } else {
            try {
                dataController.addContact(new Contact(
                        tfName.getText(), tfNumber.getText(), rbPrivate.isSelected()
                ));
            } catch (NumberFormatException nfe) {
                errorAlert.setContentText("Please enter only valid inputs!");
                errorAlert.showAndWait();
            }
        }

        updateDisplayData();
    }

    public void onDeleteContact(ActionEvent event) {
        List<Contact> selectedItems = lvContacts.getSelectionModel().getSelectedItems();

        for (Contact contact : selectedItems) {
            dataController.deleteContact(contact);
        }
        updateDisplayData();
    }
}