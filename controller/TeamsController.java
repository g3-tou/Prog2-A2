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
import javafx.collections.ObservableList; // added by system
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
//import javafx.scene.control.Label.*;
import javafx.scene.layout.GridPane;
import model.Player;
import model.Players;
import model.Team;
import model.Teams;

public class TeamsController extends Controller<Teams> {

    @FXML private Label teamsField;
    @FXML private Button addButton;
    @FXML private Button manageButton;
    @FXML private Button deleteButton;
    @FXML private Button closeButton;
    @FXML private ListView<Team> teamsLv;
    @FXML private TableView<Teams> teamsTable;

    @FXML private void close(ActionEvent event) {
        stage.close();
    }

    public final Teams getTeams(){
        return model;
    }

    
    @FXML public void initialize(){
        teamsLv.setItems(model.currentTeams());
    }


    @FXML private void handleAdd(ActionEvent event) throws IOException {
        Stage stage7 = new Stage();
        stage7.setX(ViewLoader.X + 601);
        stage7.setY(ViewLoader.Y);

        stage7.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getTeams(), "/view/AddTeam.fxml", "Adding New Team", stage7);
    }

    @FXML private void handleManage(ActionEvent event) throws IOException {
        Stage stage8 = new Stage();
        stage8.setX(ViewLoader.X + 601);
        stage8.setY(ViewLoader.Y);

        stage8.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getTeams(), "/view/ManageTeamView.fxml", "Managing Team: ", stage8);
    }

    @FXML private void handleDelete(ActionEvent event) throws IOException {
        
    }
}

