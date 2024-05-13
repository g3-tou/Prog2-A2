package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.List; // added by system
import java.util.Observable; // added by system
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.InputException;
import model.Team;
import model.Teams;
import model.Season;
import model.Record;
import model.Game;

public class TeamsRoundController extends Controller<Season> {
    @FXML private Label round;
    @FXML private ListView<Team> teamsLv;
    @FXML private TableView<Team> teamsAddedTv; //teams need to be added into the schedule/game
    @FXML private TableColumn<Game, Integer> rounds;
    @FXML private TableColumn<Game, String> team1;
    @FXML private TableColumn<Game, String> team2;
    @FXML private Button activateButton;
    @FXML private Button arrangeButton;

    public Season getSeason(){
        return model;
    }
    //private SimpleBooleanProperty twoTeamsSelected = new SimpleBooleanProperty(false);

    @FXML public void initialize(){
        teamsAddedTv.setPlaceholder(new Label("No teams added to round."));
        teamsLv.setPlaceholder(new Label("All teams added to round."));
        
        rounds.setCellValueFactory(new PropertyValueFactory<>("round"));
        team1.setCellValueFactory(new PropertyValueFactory<>("team1"));
        team2.setCellValueFactory(new PropertyValueFactory<>("team2"));
       
        ObservableList<Team> teams = getSeason().getCurrentTeams();
        teamsLv.setItems(teams);

        teamsLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    @FXML public void activate(ActionEvent event){

        if(teamsLv.getSelectionModel().getSelectedItems().size() == 2){
            getSeason().addTeams(teamsAddedTv.getSelectionModel().getSelectedItems());
        }
    }

    @FXML public void arrangeSeason(ActionEvent event){
        stage.close();
    }
}



