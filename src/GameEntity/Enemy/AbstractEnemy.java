package GameEntity.Enemy;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.util.Duration;


import java.util.List;

public abstract class AbstractEnemy {
    protected int speed = 1;
    protected int armor = 0;
    protected int money = 0;
    protected int MAX_HP = 0;
    public int HP = 0;
    protected int cost = 0;
    protected String imagePath = "./sample/image/normalEnemy.png";
    protected Path path;

    protected HealthBar healthBar = new HealthBar();


    public boolean isRemovable() {
        return removable;
    }

    protected boolean removable;
    protected boolean finished;

    public boolean isFinished() {
        return finished;
    }

    protected Image image;
    protected ImageView imageView;

    public PathTransition getPathTransition() {
        return pathTransition;
    }

    protected PathTransition pathTransition;


    public AbstractEnemy(Path path) {
        this.path = path;
    }

    public void decreaseHP( int damage){
        this.HP = this.HP - damage + this.armor;
        this.healthBar.setValue(HP / MAX_HP);
        if ( HP <= 0 )
        {
            HP = 0;
            removable = true;
        }
    }

    public int gethp(){
        return this.HP;
    }

    public void getHP(){
        healthBar.setValue(HP / MAX_HP);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Pane getHealthBar() {
        this.healthBar.setTranslateX(-69);
        this.healthBar.setTranslateY(-69);
        return this.healthBar;
    }


    public void relocateHealthBar(double x, double y) {
        this.healthBar.relocate(x, y);
    }

    public int getCost() {
        return cost;
    }

    public void update(boolean pause) {
        pathTransition = new PathTransition(Duration.millis(speed * 1000), path, imageView);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                removable = true;
                finished = true;
            }
        });
        if (pause)
            pathTransition.pause();
    }


}

