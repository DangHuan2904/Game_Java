package GameEntity.Bullet;

import GameEntity.Tower.AbstractTower;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NormalBullet extends AbstractBullet {
    public NormalBullet(int speed) {
        this.speed = speed;
        this.imageBulletView = new ImageView(new Image("./sample/image/gun_1.png"));
        this.imageBulletView.setTranslateX(-69);
        this.imageBulletView.setTranslateX(-69);
    }
}
