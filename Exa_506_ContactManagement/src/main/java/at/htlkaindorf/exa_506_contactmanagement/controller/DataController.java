package at.htlkaindorf.exa_506_contactmanagement.controller;

import at.htlkaindorf.exa_506_contactmanagement.pojos.Contact;
import javafx.collections.FXCollections;

import java.util.List;

public class DataController {
    private List<Contact> contacts;

    public DataController() {
        contacts = FXCollections.observableArrayList();
    }

    public void addContact(Contact contact) {

    }

    public void deleteContact(Contact contact) {

    }
}
