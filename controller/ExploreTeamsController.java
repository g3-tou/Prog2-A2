package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.Teams;



public class ExploreTeamsController extends Controller<Teams> {

    @FXML private Button seeTeams;
    @FXML private Button seePlayers;
    @FXML private Button closeButton;
    
    @FXML private void close(ActionEvent event) {
        stage.close();
    }

    public Teams getTeam(){
        return model;
    }

    @FXML private void viewAllTeams(ActionEvent event) throws IOException{
        Stage stage1 = new Stage();
        stage1.setX(ViewLoader.X + 601);
        stage1.setY(ViewLoader.Y);

        stage1.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getTeam(), "/view/TeamsTable.fxml", "Teams Menu", stage1);
    }

    @FXML private void viewAllPlayers(ActionEvent event) throws IOException{
        Stage stage2 = new Stage();
        stage2.setX(ViewLoader.X + 601);
        stage2.setY(ViewLoader.Y);

        stage2.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getTeam(), "/view/PlayersView.fxml", "Players", stage2);
    }
}

