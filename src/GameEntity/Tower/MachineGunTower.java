package GameEntity.Tower;

import GameEntity.Bullet.AbstractBullet;
import GameEntity.Bullet.MachineBullet;
import GameEntity.Bullet.NormalBullet;
import GameEntity.Enemy.AbstractEnemy;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class MachineGunTower extends AbstractTower {

    public MachineGunTower() {
        super();
        this.speedBullet = 1;
        this.damage = 100;
        this.fireRange = 300;
        this.angle = 0;
        this.timeShot = 1;

        this.imageBaseView = new ImageView("./sample/image/tru_2_base.png");
        this.imageGunView = new ImageView("./sample/image/tru_2_gun.png");
    }

    @Override
    public void shoot(Pane pane, AbstractEnemy enemy) {
        AbstractBullet bullet = new MachineBullet(this.speedBullet);
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
        enemy.decreaseHP(this.damage);
        enemy.getHP();
    }

}
