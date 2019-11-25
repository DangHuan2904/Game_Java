package GameEntity.Tower;

import GameEntity.Bullet.AbstractBullet;
import GameEntity.Bullet.NormalBullet;
import GameEntity.Enemy.AbstractEnemy;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class AbstractTower{
    protected int speedBullet = 0;

    protected int damage = 0;
    protected int fireRange = 0;


    protected int angle = 0;
    protected int timeShot = 0;

    public boolean isRemovable() {
        return removable;
    }

    protected boolean removable = false;


    public ImageView imageBaseView;
    public ImageView imageGunView;
    protected StackPane turret = new StackPane();

    public AbstractTower() {

    }

    public StackPane getImage(Pane loadGame, double x, double y) {
        turret.setScaleX(1.5);
        turret.setScaleY(1.5);
        turret.getChildren().addAll(imageBaseView, imageGunView);
        turret.setTranslateX(x);
        turret.setTranslateY(y);
        turret.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    if(mouseEvent.getClickCount() == 2){
                        loadGame.getChildren().remove(turret);
                        removable = true;
                    }
                }
            }
        });
        return turret;
    }

    public Pane getPane() {
        return turret;
    }

    public boolean inRange(AbstractEnemy enemy) {

        double towerX = turret.getTranslateX();
        double towerY = turret.getTranslateY();
        double enemyX = enemy.getImageView().getTranslateX();
        double enemyY = enemy.getImageView().getTranslateY();

        double d = Math.sqrt( (towerX - enemyX) * (towerX - enemyX) + (towerY - enemyY) * (towerY - enemyY));

        if ( d <= fireRange )
            return true;
        return false;
    }

    public void rotate(AbstractEnemy enemy) {
        double angle = 0;
            angle = Math.toDegrees(Math.atan2( -enemy.getImageView().getTranslateY() + imageGunView.getTranslateY(),
                -enemy.getImageView().getTranslateX() + imageGunView.getTranslateX()));
        imageGunView.setRotate(angle);
    }

    public void shoot(Pane pane, AbstractEnemy enemy) {
            AbstractBullet bullet = new NormalBullet(this.speedBullet);
            pane.getChildren().add(bullet.getImageView());

            double sourceX = turret.getTranslateX() + 18, sourceY = turret.getTranslateY() + 50;
            double desX = enemy.getImageView().getTranslateX(), desY = enemy.getImageView().getTranslateY();
            MoveTo spawn = new MoveTo(sourceX, sourceY);
            LineTo target = new LineTo(desX, desY);
            Path path = new Path();
            path.getElements().addAll(spawn, target);

            PathTransition bulletMove = new PathTransition(Duration.millis(1000), path, bullet.getImageView());
            bulletMove.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            bulletMove.play();
            bulletMove.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    pane.getChildren().remove(bullet.getImageView());
                }
            });
    }

}
