package client_app.Controllers;

import client_app.Main;
import client_app.Model.Account;
import client_app.Service.AccountService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.List;

public class loginController {



    @FXML
    private Label usernameLable;

    @FXML
    private Label passwordLable;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;


    @FXML
    private Button btnNewUser;

    @FXML
    private Button btnSign;

    @FXML
    private Button btnLogin;

    @FXML
    void onButtonClicked(ActionEvent event) {

        if (event.getSource().equals(btnLogin)) {

            String uname = usernameText.getCharacters().toString();
            String pass = passwordText.getCharacters().toString();

            List<Account> AllAccounts = AccountService.INSTANCE.findAll();

            if (!AllAccounts.isEmpty()) {
                for (int i = 0; i < AllAccounts.size(); i++) {
                    if (AllAccounts.get(i).getUsername().equals(uname) && AllAccounts.get(i).getPassword().equals(pass)) {
                        System.out.println("loop");
                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        stage.close();

                        Stage mainStage = new Stage();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/main.fxml"));

                        try {
                            loader.load();
                            Parent parent = loader.getRoot();
                            mainStage.setScene(new Scene(parent));
                            mainStage.show();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }


            }


        } else if (event.getSource().equals(btnSign)) {
            Stage loginStage = (Stage) btnSign.getScene().getWindow();
            loginStage.close();

            Stage signStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/sign_up.fxml"));

            try {
                loader.load();
                Parent parent = loader.getRoot();
                signStage.setScene(new Scene(parent));
                signStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if(event.getSource().equals(btnNewUser)){



        }else {
            Stage stage = (Stage)((Node)((EventObject) event).getSource()).getScene().getWindow();
            stage.close();

//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/sign_up.fxml"));
//            signUpController signUpController = loader.getController();
//            signUpController.onButtonClicked(event);

            if(Main.getPrimaryStage() != null){
                Main.getPrimaryStage().show();
            }
        }

    }

}
