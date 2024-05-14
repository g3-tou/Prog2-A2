package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import model.Season;
import model.Game;


//shows the current teams in the round (the schedule)
public class CurrentRoundTeamsController extends Controller<Season> {
    @FXML private Label round;
    @FXML private TableView<Game> currentRounds;
    @FXML private TableColumn<Game, String> column1;
    @FXML private TableColumn<Game, String> column2;
    @FXML private TableColumn<Game, String> column3;
    @FXML private Button closeButton;

    public Season getSeason(){
        return model;
    }

    @FXML public void initialize() {
        currentRounds.setPlaceholder(new Label("No teams to show."));
        column1.setCellValueFactory(cellData -> cellData.getValue().team1());
        column2.setCellValueFactory(cellData -> new SimpleStringProperty("VS"));
        column3.setCellValueFactory(cellData -> cellData.getValue().team2());

        ObservableList<Game> teams = getSeason().getCurrentSchedule();
        currentRounds.setItems(teams);
    }
    
    @FXML private void close(ActionEvent event){
        stage.close();
    }
}







