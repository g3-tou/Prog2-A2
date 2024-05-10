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
//import model.InputException;


public class AddTeamController extends Controller<Teams>{
    
    @FXML private Label teamDeats;
    @FXML private TextField teamName;
    @FXML private Label enterName;
    @FXML private Button addTeam;
    @FXML private Label errorMessage;
    
    public Teams getTeams(){
        return model;
    }
    
    private String getType(){
        return teamName.getText();
    }
    private void setType(String type){
        teamName.setText(type);
    }
    @FXML private void handleAddTeam(ActionEvent event) {
        getTeams().getTeam(getType());
        stage.close();
    }

    /*
    private void setErrorMessage(){
        errorMessage.setText(name + " already exists");
    }
    */

    /*
    String name = teamName.getText().trim();
    if (!name.isEmpty() && !getTeams().hasTeam(name)){
        Team newTeam = new Team(name);
        newTeam.setName(name);
        getTeams().addTeam(newTeam);
        stage.close();
        
        Stage errorStage = new Stage();
            errorStage.getIcons().add(new Image("/view/error.png"));
            ViewLoader.showStage( "/view/error.fxml", "Error", errorStage); 
    */
}
