package GameEntity.Bullet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SniperBullet extends AbstractBullet {
    public SniperBullet(int speed, int damage) {
        this.speed = speed;
        this.imageBulletView = new ImageView(new Image("./sample/image/gun_1.png"));
        this.imageBulletView.setTranslateX(-69);
        this.imageBulletView.setTranslateX(-69);
    }
}
