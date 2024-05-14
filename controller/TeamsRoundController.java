package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Team;
import model.Season;
import model.Game;

public class TeamsRoundController extends Controller<Season> {
    @FXML private Label round;
    @FXML private ListView<Team> teamsLv;
    @FXML private TableView<Game> teamsAddedTv; //teams need to be added into the schedule/game
    @FXML private TableColumn<Game, Integer> rounds;
    @FXML private TableColumn<Game, String> team1;
    @FXML private TableColumn<Game, String> team2;
    @FXML private Button activateButton;
    @FXML private Button arrangeButton;

    public Season getSeason(){
        return model;
    }

    @FXML public void initialize(){
        round.setText("Round: " + (getSeason().round()+1));
        teamsAddedTv.setPlaceholder(new Label("No teams added to round."));
        teamsLv.setPlaceholder(new Label("All teams added to round."));
        
        teamsAddedTv.setItems(getSeason().getCurrentSchedule());
       
        ObservableList<Team> teams = getSeason().getCurrentTeams();
        teamsLv.setItems(teams);

        teamsLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        rounds.setCellValueFactory(cellData -> cellData.getValue().termProperty().asObject());
        team1.setCellValueFactory(cellData -> cellData.getValue().team1());
        team2.setCellValueFactory(cellData -> cellData.getValue().team2());

        BooleanBinding noTeamsSelected = Bindings.size(teamsLv.getSelectionModel().getSelectedItems()).isNotEqualTo(2);
        activateButton.disableProperty().bind(noTeamsSelected);

        BooleanBinding teamsRemaining = Bindings.isNotEmpty(teamsLv.getItems());
        arrangeButton.disableProperty().bind(teamsRemaining);
    }

    @FXML public void activate(ActionEvent event){
        ObservableList<Team> teams = teamsLv.getSelectionModel().getSelectedItems();
        getSeason().addTeams(teams);
    }

    @FXML public void arrangeSeason(ActionEvent event){
        stage.close();
    }
}