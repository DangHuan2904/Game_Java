package GameEntity.Tower;

import GameEntity.Bullet.AbstractBullet;
import GameEntity.Bullet.NormalBullet;
import GameEntity.Enemy.AbstractEnemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Path;

import java.util.Stack;

public abstract class AbstractTower{
    protected int speedBullet = 0;

    protected int damage = 0;
    protected int fireRange = 0;
    protected int angle = 0;
    protected int timeShot = 0;


    protected ImageView imageBaseView;
    protected ImageView imageGunView;
    protected StackPane turret = new StackPane();

    public AbstractTower() {

    }

    public StackPane getImage(double x, double y) {
        turret.setScaleX(1.5);
        turret.setScaleY(1.5);
        turret.getChildren().addAll(imageBaseView, imageGunView);
        turret.setTranslateX(x);
        turret.setTranslateY(y);
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

    public void shoot(Pane pane, AbstractEnemy enemy) {
        AbstractBullet bullet = new NormalBullet(this.speedBullet);
        pane.getChildren().add(bullet.getImageView());
        bullet.move( turret.getTranslateX(), turret.getTranslateY(), enemy.getImageView().getTranslateX(), enemy.getImageView().getTranslateY());
        if (bullet.isShot())
            pane.getChildren().remove(bullet.getImageView());

        enemy.decreaseHP(this.damage);
    }

}
