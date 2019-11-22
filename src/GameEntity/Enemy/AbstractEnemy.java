package GameEntity.Enemy;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.List;

public abstract class AbstractEnemy {
    protected int speed = 1;
    protected int armor = 0;
    protected int money = 0;
    protected int MAX_HP = 0;
    protected int HP;
    protected String imagePath = "./sample/image/normalEnemy.png";
    protected Path path;
    protected int timeSpeed = 12000 * speed;

    public boolean isRemovable() {
        return removable;
    }

    protected boolean removable;

    protected Image image;
    protected ImageView imageView;
    protected PathTransition pathTransition;

    public AbstractEnemy(Path path) {
        this.path = path;

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void update() {
        pathTransition = new PathTransition(Duration.millis(timeSpeed), path, imageView);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removable = true;
            }
        });
    }

    public void decreaseHP( int damage){
        this.HP = this.HP - damage - this.armor;
        if ( HP <= 0 )
            HP = 0;
    }
}

