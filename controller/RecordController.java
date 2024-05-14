package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.List; // added by system
import java.util.Observable; // added by system
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.InputException;
import model.Team;
import model.Teams;
import model.Season;
import model.Record;
import model.Game;

//shows the result for the games 
public class RecordController extends Controller<Season> {
    @FXML private Label result;
    @FXML private TableView<Game> results;
    @FXML private TableColumn<Record, Integer> round;
    @FXML private TableColumn<Record, Integer> game;
    @FXML private TableColumn<Record, String> winTeam;
    @FXML private TableColumn<Record, String> loseTeam;
    @FXML private Button closeButton;

    public Season getRecord(){
        return model;
    }

    @FXML public void initialize(){

        round.setCellValueFactory(cellData -> cellData.getValue().roundProperty().asObject());
        game.setCellValueFactory(cellData -> cellData.getValue().gameNumberProperty().asObject());
        winTeam.setCellValueFactory(cellData -> cellData.getValue().winTeamProperty());
        loseTeam.setCellValueFactory(cellData -> cellData.getValue().loseTeamProperty());

        ObservableList<Game> teams = getRecord().getCurrentSchedule();
        results.setItems(teams); 
    }

    @FXML private void close(ActionEvent event){
        stage.close();
    }

    
}







