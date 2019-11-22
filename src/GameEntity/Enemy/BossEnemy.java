package GameEntity.Enemy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy (Path path){
        super(path);
        this.speed = 4;
        this.armor = 100;
        this.money = 5;
        this.MAX_HP = 500;
        this.HP = 500;
        this.imagePath = "./sample/image/bossEnemy.png";
        this.image = new Image(imagePath);
        this.imageView = new ImageView(image);
        this.imageView.setTranslateX(-69);
        this.imageView.setTranslateY(-69);

    }




}