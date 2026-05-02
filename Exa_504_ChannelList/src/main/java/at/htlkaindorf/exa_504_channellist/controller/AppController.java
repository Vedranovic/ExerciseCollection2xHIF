package at.htlkaindorf.exa_504_channellist.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AppController {
    @FXML
    private ListView<String> lvChannels;
    @FXML
    private TextField tfInsertChannel;
    @FXML
    private Button btInit;
    @FXML
    public Button btInsert;
    @FXML
    public Button btRemove;
    @FXML
    public Button btClear;
    @FXML
    public Button btShuffle;

    private DataController dataController;
    private Alert errorAlert;

    public void initialize() {
        dataController = new DataController();
        errorAlert = new Alert(Alert.AlertType.ERROR);

        btInit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onInit();
            }
        });
        btInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onInsert();
            }
        });
        btRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onRemove();
            }
        });
        btClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onClear();
            }
        });
        btShuffle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                onShuffle();
            }
        });
    }

    private void updateData() {
        lvChannels.setItems(FXCollections.observableList(dataController.getChannels()));
    }

    public void onInit() {
        try {
            if (dataController.addChannel("ORF 1")
                    && dataController.addChannel("ORF 2")
                    && dataController.addChannel("ORF 3")
                    && dataController.addChannel("Super RTL")) {
                updateData();
            }
        } catch (Exception e) {
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    public void onClear() {
        tfInsertChannel.setText("");
        lvChannels.getItems().clear();
    }

    public void onShuffle() {
        dataController.shuffleList();
        updateData();
    }

    public void onRemove() {
        List<String> selectedValues = lvChannels.getSelectionModel().getSelectedItems();

        for (String selectedValue : selectedValues) {
            dataController.removeChannel(selectedValue);
        }
        updateData();
    }

    public void onInsert() {
        String input = tfInsertChannel.getText();
        int index = lvChannels.getSelectionModel().getSelectedIndex();

        try {
            if (index >= 0) {
                if (dataController.addChannel(input, index)) {
                    updateData();
                }
            } else {
                if (dataController.addChannel(input)) {
                    updateData();
                }
            }
        } catch (Exception e) {
            errorAlert.setContentText(e.getMessage());
            errorAlert.showAndWait();
        }
    }
}