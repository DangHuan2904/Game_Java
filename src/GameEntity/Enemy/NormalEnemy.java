package GameEntity.Enemy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy (Path path){
        super(path);
        this.speed = 1;
        this.armor = 50;
        this.money = 2;
        this.MAX_HP = 200;
        this.HP = 200;
        this.imagePath = "./sample/image/normalEnemy.png";
        this.image = new Image(imagePath);
        this.imageView = new ImageView(image);
        this.imageView.setTranslateX(-69);
        this.imageView.setTranslateY(-69);
    }


}