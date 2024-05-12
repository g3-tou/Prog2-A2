package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List; // added by system
import java.util.Observable; // added by system
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Player;
import model.Players;
import model.Team;
import model.Teams;

public class ViewPlayersController extends Controller<Teams> {

    @FXML private TableView<Player> playersTv;
    @FXML private TableColumn<Player, String> teamsClm;
    @FXML private TableColumn<Player, String> nameClm;
    @FXML private TableColumn<Player, Double> creditClm;
    @FXML private TableColumn<Player, Integer> ageClm;
    @FXML private TableColumn<Player, Integer> numberClm;
    @FXML private TableColumn<Player, String> levelClm;

    @FXML private Label byL;
    @FXML private Label byN;
    @FXML private Label byA;
    @FXML private Label fA;
    @FXML private Label tA;
    @FXML private Label playersField;
    @FXML private Label f;

    @FXML private TextField byLevel;
    @FXML private TextField byName;
    @FXML private TextField fromAge;
    @FXML private TextField toAge;
    @FXML private Button close;

    @FXML public Teams getPlayers(){
        return model;
    }

    @FXML public void initialize(){
        
        teamsClm.setCellValueFactory(cellData -> cellData.getValue().getTeamNameProperty());
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        creditClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerCreditProperty().asObject());
        ageClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerAgeProperty().asObject());
        numberClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerNoProperty().asObject());
        levelClm.setCellValueFactory(cellData -> cellData.getValue().levelProperty());

        playersTv.setItems(getPlayers().allPlayersList());
        playersTv.setPlaceholder(new Label("Players list is not loaded."));

        byLevel.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        byName.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        fromAge.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        toAge.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
    }

    private void filterPlayers(){
    String nameFilter = byName.getText().toLowerCase(); // Get name filter text
    String levelFilter = byLevel.getText().toLowerCase(); // Get level filter text
    int minAge = fromAge.getText().isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(fromAge.getText()); // Get min age filter
    int maxAge = toAge.getText().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(toAge.getText()); // Get max age filter

    ObservableList<Player> filteredPlayers = FXCollections.observableArrayList();

    for (Player player : getPlayers().allPlayersList()) {
        // Check if the player's name contains the name filter text (case-insensitive)
        boolean nameMatch = player.getName().toLowerCase().contains(nameFilter);
        // Check if the player's level contains the level filter text (case-insensitive)
        boolean levelMatch = player.getLevel().toLowerCase().contains(levelFilter);
        // Check if the player's age is within the specified range
        boolean ageMatch = player.getAge() >= minAge && player.getAge() <= maxAge;

        // If all conditions are met, add the player to the filtered list
        if (nameMatch && levelMatch && ageMatch) {
            filteredPlayers.add(player);
        }
    }

    // Update the table view with the filtered list of players
    playersTv.setItems(filteredPlayers);
    }

    @FXML public void close(ActionEvent event){
        stage.close();
    }

}

