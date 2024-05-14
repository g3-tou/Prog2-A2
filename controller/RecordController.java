package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Season;
import model.Record;

//shows the result for the games 
public class RecordController extends Controller<Season> {
    @FXML private Label result;
    @FXML private TableView<Record> results;
    @FXML private TableColumn<Record, Integer> round;
    @FXML private TableColumn<Record, Integer> game;
    @FXML private TableColumn<Record, String> winTeam;
    @FXML private TableColumn<Record, String> loseTeam;
    @FXML private Button closeButton;

    public Season getRecord(){
        return model;
    }

    @FXML public void initialize(){
        //round.setText("Round: " + (getRecord().round()+1));
        round.setCellValueFactory(cellData -> cellData.getValue().roundProperty().asObject());
        game.setCellValueFactory(cellData -> cellData.getValue().gameNumberProperty().asObject());
        winTeam.setCellValueFactory(cellData -> cellData.getValue().winTeamProperty());
        loseTeam.setCellValueFactory(cellData -> cellData.getValue().loseTeamProperty());

        results.setItems(getRecord().record());
    }

    @FXML private void close(ActionEvent event){
        stage.close();
    }

    
}







