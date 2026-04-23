package at.htlkaindorf.exa_705_dndgame.controller;

import at.htlkaindorf.exa_705_dndgame.pojos.Character;
import at.htlkaindorf.exa_705_dndgame.pojos.IOAccess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.List;

public class DataController {
    private List<Character> characters;
    private ObservableList<Character> listPLayer1;
    private ObservableList<Character> listPlayer2;

    public DataController() {
        characters = IOAccess.loadCharacters();
        listPLayer1 = FXCollections.observableArrayList();
        listPlayer2 = FXCollections.observableArrayList();
    }

    public void loadCharacters() {
        listPLayer1 = getPlayer1Characters();
        listPlayer2 = getPlayer2Characters();
    }

    public void reSortLists() {
        Collections.sort(characters);
        loadCharacters();
    }

    public ObservableList<Character> getPlayer1Characters() {
        ObservableList<Character> player1List = FXCollections.observableArrayList();

        for (Character character : characters) {
            if (character.getPlayer().equals("Player1")) {
                player1List.add(character);
            }
        }

        return player1List;
    }

    public ObservableList<Character> getPlayer2Characters() {
        ObservableList<Character> player2List = FXCollections.observableArrayList();

        for (Character character : characters) {
            if (character.getPlayer().equals("Player2")) {
                player2List.add(character);
            }
        }

        return player2List;
    }

    public ObservableList<Character> getListPLayer1() {
        return listPLayer1;
    }

    public ObservableList<Character> getListPlayer2() {
        return listPlayer2;
    }
}
