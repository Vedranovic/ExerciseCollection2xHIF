package at.htlkaindorf.exa_407_musicapp.controller;

import at.htlkaindorf.exa_407_musicapp.pojos.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AppController {
    @FXML
    private TextField tfShowTitle;
    @FXML
    private TextField tfShowInterprets;
    @FXML
    private TextField tfShowLength;
    @FXML
    private TextField tfShowReleaseDate;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfInterprets;
    @FXML
    private TextField tfLength;
    @FXML
    private DatePicker dpReleaseDate;

    private SongController songController;
    private int currentIndex;
    private Alert errorAlert;
    private Alert infoAlert;

    public void initialize() {
        songController = new SongController();
        currentIndex = 0;
        errorAlert = new Alert(Alert.AlertType.ERROR);
        infoAlert = new Alert(Alert.AlertType.INFORMATION);
    }

    private void showIndexData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        tfShowTitle.setText(songController.getSongs()[currentIndex].getTitle());
        tfShowInterprets.setText(songController.getSongs()[currentIndex].getInterpretStr());
        tfShowLength.setText(String.format(Locale.GERMAN, "%f", songController.getSongs()[currentIndex].getLength()));
        tfShowReleaseDate.setText(songController.getSongs()[currentIndex].getReleaseDate().format(formatter));
    }

    public void onLeft(ActionEvent actionEvent) {
        if (currentIndex > 0) {
            currentIndex--;
            showIndexData();
        }
    }

    public void onRight(ActionEvent actionEvent) {
        if (currentIndex < songController.getNumOfSongs() - 1) {
            currentIndex++;
            showIndexData();
        }
    }

    public void onClear(ActionEvent actionEvent) {
        tfTitle.setText("");
        tfInterprets.setText("");
        tfLength.setText("");
        dpReleaseDate.setValue(null);
    }

    public void onAdd(ActionEvent actionEvent) {
        String title = tfTitle.getText();
        String interprets = tfInterprets.getText();
        String length = tfLength.getText();
        LocalDate releaseDate = dpReleaseDate.getValue();

        length = length.replace(":", ".");

        if (title.isBlank() || length.isBlank() || releaseDate == null  ) {
            errorAlert.setContentText("Please fill title, length, and date!");
            errorAlert.showAndWait();
        } else {
            Song song = new Song(title, Float.parseFloat(length), releaseDate);

            try {
                if (!interprets.isBlank()) {
                    songController.addSong(song, interprets);
                } else {
                    songController.addSong(song);
                }

                showIndexData();
                infoAlert.setContentText("Song \"" + song.getTitle() + "\" was added!");
                infoAlert.showAndWait();
                onClear(actionEvent);
            } catch (Exception e) {
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }
}
