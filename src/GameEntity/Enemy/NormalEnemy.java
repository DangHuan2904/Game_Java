package GameEntity.Enemy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy (Path path){
        super(path);
        this.speed = 25;
        this.armor = 20;
        this.money = 2;
        this.MAX_HP = 50;
        this.HP = 50;
        this.cost = 3;
        this.imagePath = "./sample/image/normalEnemy.png";
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