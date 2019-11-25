package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {



        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane, 1080, 615);


        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 1080, 720);

        ControllerMain firstPaneController = firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);


        Controller secondPaneController = secondPageLoader.getController();
        secondPaneController.setFirstScene(firstScene);

        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        primaryStage.show();
        /*String a=new String("background.mp3");
        Media media = new Media(new File(a).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
