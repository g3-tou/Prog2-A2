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
import model.Player;


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

    
    public Team getTeam(){
        return model;
    }

    @FXML public void initialize(){
        nameClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        numberClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerNoProperty().asObject());
        ageClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerAgeProperty().asObject());
        creditClm.setCellValueFactory(cellData -> cellData.getValue().getPlayerCreditProperty().asObject());

        teamNF.setText(getTeam().getName());

        updateButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNull());
        deleteButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNull());
        addButton.disableProperty().bind(playersTv.getSelectionModel().selectedItemProperty().isNotNull());

        playersTv.setItems(getTeam().getCurrentPlayers());
        playersTv.getSelectionModel().getSelectedItem();
    }
    @FXML public void update(ActionEvent event) throws IOException {
        Stage uStage = new Stage();
        uStage.setX(ViewLoader.X + 601);
        uStage.setY(ViewLoader.Y);

        uStage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getTeam(), "/view/PlayerUpdateView.fxml", "Updating Player: " + playersTv.getSelectionModel().getSelectedItem().getName(), uStage);
    }

    @FXML public void add(ActionEvent event) throws IOException {
        Stage aStage = new Stage();
        aStage.setX(ViewLoader.X + 601);
        aStage.setY(ViewLoader.Y);

        aStage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(getTeam(), "/view/PlayerUpdateView.fxml", "Adding New Player", aStage);
    }

    @FXML public void delete(ActionEvent event) {
        getTeam().getPlayers().removePlayer(playersTv.getSelectionModel().getSelectedItem()); 
    }

    @FXML public void saveClose(ActionEvent event){
        String newName = teamNF.getText();
        getTeam().setName(newName);
        stage.close();
    }

}
