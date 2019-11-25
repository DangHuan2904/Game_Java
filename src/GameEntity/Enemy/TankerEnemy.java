package GameEntity.Enemy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class TankerEnemy extends AbstractEnemy {
    public TankerEnemy (Path path){
        super(path);
        this.speed = 35;
        this.armor = 50;
        this.money = 5;
        this.MAX_HP = 200;
        this.HP = 200;
        this.cost = 5;
        this.imagePath = "./sample/image/tankerEnemy.png";
        this.image = new Image(imagePath);
        this.imageView = new ImageView(image);
        this.imageView.setTranslateX(-69);
        this.imageView.setTranslateY(-69);
    }

    @Override
    public void decreaseHP( int damage){
        this.HP = this.HP - damage + this.armor;
        this.healthBar.setValue(HP / MAX_HP);
        if ( HP <= 0 )
        {
            HP = 0;
            removable = true;
        }
    }

    public void getHP(){
        healthBar.setValue(HP / MAX_HP);
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
    public int getCost() {
        return cost;
    }
}