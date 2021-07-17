package client_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);

        Parent parent = FXMLLoader.load(getClass().getResource("/layouts/login_page.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }

    private void setPrimaryStage(Stage pStage) {
        Main.pStage = pStage;
    }

}
