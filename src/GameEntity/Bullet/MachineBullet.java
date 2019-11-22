package GameEntity.Bullet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MachineBullet extends AbstractBullet {



    public MachineBullet(int speed) {
        this.speed = speed;
        this.imageBulletView = new ImageView(new Image("./sample/image/gun_1.png"));
        this.imageBulletView.setTranslateX(-69);
        this.imageBulletView.setTranslateX(-69);
    }
}
