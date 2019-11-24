package GameEntity.Tower;


import javafx.scene.image.ImageView;

public class NormalTower extends AbstractTower {

    public NormalTower() {
        super();
        this.speedBullet = 3;
        this.damage = 50;
        this.fireRange = 300;
        this.angle = 0;
        this.timeShot = 1;

        this.imageBaseView = new ImageView("./sample/image/tru_1_base.png");
        this.imageGunView = new ImageView("./sample/image/tru_1_gun.png");
    }



}
