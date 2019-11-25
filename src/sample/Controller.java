package sample;

import GameEntity.Enemy.AbstractEnemy;
import GameEntity.Enemy.BossEnemy;
import GameEntity.Enemy.NormalEnemy;
import GameEntity.Enemy.TankerEnemy;
import GameEntity.Tower.AbstractTower;
import GameEntity.Tower.MachineGunTower;
import GameEntity.Tower.NormalTower;
import GameEntity.Tower.SniperTower;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    int cash = 50;
    int health = 100;
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();

    @FXML
    ImageView background;
    @FXML
    AnchorPane loadGame;


    private Scene firstScene;


    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }


    private Path generatePath() {
        Path path = new Path();
        MoveTo spawner = new MoveTo(0,440);
        LineTo lineTo1 = new LineTo(560,440);
        LineTo lineTo2 = new LineTo(560, 148);
        LineTo lineTo3 = new LineTo(805.0, 148.0);
        path.getElements().addAll(spawner, lineTo1, lineTo2, lineTo3);
        return path;
    }

    public void mainMenu(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
    }


    public void luffy() {
        background.setOnMouseClicked(mouseEvent -> {
            AbstractTower tower = new NormalTower() ;
            towers.add(tower);
            loadGame.getChildren().add(tower.getImage(loadGame, mouseEvent.getX()- 17, mouseEvent.getY()-25));
            cash -= 5;
            background.setOnMouseClicked(null);
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

        background.setOnMouseClicked(mouseEvent -> {
            AbstractTower tower = new MachineGunTower() ;
            towers.add(tower);
            loadGame.getChildren().add(tower.getImage(loadGame, mouseEvent.getX()- 17, mouseEvent.getY()-25));
            cash -= 8;
            background.setOnMouseClicked(null);
        });
    }

    public void garp() {

        background.setOnMouseClicked(mouseEvent -> {
            AbstractTower tower = new SniperTower() ;
            towers.add(tower);
            loadGame.getChildren().add(tower.getImage(loadGame, mouseEvent.getX()- 17, mouseEvent.getY()-25));
            cash -= 10;
            background.setOnMouseClicked(null);
        });
    }

    @FXML
    Button pauseId;
    @FXML
    Button continueId;
    boolean pauseGame = false;


    @FXML
    Label  cashId;
    @FXML
    Label  healthId;
    @FXML
    Button nextWare;

    public void loadWare() {
        nextWare.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                for (int i = 0; i < 100; i++) {
                    AbstractEnemy temp = new NormalEnemy(generatePath());
                    AbstractEnemy temp2 = new BossEnemy(generatePath());
                    AbstractEnemy temp3 = new TankerEnemy(generatePath());
                    enemies.add(temp);
                    enemies.add(temp2);
                    enemies.add(temp3);
                    loadGame.getChildren().add(temp.getImageView());
                    loadGame.getChildren().add(temp.getHealthBar());
                    loadGame.getChildren().add(temp2.getImageView());
                    loadGame.getChildren().add(temp2.getHealthBar());
                    loadGame.getChildren().add(temp3.getImageView());
                    loadGame.getChildren().add(temp3.getHealthBar());
                }
                new AnimationTimer() {
                    long lastUpdateTime = System.currentTimeMillis() / 1000;
                    int enemyID = 0;
                    long lastTurretUpdate = System.currentTimeMillis() / 1000;
                    long lastTurretUpdate2 = System.currentTimeMillis() / 1000;
                    long lastTurretUpdate3 = System.currentTimeMillis() / 1000;

                    @Override
                    public void handle(long l) {

                        long current = System.currentTimeMillis() / 1000;
                        long elapsedTurret = System.currentTimeMillis() / 1000 - lastTurretUpdate;
                        long elapsedTurret2 = System.currentTimeMillis() / 1000 - lastTurretUpdate2;
                        long elapsedTurret3 = System.currentTimeMillis() / 1000 - lastTurretUpdate3;

                        if (current - lastUpdateTime == 1) {
                            lastUpdateTime = current;
                            if (enemyID < enemies.size()) {
                                enemies.get(enemyID++).update(pauseGame);
                            }
                        }

                        pauseId.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                pauseGame = true;
                            }
                        });

                        /*continueId.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                pauseGame = false;
                            }
                        });*/

                        if (pauseGame) {
                            for (AbstractEnemy enemy : enemies)
                                enemy.getPathTransition().pause();
                            this.stop();
                        }
                        /*else {
                            for (AbstractEnemy enemy : enemies)
                                enemy.getPathTransition().play();
                        }*/
                        for (int i = 0; i < towers.size(); i++) {
                            if (towers.get(i).isRemovable()) {
                                towers.remove(i);
                                i--;
                            }
                        }

                        for (AbstractTower tower : towers)
                            for (AbstractEnemy enemy : enemies)
                             {
                                if (tower.inRange(enemy)) {
                                    tower.rotate(enemy);
                                    if (tower instanceof NormalTower && elapsedTurret % 3 == 1) {
                                        lastTurretUpdate = System.currentTimeMillis() / 1000;
                                        tower.shoot(loadGame, enemy);
                                    }
                                    if (tower instanceof MachineGunTower && elapsedTurret2 % 2 == 1) {
                                        lastTurretUpdate2 = System.currentTimeMillis() / 1000;
                                        tower.shoot(loadGame, enemy);
                                    }
                                    if (tower instanceof SniperTower && elapsedTurret3 % 4 == 1) {
                                        lastTurretUpdate3 = System.currentTimeMillis() / 1000;
                                        tower.shoot(loadGame, enemy);
                                    }
                                    break;
                                }
                            }


                        for (int i = 0; i < enemies.size(); i++) {
                            enemies.get(i).relocateHealthBar(enemies.get(i).getImageView().getTranslateX() + 65, enemies.get(i).getImageView().getTranslateY()+40);
                            if (enemies.get(i).isRemovable()) {
                                cash = cash + enemies.get(i).getCost();
                                loadGame.getChildren().removeAll(enemies.get(i).getImageView(), enemies.get(i).getHealthBar());
                                enemies.remove(i);
                                i--;
                            }
                        }

                        for (int i = 0; i < enemies.size(); i++) {
                            if ( enemies.get(i).isFinished())
                                health = 0;
                        }

                        healthId.setText("" + health);
                        cashId.setText("$" + cash);
                    }
                }.start();
            }

        });
    }

}





