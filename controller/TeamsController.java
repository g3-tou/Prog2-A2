package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.Team;
import model.Teams;

public class TeamsController extends Controller<Teams> {

    @FXML private Label teamsField;
    @FXML private Button addButton;
    @FXML private Button manageButton;
    @FXML private Button deleteButton;
    @FXML private Button closeButton;
    @FXML private TableView<Team> teamsTv;
    @FXML private TableColumn<Team, String> teamName;
    @FXML private TableColumn<Team, Integer> numPlayers;
    @FXML private TableColumn<Team, Double> avgPCredit;
    @FXML private TableColumn<Team, Double> avgAge;

    @FXML private void close(ActionEvent event) {
        stage.close();
    }

    public final Teams getTeams(){
        return model;
    }

    
    @FXML public void initialize(){
        teamName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numPlayers.setCellValueFactory(cellData -> cellData.getValue().countPlayerProperty().asObject());
        avgPCredit.setCellValueFactory(cellData -> cellData.getValue().countAvgCreditProperty().asObject());
        avgAge.setCellValueFactory(cellData -> cellData.getValue().countAvgAgeProperty().asObject());

        teamsTv.setItems(getTeams().currentTeams());
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

