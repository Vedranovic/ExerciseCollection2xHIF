package at.htlkaindorf.exa_705_dndgame.controller;

import at.htlkaindorf.exa_705_dndgame.pojos.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class AppController {
    @FXML
    public ListView<Character> lvPlayer1;
    @FXML
    public ListView<Character> lvPlayer2;
    @FXML
    public ProgressBar pbPlayer1;
    @FXML
    public ProgressBar pbPlayer2;
    @FXML
    public TextField tfStrength1;
    @FXML
    public TextField tfStrength2;
    @FXML
    public TextField tfMagic1;
    @FXML
    public TextField tfMagic2;
    @FXML
    public TextField tfSpeed1;
    @FXML
    public TextField tfSpeed2;
    @FXML
    public Button btFight;
    @FXML
    public Button btClear;
    @FXML
    public TextArea taFights;

    private DataController dataController;

    public void initialize() {
        dataController = new DataController();
        dataController.reSortLists();
        lvPlayer1.setItems(dataController.getListPLayer1());
        lvPlayer2.setItems(dataController.getListPlayer2());

        lvPlayer1.setOnMouseClicked(this::onItemSelected);
        lvPlayer2.setOnMouseClicked(this::onItemSelected);
        btFight.setOnAction(this::onFight);
        btClear.setOnAction(this::onClear);
    }

    private void setStatusData() {
        int players1Index = lvPlayer1.getSelectionModel().getSelectedIndex();
        int players2Index = lvPlayer2.getSelectionModel().getSelectedIndex();

        if (players1Index >= 0) {
            tfStrength1.setText(String.valueOf(dataController
                    .getPlayer1Characters()
                    .get(players1Index)
                    .getStrength()));
            tfMagic1.setText(String.valueOf(dataController
                    .getPlayer1Characters()
                    .get(players1Index)
                    .getMagic()));
            tfSpeed1.setText(String.valueOf(dataController
                    .getPlayer1Characters()
                    .get(players1Index)
                    .getSpeed()));
            pbPlayer1.setProgress(dataController
                    .getPlayer1Characters()
                    .get(players1Index)
                    .getHealthStatus());
        }

        if (players2Index >= 0) {
            tfStrength2.setText(String.valueOf(dataController
                    .getPlayer2Characters()
                    .get(players2Index)
                    .getStrength()));
            tfMagic2.setText(String.valueOf(dataController
                    .getPlayer2Characters()
                    .get(players2Index)
                    .getMagic()));
            tfSpeed2.setText(String.valueOf(dataController
                    .getPlayer2Characters()
                    .get(players2Index)
                    .getSpeed()));
            pbPlayer2.setProgress(dataController
                    .getPlayer2Characters()
                    .get(players2Index)
                    .getHealthStatus());
        }
    }

    public void onItemSelected(MouseEvent mouseEvent) {
        setStatusData();
    }

    public void onFight(ActionEvent actionEvent) {
        int players1Index = lvPlayer1.getSelectionModel().getSelectedIndex();
        int players2Index = lvPlayer2.getSelectionModel().getSelectedIndex();

        if (players1Index >= 0 && players2Index >= 0) {
            Character player1 = dataController.getPlayer1Characters().get(players1Index);
            Character player2 = dataController.getPlayer2Characters().get(players2Index);
            String player1Name = dataController.getPlayer1Characters().get(players1Index).getName();
            String player2Name = dataController.getPlayer2Characters().get(players2Index).getName();
            boolean turn = player1.getSpeed() >= player2.getSpeed();

            if (player1.isAlive() && player2.isAlive()) {
                taFights.appendText("Fight between " + player1Name + " and " + player2Name + " started!\n\n");

                if (turn) {
                    taFights.appendText(player1.attack(player2));
                    taFights.appendText(player2.attack(player1));
                } else {
                    taFights.appendText(player2.attack(player1));
                    taFights.appendText(player1.attack(player2));
                }

                taFights.appendText("\nFight ended!\n");
            }
        }

        dataController.reSortLists();
        lvPlayer1.setItems(dataController.getPlayer1Characters());
        lvPlayer2.setItems(dataController.getPlayer2Characters());
        setStatusData();
    }

    public void onClear(ActionEvent actionEvent) {
        tfStrength1.clear();
        tfMagic1.clear();
        tfSpeed1.clear();
        tfStrength2.clear();
        tfMagic2.clear();
        tfSpeed2.clear();
        pbPlayer1.setProgress(0);
        pbPlayer2.setProgress(0);
        taFights.clear();
    }
}