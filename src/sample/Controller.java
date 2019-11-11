package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {
    final double[] sceneXY = new double[2];
    final int cost_luffy = 5;
    final int cost_dragon = 8;
    final int cost_garp = 10;
    int cash = 15;

    @FXML
    Canvas canvas;

    private Scene firstScene;

    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }

    public void mainMenu(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
    }

    @FXML
    public void luffy(MouseEvent mouseEvent) {
        canvas.setOnMouseClicked(e -> {
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if(sceneXY[0] != 0 && sceneXY[1] != 0 && cash >= cost_luffy){
                gc.drawImage(new Image("sample/image/tru_1.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_luffy;
            }
            canvas.setOnMouseClicked(null);
        });
    }

    public void dragon() {
        canvas.setOnMouseClicked(e -> {
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if(sceneXY[0] != 0 && sceneXY[1] != 0 && cash >= cost_dragon){
                gc.drawImage(new Image("sample/image/tru_2.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_dragon;
            }
            canvas.setOnMouseClicked(null);
        });
    }

    public void garp() {
        canvas.setOnMouseClicked(e -> {
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if(sceneXY[0] != 0 && sceneXY[1] != 0 && cash >= cost_garp){
                gc.drawImage(new Image("sample/image/tru_3.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_garp;
            }
            canvas.setOnMouseClicked(null);
        });
    }
    @FXML
    Label  cashId;

    @FXML
    public void initialize() {
        cashId.setText("$" + cash);
    }


}





