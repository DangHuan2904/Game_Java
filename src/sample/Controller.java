package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller {

    final double[] sceneXY = new double[2];
    final int cost_luffy = 5;
    final int cost_dragon = 8;
    final int cost_garp = 10;

    int cash = 150;

    int[] XY = new int[20];
    int index = 0;

    @FXML
    ImageView background;
    @FXML
    AnchorPane game;

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
        Image luffyImage = new Image("./sample/image/tru_1.png");

        background.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Image areas = background.getImage();
                int mouseX = (int) mouseEvent.getX();
                int mouseY = (int) mouseEvent.getY();
                PixelReader placePixels = areas.getPixelReader();
                        try {
                            if ((598 - mouseX) < 598 && (828 - mouseY) < 828) {
                                if (!placePixels.getColor(mouseX, mouseY)
                                .equals(Color.color((double) 253 / 255,(double) 253/255,(double) 153/ 255))) {
                            if (!placePixels.getColor(mouseX + 35, mouseY + 50)
                                    .equals(Color.color((double) 253 / 255,(double) 253/255,(double) 153/ 255))) {
                                if (!placePixels.getColor(mouseX + 50, mouseY + 50)
                                        .equals(Color.color((double) 253 / 255,(double) 253/255,(double) 153/ 255))) {
                                    if (!placePixels
                                            .getColor(mouseX - 50, mouseY - 50)
                                            .equals(Color.color((double) 253 / 255,(double) 253/255,(double) 153/ 255))) {
                                        ImageView luffyTurret = new ImageView(luffyImage);
                                        luffyTurret.setScaleX(0.75);
                                        luffyTurret.setScaleY(0.75);
                                        luffyTurret.setPreserveRatio(true);
                                        luffyTurret.setTranslateX(mouseX - 50);
                                        luffyTurret.setTranslateY(mouseY - 70);
                                        game.getChildren().add(luffyTurret);

                                    }
                                }
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Out of bounds");
                }
            }
        });

        /*rectangle.setOnMouseClicked(e -> {
            System.out.println("OK");
            int n = cash;
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if( coordinatesFind(sceneXY[0], sceneXY[1], XY ) != 0 && cash >= cost_luffy){
                gc.drawImage(new Image("sample/image/tru_1.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_luffy;
            }
            if ( n != cash){
                XY[index] = (int) sceneXY[0];
                XY[index + 1] = (int) sceneXY[1];
                index = index + 2;
            }
            rectangle.setOnMouseClicked(null);
        });*/
    }

    public void dragon() {
        /*canvas.setOnMouseClicked(e -> {
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if ( coordinatesFind(sceneXY[0], sceneXY[1], XY  ) != 0 && cash >= cost_dragon){
                gc.drawImage(new Image("sample/image/tru_2.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_dragon;

            }
            canvas.setOnMouseClicked(null);
        });*/
    }

    public void garp() {
        /*canvas.setOnMouseClicked(e -> {
            sceneXY[0] = e.getSceneX();
            sceneXY[1] = e.getSceneY();
            GraphicsContext gc = canvas.getGraphicsContext2D();
            if ( coordinatesFind(sceneXY[0], sceneXY[1], XY  ) != 0 && cash >= cost_garp){
                gc.drawImage(new Image("sample/image/tru_3.png"), sceneXY[0] - 35, sceneXY[1] - 50, 75,100);
                cash -= cost_garp;
            }
            canvas.setOnMouseClicked(null);
        });*/
    }


    @FXML
    Label  cashId;

    @FXML
    public void initialize(){
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                cashId.setText("$" + cash);
            }
        }.start();

    }

}





