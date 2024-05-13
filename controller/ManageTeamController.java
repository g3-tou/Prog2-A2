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
import model.Player;
import model.Players;

//just needs the selected team.... not the whole team list?
public class ManageTeamController extends Controller<Team> {

    @FXML private Label teamName;
    @FXML private TextField teamNF;
    @FXML TableView<Player> playersTv;
    @FXML TableColumn<Player, String> nameClm;
    @FXML TableColumn<Player, Integer> numberClm;
    @FXML TableColumn<Player, Integer> ageClm;
    @FXML TableColumn<Player, Double> creditClm;
    @FXML Button updateButton;
    @FXML Button deleteButton;
    @FXML Button addButton;
    @FXML Button saveCloseButton;

    
    public Team getPlayer(){
        return model;
    }

    @FXML public void initialize(){
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numberClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerNoProperty().asObject());
        ageClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerAgeProperty().asObject());
        creditClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerCreditProperty().asObject());

        updateButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNull());
        addButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNotNull());

        playersTv.setItems(model.getCurrentPlayers());
    }
    @FXML public void update(ActionEvent event) throws IOException {
        Stage uStage = new Stage();
        uStage.setX(ViewLoader.X + 601);
        uStage.setY(ViewLoader.Y);

        uStage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getPlayer(), "/view/UpdatePlayerView.fxml", "Updating Player: " + model.getName(), uStage);
    }

    @FXML public void add(ActionEvent event) throws IOException {
        Stage aStage = new Stage();
        aStage.setX(ViewLoader.X + 601);
        aStage.setY(ViewLoader.Y);

        aStage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getPlayer(), "/view/AddPlayerView.fxml", "Adding New Player", aStage);
    }

}
