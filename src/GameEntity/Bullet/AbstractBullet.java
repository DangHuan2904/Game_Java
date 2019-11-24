package GameEntity.Bullet;

import javafx.scene.image.ImageView;


public abstract class AbstractBullet {
    protected int speed = 0;

    protected ImageView imageBulletView;

    public AbstractBullet() {

    }
    public ImageView getImageView() {
        return imageBulletView;
    }

    public int getSpeed() {
        return speed;
    }
}
