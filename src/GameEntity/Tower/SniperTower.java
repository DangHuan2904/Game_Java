package GameEntity.Tower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SniperTower extends AbstractTower {

    public SniperTower() {
        super();
        this.speedBullet = 4;
        this.damage = 150;
        this.fireRange = 60;
        this.angle = 0;
        this.timeShot = 1;

        this.imageBaseView = new ImageView("./sample/image/tru_3_base.png");
        this.imageGunView = new ImageView("./sample/image/tru_3_gun.png");
    }



}
