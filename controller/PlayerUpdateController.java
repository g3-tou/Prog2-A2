package controller;

import au.edu.uts.ap.javafx.ViewLoader;
import au.edu.uts.ap.javafx.Controller;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import model.InputException;
import model.Player;

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
       name.textProperty().bind(model.nameProperty()); /*keep getting the error model.Team cannot 
       be cast to model.Player and idk how to fix that as i am sure i am referencing the right thing*/
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
