package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.Season;

public class SeasonController extends Controller<Season> {
    @FXML private Button roundButton;
    @FXML private Button currentButton;
    @FXML private Button gameButton;
    @FXML private Button resultButton;
    @FXML private Button closeButton;

    @FXML private void close(ActionEvent event) {
        stage.close();
    }
    public Season getSeason(){
        return model;
    }

    @FXML private void viewRounds(ActionEvent event) throws IOException {
        Stage stage3 = new Stage();
        stage3.setX(ViewLoader.X + 601);
        stage3.setY(ViewLoader.Y);

        stage3.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getSeason(), "/view/SeasonRoundView.fxml", "Season Rounds", stage3);
    }

    @FXML private void viewCurrentRound(ActionEvent event) throws IOException {
        Stage stage4 = new Stage();
        stage4.setX(ViewLoader.X + 601);
        stage4.setY(ViewLoader.Y);

        stage4.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getSeason(), "/view/CurrentRoundTeams.fxml", "Tournament", stage4);
    }

    /*@FXML private void viewGames(ActionEvent event) throws IOException {
        Stage stage5 = new Stage();
        stage5.setX(ViewLoader.X + 601);
        stage5.setY(ViewLoader.Y);

        stage5.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getSeason(), "/view/SeasonGamesView.fxml", "All Games Played!", stage5);
    }*/

    @FXML private void viewResults(ActionEvent event) throws IOException {
        Stage stage6 = new Stage();
        stage6.setX(ViewLoader.X + 601);
        stage6.setY(ViewLoader.Y);

        stage6.getIcons().add(new Image("/view/nba.png"));
        ViewLoader.showStage(getSeason(), "/view/RecordView.fxml", "Season Record", stage6);
    }
} 

