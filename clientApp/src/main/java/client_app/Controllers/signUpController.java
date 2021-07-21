package client_app.Controllers;

import client_app.Model.Account;
import client_app.Model.User;
import client_app.Service.httpClient;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class signUpController {

    @FXML
    private Button registBtnGoBack;

    @FXML
    private Button registBtnRegist;

    @FXML
    private Label registAnameLabel;

    @FXML
    private TextField AnameText;

    @FXML
    private Label passLabel;

    @FXML
    private TextField passText;

    @FXML
    private Label passConLabel;

    @FXML
    private TextField passConText;

    @FXML
    private Label uNameLabel;

    @FXML
    private TextField uNameText;

    @FXML
    void onButtonClicked(ActionEvent event) {

        if(event.getSource().equals(registBtnGoBack)){
            goBack(registBtnGoBack);
        } else if(event.getSource().equals(registBtnRegist)) {
            checkUserExistAndSave();
            goBack(registBtnRegist);
        }
    }

    private void goBack(Button button){
        Stage signStage = (Stage) button.getScene().getWindow();
        signStage.close();

        Stage loginStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/login_page.fxml"));

        try {
            loader.load();
            Parent parent = loader.getRoot();
            loginStage.setScene(new Scene(parent));
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkUserExistAndSave(){
        String Uname = uNameText.getCharacters().toString();
        String Aname = AnameText.getCharacters().toString();
        String pass = passText.getCharacters().toString();
        String passCon = passConText.getCharacters().toString();

        List<Account> AllAccounts = httpClient.INSTANCE.findAllAc();

        pass = pass.trim();
        passCon = passCon.trim();

        User user = checkUnameAndCreate(Uname);

        if(!pass.equals(passCon)) {
            showALert("Passwords does not match!", 2.5);
        } else if (!AllAccounts.isEmpty()) {
            for (int i = 0; i < AllAccounts.size(); i++) {
                if (AllAccounts.get(i).getUsername().equals(Aname)) {
                    showALert("Account with this " + Aname + " already exist!", 2.5);
                    return;
                }
            }



            Account account = new Account();
            account.setActive(true);
            account.setUsername(Aname);
            account.setPassword(pass);
            account.setUser(user);
            httpClient.INSTANCE.save(account);

        } else {

            Account account = new Account();
            account.setActive(true);
            account.setUsername(Aname);
            account.setPassword(pass);
            account.setUser(user);
            httpClient.INSTANCE.save(account);
        }
    }


    private User checkUnameAndCreate(String name){
        User dbUser = httpClient.INSTANCE.findByNameUs(name);

        if(dbUser == null){
            User user = new User();
            user.setName(name);
            httpClient.INSTANCE.save(user);
            user = httpClient.INSTANCE.findByNameUs(name);
            return user;
        }

        return dbUser;
    }

    private void showALert(String message, double time){
        Alert alert = new Alert(Alert.AlertType.ERROR,message);
        alert.show();
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> alert.close() );
        delay.play();
    }

    private void timer( Stage stage, double time){
        PauseTransition delay = new PauseTransition(Duration.seconds(time));
        delay.setOnFinished( event -> stage.show() );
        delay.play();
    }

}
