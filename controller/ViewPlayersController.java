package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Player;
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

    public Teams getPlayers(){
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

       //byName.textProperty().addListener(Event -> getPlayers().filterList(getName(),"0",0,0));
        byLevel.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        byName.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        fromAge.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
        toAge.textProperty().addListener((observable, oldValue, newValue) -> filterPlayers());
    
    }

    /*I couldn't access the filter list in the players class as it kept returning 
    model.Teams cannot be cast to model.Players when I was using the Players model
    so I had to do the filtering myself.*/
    private void filterPlayers(){
    String nameFilter = byName.getText().toLowerCase(); 
    String levelFilter = byLevel.getText().toLowerCase(); 
    int minAge = fromAge.getText().isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(fromAge.getText()); 
    int maxAge = toAge.getText().isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(toAge.getText()); 

    ObservableList<Player> filteredPlayers = FXCollections.observableArrayList();

    for (Player player : getPlayers().allPlayersList()) {
        boolean nameMatch = player.getName().toLowerCase().contains(nameFilter);
        boolean levelMatch = player.getLevel().toLowerCase().contains(levelFilter);
        boolean ageMatch = player.getAge() >= minAge && player.getAge() <= maxAge;

        if (nameMatch && levelMatch && ageMatch) {
            filteredPlayers.add(player);
        }
    }
    playersTv.setItems(filteredPlayers);
    }

    @FXML public void close(ActionEvent event){
        stage.close();
    }

}

