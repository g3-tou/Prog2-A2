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

public class TeamsRoundController extends Controller<Season> {
    @FXML private Label round;
    @FXML private ListView<Team> teamsLv;
    @FXML private Button activateButton;
    @FXML private Button arrangeButton;

    public Season getSeason(){
        return model;
    }

    @FXML public void initialize(){
        ObservableList<Team> teams = getSeason().getCurrentTeams();
        teamsLv.setItems(teams);
    }
}



