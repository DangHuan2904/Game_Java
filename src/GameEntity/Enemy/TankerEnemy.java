package GameEntity.Enemy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class TankerEnemy extends AbstractEnemy {
    public TankerEnemy (Path path){
        super(path);
        this.speed = 3;
        this.armor = 100;
        this.money = 5;
        this.MAX_HP = 500;
        this.HP = 500;
        this.imagePath = "./sample/image/tankerEnemy.png";
        this.image = new Image(imagePath);
        this.imageView = new ImageView(image);
        this.imageView.setTranslateX(-69);
        this.imageView.setTranslateY(-69);
    }


}