package GameEntity.Tower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MachineGunTower extends AbstractTower {

    public MachineGunTower() {
        super();
        this.speedBullet = 1;
        this.damage = 30;
        this.fireRange = 30;
        this.angle = 0;
        this.timeShot = 1;

        this.imageBaseView = new ImageView("./sample/image/tru_2_base.png");
        this.imageGunView = new ImageView("./sample/image/tru_2_gun.png");
    }



}
