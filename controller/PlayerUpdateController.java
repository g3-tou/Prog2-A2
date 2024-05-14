package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // added by system
import java.util.Observable; // added by system
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.Property;
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

public class PlayerUpdateController extends Controller<Player> {
   @FXML private Label details;
   @FXML private Label name;
   @FXML private Label credit;
   @FXML private Label age;
   @FXML private Label num;

   @FXML private TextField playerName;
   @FXML private TextField playerCredit;
   @FXML private TextField playerAge;
   @FXML private TextField playerNum;
   
   @FXML private Button updateButton;
   @FXML private Button addButton;
   @FXML private Button closeButton;

   public Player getPlayer(){
        return model;
   }

   @FXML private void initialize() {
       //name.textProperty().bindBidirectional(model.getName());
       name.textProperty().bind(model.nameProperty());
       //name.setText(model.nameProperty().get());
       /*credit.textProperty().bind(model.getPlayerCreditProperty().asString());
       age.textProperty().bind(model.getPlayerAgeProperty().asString());
       num.textProperty().bind(model.getPlayerNoProperty().asString());*/
   }

   public Validator validator = new Validator();
   private String setErrorMessage(){
        validator.clear();
        ArrayList<String> errorsList;
        errorsList = new ArrayList<>();
        validator.generateErrors(model.getName().toString(),model.getCredit().toString(),model.getAge().toString(),model.getNo().toString());
        for (String e : validator.errors()){
            errorsList.add(e);
        }
        String result = errorsList.toString();
        return result;
   }

   @FXML private void close(ActionEvent event) throws IOException {
       stage.close();
   }

   @FXML private void update(ActionEvent event) throws IOException {
       if (validator.isValid(model.getName().toString(),model.getCredit().toString(),model.getAge().toString(),model.getNo().toString())){
           model.setName(playerName.getText());
           model.setCredit(Double.parseDouble(playerCredit.getText()));
           model.setAge(Integer.parseInt(playerAge.getText()));
           model.setNo(Integer.parseInt(playerNum.getText()));
           stage.close();
       }
       else{
           Stage errorStage = new Stage();
           errorStage.getIcons().add(new Image("/view/error.png"));
           ViewLoader.showStage(new InputException(setErrorMessage()), "/view/error.fxml", "Input Error", errorStage);
       }
   }

   @FXML private void add(ActionEvent event) throws IOException {

   }
}
