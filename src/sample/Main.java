package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Raiden");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();

        primaryStage.setTitle("雷電");

        // Load the FXML data into loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));

        // Create a new scene from that FXML data
        Scene root = new Scene(loader.load());
        root.getRoot().requestFocus();//很重要!!!沒有這個鍵盤事件會沒反應

        // Set the scene and display the stage
        primaryStage.setScene(root);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
