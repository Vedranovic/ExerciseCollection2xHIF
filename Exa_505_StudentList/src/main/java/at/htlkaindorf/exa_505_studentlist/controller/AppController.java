package at.htlkaindorf.exa_505_studentlist.controller;

import at.htlkaindorf.exa_505_studentlist.exception.DuplicateStudentException;
import at.htlkaindorf.exa_505_studentlist.pojos.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AppController {
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfDateOfBirth;
    @FXML
    private Button btInsert;
    @FXML
    private Button btDelete;
    @FXML
    private ListView<Student> lvStudents;

    private DataController dataController;
    private Alert errorAlert;

    public void initialize() {
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);
        lvStudents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        btInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onInsert(actionEvent);
            }
        });
        btDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onDelete(actionEvent);
            }
        });

        lvStudents.setItems(dataController.getStudents());
    }

    public void onInsert(ActionEvent actionEvent) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String dateOfBirth = tfDateOfBirth.getText();

        if (firstName.isEmpty() || lastName.isEmpty() || dateOfBirth.isEmpty()) {
            errorAlert.setContentText("Please fill in all fields");
            errorAlert.showAndWait();
        } else {
            try {
                LocalDate birthDate = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                Student student = new Student(firstName, lastName, birthDate);
                dataController.addStudent(student);
            } catch (DateTimeParseException dtpe) {
                errorAlert.setContentText("Please enter only valid inputs!");
                errorAlert.showAndWait();
            } catch (DuplicateStudentException dse) {
                errorAlert.setContentText(dse.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    public void onDelete(ActionEvent actionEvent) {
        if (lvStudents.getSelectionModel().getSelectedIndex() >= 0) {
            dataController.deleteStudent(lvStudents.getSelectionModel().getSelectedIndex());
        } else {
            errorAlert.setContentText("Nothing was selected!");
            errorAlert.showAndWait();
        }
    }
}